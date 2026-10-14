package bi.gov.burundi.parcelle.service;

import bi.gov.burundi.parcelle.dto.ParcelleRequest;
import bi.gov.burundi.parcelle.dto.ParcelleResponse;
import bi.gov.burundi.parcelle.entity.Parcelle;
import bi.gov.burundi.parcelle.repository.ParcelleRepository;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParcelleService {

    private final ParcelleRepository repository;
    private final GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);

    public ParcelleService(ParcelleRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ParcelleResponse creer(ParcelleRequest request) {
        if (request.getCoordonnees() == null || request.getCoordonnees().size() < 3) {
            throw new RuntimeException("Au moins 3 coordonnées sont nécessaires");
        }

        Coordinate[] coords = request.getCoordonnees().stream()
                .map(c -> new Coordinate(c.getLongitude(), c.getLatitude()))
                .toArray(Coordinate[]::new);

        if (!coords[0].equals2D(coords[coords.length - 1])) {
            Coordinate[] closed = new Coordinate[coords.length + 1];
            System.arraycopy(coords, 0, closed, 0, coords.length);
            closed[coords.length] = coords[0];
            coords = closed;
        }

        Polygon polygone = geometryFactory.createPolygon(coords);

        Parcelle p = new Parcelle();
        p.setCodeParcelle(request.getCodeParcelle());
        p.setProprietaireId(request.getProprietaireId());
        p.setMoniteurId(request.getMoniteurId());
        p.setGeometrie(polygone);
        p.setTypeSol(request.getTypeSol());
        p.setAltitudeMoyenneM(request.getAltitudeMoyenneM());

        Parcelle saved = repository.save(p);

        Double superficie = repository.calculerSuperficie(saved.getId());
        if (superficie != null) {
            saved.setSuperficieHa(BigDecimal.valueOf(superficie).setScale(4, RoundingMode.HALF_UP));
            repository.save(saved);
        }

        return ParcelleResponse.fromEntity(saved);
    }

    public ParcelleResponse getById(UUID id) {
        Parcelle p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parcelle non trouvée"));
        return ParcelleResponse.fromEntity(p);
    }

    public List<ParcelleResponse> getByProprietaire(UUID proprietaireId) {
        return repository.findByProprietaireId(proprietaireId).stream()
                .map(ParcelleResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public List<ParcelleResponse> getAll() {
        return repository.findAll().stream()
                .map(ParcelleResponse::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public void valider(UUID id) {
        Parcelle p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parcelle non trouvée"));
        p.setEstValidee(true);
        repository.save(p);
    }

    @Transactional
    public void supprimer(UUID id) {
        repository.deleteById(id);
    }
}
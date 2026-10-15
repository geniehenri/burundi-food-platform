package bi.gov.burundi.parcelle.service;

import bi.gov.burundi.parcelle.dto.PlantationRequest;
import bi.gov.burundi.parcelle.entity.Culture;
import bi.gov.burundi.parcelle.entity.Plantation;
import bi.gov.burundi.parcelle.repository.CultureRepository;
import bi.gov.burundi.parcelle.repository.ParcelleRepository;
import bi.gov.burundi.parcelle.repository.PlantationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;

@Service
public class PlantationService {

    private final PlantationRepository plantationRepository;
    private final ParcelleRepository parcelleRepository;
    private final CultureRepository cultureRepository;

    public PlantationService(PlantationRepository plantationRepository,
                             ParcelleRepository parcelleRepository,
                             CultureRepository cultureRepository) {
        this.plantationRepository = plantationRepository;
        this.parcelleRepository = parcelleRepository;
        this.cultureRepository = cultureRepository;
    }

    @Transactional
    public Plantation creer(PlantationRequest request) {
        parcelleRepository.findById(request.getParcelleId())
                .orElseThrow(() -> new RuntimeException("Parcelle non trouvée"));

        Culture culture = cultureRepository.findById(request.getCultureId())
                .orElseThrow(() -> new RuntimeException("Culture non trouvée"));

        BigDecimal rendementPrevu = null;
        if (culture.getRendementOptimalKgHa() != null) {
            rendementPrevu = culture.getRendementOptimalKgHa()
                    .multiply(request.getSuperficieCultiveeHa())
                    .setScale(2, RoundingMode.HALF_UP);
        }

        Plantation plantation = new Plantation();
        plantation.setParcelleId(request.getParcelleId());
        plantation.setCultureId(request.getCultureId());
        plantation.setSaisonId(request.getSaisonId());
        plantation.setDateSemis(request.getDateSemis());
        plantation.setSuperficieCultiveeHa(request.getSuperficieCultiveeHa());
        plantation.setRendementPrevuKg(rendementPrevu);
        plantation.setStatut("EN_COURS");

        return plantationRepository.save(plantation);
    }

    public List<Plantation> getByParcelle(UUID parcelleId) {
        return plantationRepository.findByParcelleId(parcelleId);
    }

    public List<Plantation> getAll() {
        return plantationRepository.findAll();
    }

    public Plantation getById(UUID id) {
        return plantationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plantation non trouvée"));
    }
}
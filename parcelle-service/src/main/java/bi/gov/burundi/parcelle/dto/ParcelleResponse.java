package bi.gov.burundi.parcelle.dto;

import bi.gov.burundi.parcelle.entity.Parcelle;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ParcelleResponse {

    private UUID id;
    private String codeParcelle;
    private UUID proprietaireId;
    private UUID moniteurId;
    private BigDecimal superficieHa;
    private String typeSol;
    private BigDecimal altitudeMoyenneM;
    private String geometrieWkt;
    private LocalDateTime dateReleve;
    private Boolean estValidee;

    public static ParcelleResponse fromEntity(Parcelle p) {
        ParcelleResponse dto = new ParcelleResponse();
        dto.id = p.getId();
        dto.codeParcelle = p.getCodeParcelle();
        dto.proprietaireId = p.getProprietaireId();
        dto.moniteurId = p.getMoniteurId();
        dto.superficieHa = p.getSuperficieHa();
        dto.typeSol = p.getTypeSol();
        dto.altitudeMoyenneM = p.getAltitudeMoyenneM();
        dto.geometrieWkt = p.getGeometrie() != null ? p.getGeometrie().toText() : null;
        dto.dateReleve = p.getDateReleve();
        dto.estValidee = p.getEstValidee();
        return dto;
    }

    // Getters
    public UUID getId() { return id; }
    public String getCodeParcelle() { return codeParcelle; }
    public UUID getProprietaireId() { return proprietaireId; }
    public UUID getMoniteurId() { return moniteurId; }
    public BigDecimal getSuperficieHa() { return superficieHa; }
    public String getTypeSol() { return typeSol; }
    public BigDecimal getAltitudeMoyenneM() { return altitudeMoyenneM; }
    public String getGeometrieWkt() { return geometrieWkt; }
    public LocalDateTime getDateReleve() { return dateReleve; }
    public Boolean getEstValidee() { return estValidee; }
}
package bi.gov.burundi.parcelle.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "plantations", uniqueConstraints = @UniqueConstraint(columnNames = {"parcelle_id", "saison_id"}))
public class Plantation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "parcelle_id", nullable = false)
    private UUID parcelleId;

    @Column(name = "culture_id", nullable = false)
    private Integer cultureId;

    @Column(name = "saison_id", nullable = false)
    private Integer saisonId;

    @Column(name = "date_semis", nullable = false)
    private LocalDate dateSemis;

    @Column(name = "superficie_cultivee_ha", nullable = false, precision = 10, scale = 4)
    private BigDecimal superficieCultiveeHa;

    @Column(name = "rendement_prevu_kg", precision = 12, scale = 2)
    private BigDecimal rendementPrevuKg;

    @Column(name = "rendement_reel_kg", precision = 12, scale = 2)
    private BigDecimal rendementReelKg;

    @Column(name = "date_recolte")
    private LocalDate dateRecolte;

    @Column(length = 50)
    private String statut = "EN_COURS";

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getParcelleId() { return parcelleId; }
    public void setParcelleId(UUID parcelleId) { this.parcelleId = parcelleId; }
    public Integer getCultureId() { return cultureId; }
    public void setCultureId(Integer cultureId) { this.cultureId = cultureId; }
    public Integer getSaisonId() { return saisonId; }
    public void setSaisonId(Integer saisonId) { this.saisonId = saisonId; }
    public LocalDate getDateSemis() { return dateSemis; }
    public void setDateSemis(LocalDate dateSemis) { this.dateSemis = dateSemis; }
    public BigDecimal getSuperficieCultiveeHa() { return superficieCultiveeHa; }
    public void setSuperficieCultiveeHa(BigDecimal superficieCultiveeHa) { this.superficieCultiveeHa = superficieCultiveeHa; }
    public BigDecimal getRendementPrevuKg() { return rendementPrevuKg; }
    public void setRendementPrevuKg(BigDecimal rendementPrevuKg) { this.rendementPrevuKg = rendementPrevuKg; }
    public BigDecimal getRendementReelKg() { return rendementReelKg; }
    public void setRendementReelKg(BigDecimal rendementReelKg) { this.rendementReelKg = rendementReelKg; }
    public LocalDate getDateRecolte() { return dateRecolte; }
    public void setDateRecolte(LocalDate dateRecolte) { this.dateRecolte = dateRecolte; }
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
}
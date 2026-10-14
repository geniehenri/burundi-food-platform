package bi.gov.burundi.parcelle.entity;

import jakarta.persistence.*;
import org.locationtech.jts.geom.Polygon;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "parcelles")
public class Parcelle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "code_parcelle", unique = true, nullable = false, length = 50)
    private String codeParcelle;

    @Column(name = "proprietaire_id", nullable = false)
    private UUID proprietaireId;

    @Column(name = "moniteur_id")
    private UUID moniteurId;

    @Column(columnDefinition = "geometry(Polygon, 4326)", nullable = false)
    private Polygon geometrie;

    @Column(name = "superficie_ha", precision = 10, scale = 4)
    private BigDecimal superficieHa;

    @Column(name = "type_sol", length = 100)
    private String typeSol;

    @Column(name = "altitude_moyenne_m", precision = 6, scale = 2)
    private BigDecimal altitudeMoyenneM;

    @Column(name = "date_releve")
    private LocalDateTime dateReleve = LocalDateTime.now();

    @Column(name = "est_validee")
    private Boolean estValidee = false;

    // Getters & Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getCodeParcelle() { return codeParcelle; }
    public void setCodeParcelle(String codeParcelle) { this.codeParcelle = codeParcelle; }
    public UUID getProprietaireId() { return proprietaireId; }
    public void setProprietaireId(UUID proprietaireId) { this.proprietaireId = proprietaireId; }
    public UUID getMoniteurId() { return moniteurId; }
    public void setMoniteurId(UUID moniteurId) { this.moniteurId = moniteurId; }
    public Polygon getGeometrie() { return geometrie; }
    public void setGeometrie(Polygon geometrie) { this.geometrie = geometrie; }
    public BigDecimal getSuperficieHa() { return superficieHa; }
    public void setSuperficieHa(BigDecimal superficieHa) { this.superficieHa = superficieHa; }
    public String getTypeSol() { return typeSol; }
    public void setTypeSol(String typeSol) { this.typeSol = typeSol; }
    public BigDecimal getAltitudeMoyenneM() { return altitudeMoyenneM; }
    public void setAltitudeMoyenneM(BigDecimal altitudeMoyenneM) { this.altitudeMoyenneM = altitudeMoyenneM; }
    public LocalDateTime getDateReleve() { return dateReleve; }
    public void setDateReleve(LocalDateTime dateReleve) { this.dateReleve = dateReleve; }
    public Boolean getEstValidee() { return estValidee; }
    public void setEstValidee(Boolean estValidee) { this.estValidee = estValidee; }
}
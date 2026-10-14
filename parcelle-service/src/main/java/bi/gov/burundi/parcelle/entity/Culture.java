package bi.gov.burundi.parcelle.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cultures")
public class Culture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 100)
    private String nom;

    @Column(name = "cycle_jours", nullable = false)
    private Integer cycleJours;

    @Column(name = "besoin_eau_total_mm", nullable = false, precision = 6, scale = 2)
    private BigDecimal besoinEauTotalMm;

    @Column(name = "rendement_optimal_kg_ha", precision = 10, scale = 2)
    private BigDecimal rendementOptimalKgHa;

    @Column(name = "dose_engrais_npk_kg_ha", precision = 10, scale = 2)
    private BigDecimal doseEngraisNpkKgHa;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public Integer getCycleJours() { return cycleJours; }
    public void setCycleJours(Integer cycleJours) { this.cycleJours = cycleJours; }
    public BigDecimal getBesoinEauTotalMm() { return besoinEauTotalMm; }
    public void setBesoinEauTotalMm(BigDecimal besoinEauTotalMm) { this.besoinEauTotalMm = besoinEauTotalMm; }
    public BigDecimal getRendementOptimalKgHa() { return rendementOptimalKgHa; }
    public void setRendementOptimalKgHa(BigDecimal rendementOptimalKgHa) { this.rendementOptimalKgHa = rendementOptimalKgHa; }
    public BigDecimal getDoseEngraisNpkKgHa() { return doseEngraisNpkKgHa; }
    public void setDoseEngraisNpkKgHa(BigDecimal doseEngraisNpkKgHa) { this.doseEngraisNpkKgHa = doseEngraisNpkKgHa; }
}
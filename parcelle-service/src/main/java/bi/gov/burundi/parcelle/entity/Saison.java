package bi.gov.burundi.parcelle.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "saisons", uniqueConstraints = @UniqueConstraint(columnNames = {"nom", "annee"}))
public class Saison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(nullable = false)
    private Integer annee;

    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "date_fin", nullable = false)
    private LocalDate dateFin;

    @Column(name = "est_active")
    private Boolean estActive = false;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public Integer getAnnee() { return annee; }
    public void setAnnee(Integer annee) { this.annee = annee; }
    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }
    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }
    public Boolean getEstActive() { return estActive; }
    public void setEstActive(Boolean estActive) { this.estActive = estActive; }
}
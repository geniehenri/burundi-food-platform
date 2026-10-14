package bi.gov.burundi.parcelle.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ParcelleRequest {

    // ✅ Plus de @NotBlank : le code est généré automatiquement
    private String codeParcelle;

    @NotNull
    private UUID proprietaireId;

    private UUID moniteurId;

    @NotEmpty
    private List<Coord> coordonnees;

    private String typeSol;
    private BigDecimal altitudeMoyenneM;

    // ... reste inchangé
    public static class Coord {
        private double latitude;
        private double longitude;
        public double getLatitude() { return latitude; }
        public void setLatitude(double latitude) { this.latitude = latitude; }
        public double getLongitude() { return longitude; }
        public void setLongitude(double longitude) { this.longitude = longitude; }
    }

    public String getCodeParcelle() { return codeParcelle; }
    public void setCodeParcelle(String codeParcelle) { this.codeParcelle = codeParcelle; }
    public UUID getProprietaireId() { return proprietaireId; }
    public void setProprietaireId(UUID proprietaireId) { this.proprietaireId = proprietaireId; }
    public UUID getMoniteurId() { return moniteurId; }
    public void setMoniteurId(UUID moniteurId) { this.moniteurId = moniteurId; }
    public List<Coord> getCoordonnees() { return coordonnees; }
    public void setCoordonnees(List<Coord> coordonnees) { this.coordonnees = coordonnees; }
    public String getTypeSol() { return typeSol; }
    public void setTypeSol(String typeSol) { this.typeSol = typeSol; }
    public BigDecimal getAltitudeMoyenneM() { return altitudeMoyenneM; }
    public void setAltitudeMoyenneM(BigDecimal altitudeMoyenneM) { this.altitudeMoyenneM = altitudeMoyenneM; }
}
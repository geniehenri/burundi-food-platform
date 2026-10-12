package bi.gov.burundi.user.dto;

import bi.gov.burundi.user.entity.Role;
import bi.gov.burundi.user.entity.Utilisateur;

import java.time.LocalDateTime;
import java.util.UUID;

public class UtilisateurDTO {

    private UUID id;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private Role role;
    private String province;
    private String commune;
    private String colline;
    private Boolean estActif;
    private LocalDateTime dateCreation;

    public static UtilisateurDTO fromEntity(Utilisateur u) {
        UtilisateurDTO dto = new UtilisateurDTO();
        dto.id = u.getId();
        dto.nom = u.getNom();
        dto.prenom = u.getPrenom();
        dto.telephone = u.getTelephone();
        dto.email = u.getEmail();
        dto.role = u.getRole();
        dto.province = u.getProvince();
        dto.commune = u.getCommune();
        dto.colline = u.getColline();
        dto.estActif = u.getEstActif();
        dto.dateCreation = u.getDateCreation();
        return dto;
    }

    // Getters
    public UUID getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getTelephone() { return telephone; }
    public String getEmail() { return email; }
    public Role getRole() { return role; }
    public String getProvince() { return province; }
    public String getCommune() { return commune; }
    public String getColline() { return colline; }
    public Boolean getEstActif() { return estActif; }
    public LocalDateTime getDateCreation() { return dateCreation; }
}
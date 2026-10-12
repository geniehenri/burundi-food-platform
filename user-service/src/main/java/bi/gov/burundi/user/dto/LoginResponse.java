package bi.gov.burundi.user.dto;

public class LoginResponse {

    private String token;
    private String role;
    private String userId;
    private String nom;
    private String prenom;

    public LoginResponse(String token,
         String role, String userId, 
         String nom,
          String prenom) {
        this.token = token;
        this.role = role;
        this.userId = userId;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getToken() { return token; }
    public String getRole() { return role; }
    public String getUserId() { return userId; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
}
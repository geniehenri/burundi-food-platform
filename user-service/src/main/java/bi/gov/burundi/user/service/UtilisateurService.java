package bi.gov.burundi.user.service;

import bi.gov.burundi.user.dto.*;
import bi.gov.burundi.user.entity.Role;
import bi.gov.burundi.user.entity.Utilisateur;
import bi.gov.burundi.user.repository.UtilisateurRepository;
import bi.gov.burundi.user.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UtilisateurService {

    private final UtilisateurRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UtilisateurService(UtilisateurRepository repository,
                              PasswordEncoder passwordEncoder,
                              JwtService jwtService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Transactional
    public UtilisateurDTO inscrire(RegisterRequest request) {
        if (repository.existsByTelephone(request.getTelephone())) {
            throw new RuntimeException("Ce numéro de téléphone est déjà utilisé");
        }
        if (request.getEmail() != null && !request.getEmail().isEmpty()
                && repository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Cet email est déjà utilisé");
        }

        Utilisateur u = new Utilisateur();
        u.setNom(request.getNom());
        u.setPrenom(request.getPrenom());
        u.setTelephone(request.getTelephone());
        u.setEmail(request.getEmail());
        u.setMotDePasseHash(passwordEncoder.encode(request.getMotDePasse()));
        u.setRole(request.getRole());
        u.setProvince(request.getProvince());
        u.setCommune(request.getCommune());
        u.setColline(request.getColline());
        u.setEstActif(true);
        u.setDateCreation(LocalDateTime.now());

        Utilisateur saved = repository.save(u);
        return UtilisateurDTO.fromEntity(saved);
    }

    @Transactional
    public LoginResponse connecter(LoginRequest request) {
        Utilisateur u = repository.findByTelephone(request.getTelephone())
                .orElseThrow(() -> new RuntimeException("Identifiants invalides"));

        if (!u.getEstActif()) {
            throw new RuntimeException("Compte désactivé");
        }

        if (!passwordEncoder.matches(request.getMotDePasse(), u.getMotDePasseHash())) {
            throw new RuntimeException("Identifiants invalides");
        }

        u.setDerniereConnexion(LocalDateTime.now());
        repository.save(u);

        String token = jwtService.genererToken(
                u.getTelephone(),
                u.getRole().name(),
                u.getId().toString()
        );

        return new LoginResponse(
                token,
                u.getRole().name(),
                u.getId().toString(),
                u.getNom(),
                u.getPrenom()
        );
    }

    public UtilisateurDTO getById(UUID id) {
        Utilisateur u = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        return UtilisateurDTO.fromEntity(u);
    }

    public List<UtilisateurDTO> getAll() {
        return repository.findAll().stream()
                .map(UtilisateurDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public List<UtilisateurDTO> getByRole(Role role) {
        return repository.findByRole(role).stream()
                .map(UtilisateurDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public void activerDesactiver(UUID id, boolean actif) {
        Utilisateur u = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        u.setEstActif(actif);
        repository.save(u);
    }
}
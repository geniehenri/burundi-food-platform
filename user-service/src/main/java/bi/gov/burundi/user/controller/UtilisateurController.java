package bi.gov.burundi.user.controller;

import bi.gov.burundi.user.dto.UtilisateurDTO;
import bi.gov.burundi.user.entity.Role;
import bi.gov.burundi.user.repository.UtilisateurRepository;
import bi.gov.burundi.user.service.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UtilisateurController {

    private final UtilisateurService service;
    private final UtilisateurRepository repository;

    public UtilisateurController(UtilisateurService service,
                                 UtilisateurRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping
    public List<UtilisateurDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public UtilisateurDTO getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping("/role/{role}")
    public List<UtilisateurDTO> getByRole(@PathVariable Role role) {
        return service.getByRole(role);
    }

    // ✅ NOUVEAU : Recherche par téléphone
    @GetMapping("/search")
    public ResponseEntity<?> searchByTelephone(@RequestParam String telephone) {
        return repository.findByTelephone(telephone)
                .map(u -> ResponseEntity.ok(UtilisateurDTO.fromEntity(u)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/activer")
    public ResponseEntity<?> activer(@PathVariable UUID id) {
        service.activerDesactiver(id, true);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/desactiver")
    public ResponseEntity<?> desactiver(@PathVariable UUID id) {
        service.activerDesactiver(id, false);
        return ResponseEntity.ok().build();
    }
}
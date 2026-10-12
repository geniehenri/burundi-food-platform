package bi.gov.burundi.user.controller;

import bi.gov.burundi.user.dto.UtilisateurDTO;
import bi.gov.burundi.user.entity.Role;
import bi.gov.burundi.user.service.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UtilisateurController {

    private final UtilisateurService service;

    public UtilisateurController(UtilisateurService service) {
        this.service = service;
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
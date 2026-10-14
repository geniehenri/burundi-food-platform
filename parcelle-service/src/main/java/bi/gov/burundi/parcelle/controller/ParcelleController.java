package bi.gov.burundi.parcelle.controller;

import bi.gov.burundi.parcelle.dto.ParcelleRequest;
import bi.gov.burundi.parcelle.dto.ParcelleResponse;
import bi.gov.burundi.parcelle.service.ParcelleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/parcelles")
public class ParcelleController {

    private final ParcelleService service;

    public ParcelleController(ParcelleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ParcelleResponse> creer(@Valid @RequestBody ParcelleRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.creer(request));
    }

    @GetMapping
    public List<ParcelleResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ParcelleResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping("/proprietaire/{proprietaireId}")
    public List<ParcelleResponse> getByProprietaire(@PathVariable UUID proprietaireId) {
        return service.getByProprietaire(proprietaireId);
    }

    @PatchMapping("/{id}/valider")
    public ResponseEntity<?> valider(@PathVariable UUID id) {
        service.valider(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> supprimer(@PathVariable UUID id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
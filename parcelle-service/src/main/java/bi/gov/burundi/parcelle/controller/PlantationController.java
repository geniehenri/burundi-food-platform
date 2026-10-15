package bi.gov.burundi.parcelle.controller;

import bi.gov.burundi.parcelle.dto.PlantationRequest;
import bi.gov.burundi.parcelle.entity.Plantation;
import bi.gov.burundi.parcelle.service.PlantationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/plantations")
public class PlantationController {

    private final PlantationService service;

    public PlantationController(PlantationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Plantation> creer(@Valid @RequestBody PlantationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.creer(request));
    }

    @GetMapping
    public List<Plantation> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Plantation getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping("/parcelle/{parcelleId}")
    public List<Plantation> getByParcelle(@PathVariable UUID parcelleId) {
        return service.getByParcelle(parcelleId);
    }
}
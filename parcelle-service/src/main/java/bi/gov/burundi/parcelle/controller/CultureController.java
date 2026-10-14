package bi.gov.burundi.parcelle.controller;

import bi.gov.burundi.parcelle.entity.Culture;
import bi.gov.burundi.parcelle.repository.CultureRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cultures")
public class CultureController {

    private final CultureRepository repository;

    public CultureController(CultureRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Culture> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Culture getById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Culture non trouvée"));
    }

    @PostMapping
    public Culture creer(@RequestBody Culture culture) {
        return repository.save(culture);
    }
}
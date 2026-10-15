package bi.gov.burundi.parcelle.repository;

import bi.gov.burundi.parcelle.entity.Saison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaisonRepository extends JpaRepository<Saison, Integer> {
    List<Saison> findByEstActiveTrue();
}
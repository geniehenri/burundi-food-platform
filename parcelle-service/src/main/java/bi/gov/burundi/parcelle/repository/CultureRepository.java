package bi.gov.burundi.parcelle.repository;

import bi.gov.burundi.parcelle.entity.Culture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CultureRepository extends JpaRepository<Culture, Integer> {
    Optional<Culture> findByNom(String nom);
}
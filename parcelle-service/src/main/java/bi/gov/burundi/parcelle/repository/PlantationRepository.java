package bi.gov.burundi.parcelle.repository;

import bi.gov.burundi.parcelle.entity.Plantation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PlantationRepository extends JpaRepository<Plantation, UUID> {
    List<Plantation> findByParcelleId(UUID parcelleId);
    List<Plantation> findBySaisonId(Integer saisonId);
    List<Plantation> findByStatut(String statut);
}
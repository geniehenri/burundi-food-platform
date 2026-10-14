package bi.gov.burundi.parcelle.repository;

import bi.gov.burundi.parcelle.entity.Parcelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ParcelleRepository extends JpaRepository<Parcelle, UUID> {

    List<Parcelle> findByProprietaireId(UUID proprietaireId);
    List<Parcelle> findByMoniteurId(UUID moniteurId);

    @Query(value = "SELECT ST_Area(geometrie::geography) / 10000 FROM parcelles WHERE id = :id",
           nativeQuery = true)
    Double calculerSuperficie(@Param("id") UUID id);
}
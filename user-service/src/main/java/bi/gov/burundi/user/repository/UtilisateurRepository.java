package bi.gov.burundi.user.repository;

import bi.gov.burundi.user.entity.Role;
import bi.gov.burundi.user.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, UUID> {

    Optional<Utilisateur> findByTelephone(String telephone);

    Optional<Utilisateur> findByEmail(String email);

    boolean existsByTelephone(String telephone);

    boolean existsByEmail(String email);

    List<Utilisateur> findByRole(Role role);

    List<Utilisateur> findByProvince(String province);

    List<Utilisateur> findByRoleAndProvince(Role role, String province);
}
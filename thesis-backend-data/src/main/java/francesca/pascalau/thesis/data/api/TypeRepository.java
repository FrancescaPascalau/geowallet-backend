package francesca.pascalau.thesis.data.api;

import francesca.pascalau.thesis.data.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TypeRepository extends JpaRepository<Type, UUID> {

    Optional<Type> findOneByDescriptionIgnoreCase(String type);
}

package francesca.pascalau.thesis.data.api;

import francesca.pascalau.thesis.data.entity.Surface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SurfaceRepository extends JpaRepository<Surface, UUID> {
}
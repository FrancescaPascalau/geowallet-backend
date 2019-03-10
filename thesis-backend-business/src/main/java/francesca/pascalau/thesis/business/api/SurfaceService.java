package francesca.pascalau.thesis.business.api;

import francesca.pascalau.thesis.data.entity.Surface;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SurfaceService {

    Surface saveSurface(Surface surface);

    UUID addArea(BigDecimal area);

    List<Surface> getAllSurfaces();

    long countRows();

    void deleteById(UUID id);

    void deleteAll();

    List<Surface> findAll();

    Optional<Surface> findById(UUID id);

    List<Surface> saveAll(List<Surface> listSurfaces);

    Optional<Surface> findByArea(BigDecimal area);

    void deleteByArea(BigDecimal area);
}

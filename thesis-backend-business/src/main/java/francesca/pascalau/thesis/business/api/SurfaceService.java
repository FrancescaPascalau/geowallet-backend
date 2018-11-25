package francesca.pascalau.thesis.business.api;

import francesca.pascalau.thesis.data.entity.Surface;

import java.math.BigDecimal;
import java.util.List;

public interface SurfaceService {

    public void addSurface(BigDecimal area);

    public List<Surface> getAllSurfaces();
}

package francesca.pascalau.thesis.business.impl;

import francesca.pascalau.thesis.business.api.SurfaceService;
import francesca.pascalau.thesis.data.api.SurfaceRepository;
import francesca.pascalau.thesis.data.entity.Surface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class SurfaceServiceImpl implements SurfaceService {

    @Autowired
    private SurfaceRepository surfaceRepository;

    public void addSurface(BigDecimal area) {
        UUID id = UUID.randomUUID();
        Surface surface = new Surface(id, area);
        surfaceRepository.save(surface);
    }

    public List<Surface> getAllSurfaces() {
        return surfaceRepository.findAll();
    }
}
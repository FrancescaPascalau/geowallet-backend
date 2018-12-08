package francesca.pascalau.thesis.business.impl;

import francesca.pascalau.thesis.business.api.SurfaceService;
import francesca.pascalau.thesis.data.api.SurfaceRepository;
import francesca.pascalau.thesis.data.entity.Surface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
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

    public long countRows() {
        long count = surfaceRepository.count();
        return count;
    }

    public void deleteById(UUID id) {
        surfaceRepository.deleteById(id);
    }

    public void deleteAll() {
        surfaceRepository.deleteAll();
    }

    public List<Surface> findAll() {
        return surfaceRepository.findAll();
    }

    public Optional<Surface> findById(UUID id) {
        return surfaceRepository.findById(id);
    }

    public List<Surface> saveAll(List<Surface> listSurfaces) {
        return surfaceRepository.saveAll(listSurfaces);
    }

    public Optional<Surface> findByArea(BigDecimal area) {
        Surface surface = new Surface(null, area);
        Example<Surface> surfaces = Example.of(surface);
        return surfaceRepository.findOne(surfaces);
    }

    public void deleteByArea(BigDecimal area) {
        surfaceRepository.delete(findByArea(area).get());
    }
}
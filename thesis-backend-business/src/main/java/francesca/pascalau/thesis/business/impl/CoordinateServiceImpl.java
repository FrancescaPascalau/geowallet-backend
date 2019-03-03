package francesca.pascalau.thesis.business.impl;

import francesca.pascalau.thesis.business.api.CoordinateService;
import francesca.pascalau.thesis.data.api.CoordinateRepository;
import francesca.pascalau.thesis.data.entity.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CoordinateServiceImpl implements CoordinateService {

    @Autowired
    private CoordinateRepository coordinateRepository; //Inject Bean

    public void addCoordinate(BigDecimal latitude, BigDecimal longitude) {
        UUID id = UUID.randomUUID();
        Coordinate coordinate = new Coordinate(id, latitude, longitude,null);
        coordinateRepository.save(coordinate);
    }

    public List<Coordinate> getAllCoordinates() {

        return coordinateRepository.findAll();
    }

    public List<Coordinate> getAllByLatitude(BigDecimal latitude) {

        return coordinateRepository.findByLatitude(latitude);
    }

    public long countEntries() {
        long total = coordinateRepository.count();
        return total;
    }

    public void deleteById(UUID id) {
        coordinateRepository.deleteById(id);
    }

    public void deleteAll() {
        coordinateRepository.deleteAll();
    }

    public List<Coordinate> findAll() {
        return coordinateRepository.findAll();
    }

    public Optional<Coordinate> findById(UUID id) {
        return coordinateRepository.findById(id);
    }

    /*
    Test Optional
     */
    public Coordinate findByIdCoord(UUID id) {
         Optional<Coordinate> coordinate = coordinateRepository.findById(id);
         if(coordinate.isPresent()) {
             return coordinate.get();
         } else {
             return null;
         }
    }

    public List<Coordinate> saveAll(List<Coordinate> listCoordinates) {
        listCoordinates.forEach(coordinate -> {
            UUID id = UUID.randomUUID();
            coordinate.setId(id);
        });
        return coordinateRepository.saveAll(listCoordinates);
    }

    public Optional<Coordinate> findByLatitude(BigDecimal latitude) {
        Coordinate coordinate = new Coordinate(null, latitude, null, null);
        Example<Coordinate> coordinates = Example.of(coordinate);
        return coordinateRepository.findOne(coordinates);
    }

    public void deleteByLatitude(BigDecimal latitude) {
        coordinateRepository.delete(findByLatitude(latitude).get());
    }

    public Optional<Coordinate> findByLongitude(BigDecimal longitude) {
        Coordinate coordinate = new Coordinate(null, null, longitude, null);
        Example<Coordinate> coordinates = Example.of(coordinate);
        return coordinateRepository.findOne(coordinates);
    }

    public void deleteByLongitude(BigDecimal longitude) {
        coordinateRepository.delete(findByLongitude(longitude).get());
    }
}
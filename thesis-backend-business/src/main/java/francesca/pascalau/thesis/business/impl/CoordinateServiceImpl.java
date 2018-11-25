package francesca.pascalau.thesis.business.impl;

import francesca.pascalau.thesis.business.api.CoordinateService;
import francesca.pascalau.thesis.data.api.CoordinateRepository;
import francesca.pascalau.thesis.data.entity.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
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
}

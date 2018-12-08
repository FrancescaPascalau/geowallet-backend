package francesca.pascalau.thesis.business.api;

import francesca.pascalau.thesis.data.entity.Coordinate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CoordinateService {

    void addCoordinate(BigDecimal latitude, BigDecimal longitude);

    List<Coordinate> getAllCoordinates();

    List<Coordinate> getAllByLatitude(BigDecimal latitude);

    long countEntries();

    void deleteById(UUID id);

    void deleteAll();

    List<Coordinate> findAll();

    Optional<Coordinate> findById(UUID id);

    List<Coordinate> saveAll(List<Coordinate> listCoordinates);

    Optional<Coordinate> findByLatitude(BigDecimal latitude);

    void deleteByLatitude(BigDecimal latitude);

    Optional<Coordinate> findByLongitude(BigDecimal longitude);

    void deleteByLongitude(BigDecimal longitude);
}

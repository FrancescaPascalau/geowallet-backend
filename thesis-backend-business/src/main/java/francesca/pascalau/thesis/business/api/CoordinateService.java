package francesca.pascalau.thesis.business.api;

import francesca.pascalau.thesis.data.entity.Coordinate;

import java.math.BigDecimal;
import java.util.List;

public interface CoordinateService {

    public void addCoordinate(BigDecimal latitude, BigDecimal longitude);

    public List<Coordinate> getAllCoordinates();

    public List<Coordinate> getAllByLatitude(BigDecimal latitude);
}

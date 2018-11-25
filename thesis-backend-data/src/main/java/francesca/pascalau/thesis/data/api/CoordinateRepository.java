package francesca.pascalau.thesis.data.api;

import francesca.pascalau.thesis.data.entity.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface CoordinateRepository extends JpaRepository<Coordinate, UUID> {

    @Query(value = "SELECT * FROM coordinates WHERE latitude = :latitude", nativeQuery = true)
    public List<Coordinate> findByLatitude(@Param("latitude")BigDecimal latitude);
}

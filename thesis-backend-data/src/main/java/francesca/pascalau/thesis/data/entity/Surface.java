package francesca.pascalau.thesis.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(schema = "public", name = "`SURFACES`")
public class Surface implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_SURFACE")
    private UUID id_surface;

    @Column(name = "AREA", precision = 19, scale = 7)
    private BigDecimal area;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "surface")
    private Set<Coordinate> coordinates;

    public Surface() {
    }

    public Surface(UUID id_surface, BigDecimal area) {
        this.id_surface = id_surface;
        this.area = area;
        this.coordinates = Collections.emptySet();
    }

    public UUID getId_surface() {
        return id_surface;
    }

    public void setId_surface(UUID id_surface) {
        this.id_surface = id_surface;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public Set<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Set<Coordinate> coordinates) {
        coordinates.forEach(coordinate -> coordinate.setSurface(this));
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Surface{" +
                "id_surface=" + id_surface +
                ", area=" + area +
                '}';
    }
}
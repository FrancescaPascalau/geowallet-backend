package francesca.pascalau.thesis.data.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(schema = "public", name = "`COORDINATES`")
public class Coordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_COORDINATE")
    private UUID id;

    @Column(name = "LATITUDE", precision = 19, scale = 7)
    private BigDecimal latitude;

    @Column(name = "LONGITUDE", precision = 19, scale = 7)
    private BigDecimal longitude;

    @ManyToOne
    @JoinColumn(name = "ID_SURFACE", referencedColumnName = "ID_SURFACE")
    private Surface id_surface;

    public Coordinate(){};

    public Coordinate(UUID id, BigDecimal latitude, BigDecimal longitude, Surface id_surface) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.id_surface = id_surface;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Surface getId_surface() {
        return id_surface;
    }

    public void setId_surface(Surface id_surface) {
        this.id_surface = id_surface;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", id_surface=" + id_surface +
                '}';
    }
}

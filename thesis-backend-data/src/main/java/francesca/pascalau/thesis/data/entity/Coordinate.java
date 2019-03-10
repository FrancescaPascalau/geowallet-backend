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
    private Surface surface;

    public Coordinate() {
    }

    public Coordinate(UUID id, BigDecimal latitude, BigDecimal longitude, Surface surface) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.surface = surface;
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

//    public Surface getSurface() {
//        return surface;
//    }

    public void setSurface(Surface surface) {
        if (this.surface != null) return;
        this.surface = surface;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", surface=" + surface +
                '}';
    }
}

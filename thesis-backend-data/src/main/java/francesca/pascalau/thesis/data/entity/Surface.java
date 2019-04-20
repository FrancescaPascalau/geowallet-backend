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
    private UUID idSurface;

    @Column(name = "AREA", precision = 19, scale = 7)
    private BigDecimal area;

    @Column(name = "PRICE", precision = 19, scale = 7)
    private BigDecimal price;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "surface")
    private Set<Coordinate> coordinates;

    @ManyToOne(targetEntity = Type.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_TYPE", referencedColumnName = "ID_TYPE")
    private Type type;

    public Surface() {
    }

    public Surface(UUID idSurface, BigDecimal area) {
        this.idSurface = idSurface;
        this.area = area;
        this.coordinates = Collections.emptySet();
    }

    public UUID getIdSurface() {
        return idSurface;
    }

    public void setIdSurface(UUID idSurface) {
        this.idSurface = idSurface;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Set<Coordinate> coordinates) {
        coordinates.forEach(coordinate -> coordinate.setSurface(this));
        this.coordinates = coordinates;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Surface{" +
                "idSurface=" + idSurface +
                ", area=" + area +
                ", price=" + price +
                ", type=" + type +
                '}';
    }
}
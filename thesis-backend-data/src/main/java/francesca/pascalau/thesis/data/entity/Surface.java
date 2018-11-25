package francesca.pascalau.thesis.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(schema = "public", name = "SURFACES")
public class Surface {

    @Id
    @Column(name = "ID_SURFACE")
    private UUID id_surface;

    @Column(name = "AREA")
    private BigDecimal area;

    public Surface() {
    }

    public Surface(UUID id_surface, BigDecimal area) {
        this.id_surface = id_surface;
        this.area = area;
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

    @Override
    public String toString() {
        return "Surface{" +
                "id_surface=" + id_surface +
                ", area=" + area +
                '}';
    }
}
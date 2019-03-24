package francesca.pascalau.thesis.data.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(schema = "public", name = "`PRICES`")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PRICE")
    private UUID id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "VALUE")
    private Double value;

    public Price() {
    }

    public Price(UUID id, String type, Double value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id =" + id +
                ", type =" + type +
                ", value =" + value +
                '}';
    }
}
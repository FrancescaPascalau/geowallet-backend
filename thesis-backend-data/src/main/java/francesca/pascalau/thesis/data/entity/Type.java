package francesca.pascalau.thesis.data.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(schema = "public", name = "`TYPES`")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_TYPE")
    private UUID id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "VALUE")
    private Double value;

    public Type() {
    }

    public Type(UUID id, String description, Double value) {
        this.id = id;
        this.description = description;
        this.value = value;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id =" + id +
                ", description =" + description +
                ", value =" + value +
                '}';
    }
}
package francesca.pascalau.thesis.business.api;

import francesca.pascalau.thesis.data.entity.Type;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TypeService {

    Type saveType(Type description);

    UUID addType(String description, Double value);

    List<Type> getAllTypes();

    long countRows();

    void deleteById(UUID id);

    void deleteAll();

    List<Type> findAll();

    Optional<Type> findById(UUID id);

    List<Type> saveAll(List<Type> listTypes);

    Optional<Type> findByType(String description);

    Optional<Type> findByValue(Double value);

    void deleteByType(String description);

    void deleteByValue(Double value);
}

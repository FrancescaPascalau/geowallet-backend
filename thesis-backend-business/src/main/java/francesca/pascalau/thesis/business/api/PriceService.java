package francesca.pascalau.thesis.business.api;

import francesca.pascalau.thesis.data.entity.Price;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PriceService {

    Price savePrice(Price price);

    UUID addPrice(String type, Double value);

    List<Price> getAllPrices();

    long countRows();

    void deleteById(UUID id);

    void deleteAll();

    List<Price> findAll();

    Optional<Price> findById(UUID id);

    List<Price> saveAll(List<Price> listPrices);

    Optional<Price> findByType(String type);

    Optional<Price> findByValue(Double value);

    void deleteByType(String type);

    void deleteByValue(Double value);
}

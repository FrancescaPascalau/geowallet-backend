package francesca.pascalau.thesis.business.impl;

import francesca.pascalau.thesis.business.api.PriceService;
import francesca.pascalau.thesis.data.api.PriceRepository;
import francesca.pascalau.thesis.data.entity.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;


    @Override
    public Price savePrice(Price price) {
        return priceRepository.save(price);
    }

    public UUID addPrice(String type, Double value) {
        UUID id = UUID.randomUUID();
        Price price = new Price(id, type, value);
        priceRepository.save(price);
        return id;
    }

    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    public long countRows() {
        long count = priceRepository.count();
        return count;
    }

    public void deleteById(UUID id) {
        priceRepository.deleteById(id);
    }

    public void deleteAll() {
        priceRepository.deleteAll();
    }

    public List<Price> findAll() {
        return priceRepository.findAll();
    }

    public Optional<Price> findById(UUID id) {
        return priceRepository.findById(id);
    }

    public List<Price> saveAll(List<Price> listSurfaces) {
        return priceRepository.saveAll(listSurfaces);
    }

    public Optional<Price> findByType(String type) {
        Price price = new Price(null, type, null);
        Example<Price> prices = Example.of(price);
        return priceRepository.findOne(prices);
    }

    public Optional<Price> findByValue(Double value) {
        Price price = new Price(null, null, value);
        Example<Price> prices = Example.of(price);
        return priceRepository.findOne(prices);
    }

    public void deleteByType(String type) {
        priceRepository.delete(findByType(type).get());
    }

    public void deleteByValue(Double value) {
        priceRepository.delete(findByValue(value).get());
    }
}
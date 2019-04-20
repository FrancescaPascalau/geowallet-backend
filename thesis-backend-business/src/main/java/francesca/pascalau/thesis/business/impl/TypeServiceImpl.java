package francesca.pascalau.thesis.business.impl;

import francesca.pascalau.thesis.business.api.TypeService;
import francesca.pascalau.thesis.data.api.TypeRepository;
import francesca.pascalau.thesis.data.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;


    @Override
    public Type saveType(Type description) {
        return typeRepository.save(description);
    }

    public UUID addType(String description, Double value) {
        UUID id = UUID.randomUUID();
        Type price = new Type(id, description, value);
        typeRepository.save(price);
        return id;
    }

    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    public long countRows() {
        long count = typeRepository.count();
        return count;
    }

    public void deleteById(UUID id) {
        typeRepository.deleteById(id);
    }

    public void deleteAll() {
        typeRepository.deleteAll();
    }

    public List<Type> findAll() {
        return typeRepository.findAll();
    }

    public Optional<Type> findById(UUID id) {
        return typeRepository.findById(id);
    }

    public List<Type> saveAll(List<Type> listSurfaces) {
        return typeRepository.saveAll(listSurfaces);
    }

    public Optional<Type> findByType(String description) {
        return typeRepository.findOneByDescriptionIgnoreCase(description);
    }

    public Optional<Type> findByValue(Double value) {
        Type type = new Type(null, null, value);
        Example<Type> prices = Example.of(type);
        return typeRepository.findOne(prices);
    }

    public void deleteByType(String description) {
        typeRepository.delete(findByType(description).get());
    }

    public void deleteByValue(Double value) {
        typeRepository.delete(findByValue(value).get());
    }
}
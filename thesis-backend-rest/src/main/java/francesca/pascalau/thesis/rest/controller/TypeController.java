package francesca.pascalau.thesis.rest.controller;

import francesca.pascalau.thesis.business.api.TypeService;
import francesca.pascalau.thesis.data.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/types")
public class TypeController {

    @Autowired
    TypeService typeService;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<Type> saveType(@RequestBody Type description) {
        return ResponseEntity.ok(typeService.saveType(description));
    }

    @RequestMapping(value = "getType", method = RequestMethod.GET)
    public ResponseEntity<List<Type>> getResponse() {
        return ResponseEntity.ok(typeService.getAllTypes());
    }

    @RequestMapping(value = "addValue/{value}", method = RequestMethod.POST)
    public ResponseEntity<UUID> addType(@PathVariable("value") String description, Double value) {
        return ResponseEntity.ok(typeService.addType(description, value));
    }

    @RequestMapping(value = "countRows", method = RequestMethod.GET)
    public ResponseEntity<Long> countRows() {
        return ResponseEntity.ok(typeService.countRows());
    }

    @RequestMapping(value = "deleteById/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") UUID id) {
        typeService.deleteById(id);
        return ResponseEntity.ok("Type deleted.");
    }

    @RequestMapping(value = "deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() {
        typeService.deleteAll();
        return ResponseEntity.ok("All rows deleted.");
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public ResponseEntity<List<Type>> findAll() {
        return ResponseEntity.ok(typeService.findAll());
    }

    @RequestMapping(value = "findByType/{type}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Type>> findBy(@PathVariable("type") String description) {
        String typeWithSpaces = description.replaceAll("-", " ");
        return ResponseEntity.ok(typeService.findByType(typeWithSpaces));
    }

    @RequestMapping(value = "saveAll", method = RequestMethod.POST)
    public ResponseEntity<List<Type>> saveAll(@RequestBody List<Type> listTypes) {
        return ResponseEntity.ok(typeService.saveAll(listTypes));
    }

    @RequestMapping(value = "findByValue/{value}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Type>> findByValue(@PathVariable("value") Double value) {
        return ResponseEntity.ok(typeService.findByValue(value));
    }

    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Type>> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(typeService.findById(id));
    }

    @RequestMapping(value = "deleteByType/{type}", method = RequestMethod.DELETE)
    public ResponseEntity deleteByDescription(@PathVariable("type") String description) {
        typeService.deleteByType(description);
        return ResponseEntity.ok("Row deleted.");
    }

    @RequestMapping(value = "deleteByValue/{value}", method = RequestMethod.DELETE)
    public ResponseEntity deleteByValue(@PathVariable("value") Double value) {
        typeService.deleteByValue(value);
        return ResponseEntity.ok("Row deleted.");
    }
}
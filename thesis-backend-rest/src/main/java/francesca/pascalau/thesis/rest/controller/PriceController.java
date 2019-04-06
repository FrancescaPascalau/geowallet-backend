package francesca.pascalau.thesis.rest.controller;

import francesca.pascalau.thesis.business.api.PriceService;
import francesca.pascalau.thesis.data.entity.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/prices")
public class PriceController {

    @Autowired
    PriceService priceService;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<Price> savePrice(@RequestBody Price price) {
        return ResponseEntity.ok(priceService.savePrice(price));
    }

    @RequestMapping(value = "getPrice", method = RequestMethod.GET)
    public ResponseEntity<List<Price>> getResponse() {
        return ResponseEntity.ok(priceService.getAllPrices());
    }

    @RequestMapping(value = "addValue/{value}", method = RequestMethod.POST)
    public ResponseEntity<UUID> addPrice(@PathVariable("value") String type, Double value) {
        return ResponseEntity.ok(priceService.addPrice(type, value));
    }

    @RequestMapping(value = "countRows", method = RequestMethod.GET)
    public ResponseEntity<Long> countRows() {
        return ResponseEntity.ok(priceService.countRows());
    }

    @RequestMapping(value = "deleteById/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") UUID id) {
        priceService.deleteById(id);
        return ResponseEntity.ok("Type deleted.");
    }

    @RequestMapping(value = "deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() {
        priceService.deleteAll();
        return ResponseEntity.ok("All rows deleted.");
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public ResponseEntity<List<Price>> findAll() {
        return ResponseEntity.ok(priceService.findAll());
    }

    @RequestMapping(value = "findByType/{type}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Price>> findBy(@PathVariable("type") String type) {
        return ResponseEntity.ok(priceService.findByType(type));
    }

    @RequestMapping(value = "saveAll", method = RequestMethod.POST)
    public ResponseEntity<List<Price>> saveAll(@RequestBody List<Price> listPrices) {
        return ResponseEntity.ok(priceService.saveAll(listPrices));
    }

    @RequestMapping(value = "findByValue/{value}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Price>> findByValue(@PathVariable("value") Double value) {
        return ResponseEntity.ok(priceService.findByValue(value));
    }

    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Price>> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(priceService.findById(id));
    }

    @RequestMapping(value = "deleteByType/{type}", method = RequestMethod.DELETE)
    public ResponseEntity deleteByType(@PathVariable("type") String type) {
        priceService.deleteByType(type);
        return ResponseEntity.ok("Row deleted.");
    }

    @RequestMapping(value = "deleteByValue/{value}", method = RequestMethod.DELETE)
    public ResponseEntity deleteByValue(@PathVariable("value") Double value) {
        priceService.deleteByValue(value);
        return ResponseEntity.ok("Row deleted.");
    }
}
package francesca.pascalau.thesis.rest.controller;

import francesca.pascalau.thesis.business.api.CoordinateService;
import francesca.pascalau.thesis.data.entity.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/coordinates")
public class CoordinateController {

    @Autowired
    CoordinateService coordinateService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Coordinate>> getResponse(){
        return ResponseEntity.ok(coordinateService.getAllCoordinates());
    }

    @RequestMapping(value = "add/{lat}/{long}", method = RequestMethod.POST)
    public ResponseEntity addCoordinate(@PathVariable("lat")BigDecimal latitude, @PathVariable("long")BigDecimal longitude){
        coordinateService.addCoordinate(latitude, longitude);
        return ResponseEntity.ok("Row inserted.");
    }

    @RequestMapping(value = "find/{lat}", method = RequestMethod.GET)
    public ResponseEntity<List<Coordinate>> findCoordinatesByLatitude(@PathVariable("lat")BigDecimal latitude){
        return ResponseEntity.ok(coordinateService.getAllByLatitude(latitude));
    }

    @RequestMapping(value = "countRows", method = RequestMethod.GET)
    public ResponseEntity<Long> countRows() {
        return ResponseEntity.ok(coordinateService.countEntries());
    }

    @RequestMapping(value = "deleteById/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id")UUID id) {
        coordinateService.deleteById(id);
        return ResponseEntity.ok("Row deleted.");
    }

    @RequestMapping(value= "deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() {
        coordinateService.deleteAll();
        return ResponseEntity.ok("All rows deleted.");
    }

    @RequestMapping(value = "findAll", method = RequestMethod.POST)
    public ResponseEntity<List<Coordinate>> findAll() {
        return ResponseEntity.ok(coordinateService.findAll());
    }

    @RequestMapping(value = "findById/{id}", method = RequestMethod.POST)
    public ResponseEntity<Optional<Coordinate>> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(coordinateService.findById(id));
    }

    @RequestMapping(value = "saveAll", method = RequestMethod.POST)
    public ResponseEntity<List<Coordinate>> saveAll(@RequestBody List<Coordinate> listCoordinates) {
        return ResponseEntity.ok(coordinateService.saveAll(listCoordinates));
    }

    @RequestMapping(value = "findByLatitude/{lat}", method = RequestMethod.POST)
    public ResponseEntity<Optional<Coordinate>> findByLatitude(@PathVariable("lat") BigDecimal latitude) {
        return ResponseEntity.ok(coordinateService.findByLatitude(latitude));
    }
    @RequestMapping(value = "deleteByLatitude/{lat}", method = RequestMethod.DELETE)
    public ResponseEntity deleteByLatitude(@PathVariable("lat") BigDecimal latitude) {
        coordinateService.deleteByLatitude(latitude);
        return ResponseEntity.ok("Row deleted.");
    }

    @RequestMapping(value = "findByLongitude/{long}", method = RequestMethod.POST)
    public ResponseEntity<Optional<Coordinate>> findByLongitude(@PathVariable("long") BigDecimal longitude) {
        return ResponseEntity.ok(coordinateService.findByLongitude(longitude));
    }
    @RequestMapping(value = "deleteByLongitude/{long}", method = RequestMethod.DELETE)
    public ResponseEntity deleteByLongitude(@PathVariable("long") BigDecimal longitude) {
        coordinateService.deleteByLongitude(longitude);
        return ResponseEntity.ok("Row deleted.");
    }
}
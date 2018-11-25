package francesca.pascalau.thesis.rest.controller;

import francesca.pascalau.thesis.business.api.CoordinateService;
import francesca.pascalau.thesis.data.entity.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

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

    @RequestMapping(value = "find/{lat}", method =RequestMethod.GET)
    public ResponseEntity<List<Coordinate>> findCoordinatesByLatitude(@PathVariable("lat")BigDecimal latitude){
        return ResponseEntity.ok(coordinateService.getAllByLatitude(latitude));
    }
}

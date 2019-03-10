package francesca.pascalau.thesis.rest.controller;

import francesca.pascalau.thesis.business.api.SurfaceService;
import francesca.pascalau.thesis.data.entity.Surface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/surfaces")
public class SurfaceController {

    @Autowired
    SurfaceService surfaceService;

    @RequestMapping(value = "getArea", method = RequestMethod.GET)
    public ResponseEntity<List<Surface>> getResponse(){
        return ResponseEntity.ok(surfaceService.getAllSurfaces());
    }

    @RequestMapping(value = "addArea/{area}", method = RequestMethod.POST)
    public ResponseEntity<UUID> addArea(@PathVariable("area") BigDecimal area) {
        return ResponseEntity.ok(surfaceService.addSurface(area));
    }

    @RequestMapping(value = "countRows", method = RequestMethod.GET)
    public ResponseEntity<Long> countRows() {
        return ResponseEntity.ok(surfaceService.countRows());
    }

    @RequestMapping(value = "deleteById/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") UUID id) {
        surfaceService.deleteById(id);
        return ResponseEntity.ok("Row deleted.");
    }

    @RequestMapping(value = "deleteAll", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() {
        surfaceService.deleteAll();
        return ResponseEntity.ok("All rows deleted.");
    }

    @RequestMapping(value = "findAll", method = RequestMethod.POST)
    public ResponseEntity<List<Surface>> findAll() {
        return ResponseEntity.ok(surfaceService.findAll());
    }

    @RequestMapping(value = "findById/{id}", method = RequestMethod.POST)
    public ResponseEntity<Optional<Surface>> findById(@PathVariable("id")UUID id) {
        return ResponseEntity.ok(surfaceService.findById(id));
    }

    @RequestMapping(value = "saveAll", method = RequestMethod.POST)
    public ResponseEntity<List<Surface>> saveAll(@RequestBody List<Surface> listSurfaces) {
        return ResponseEntity.ok(surfaceService.saveAll(listSurfaces));
    }

    @RequestMapping(value = "findByArea/{area}", method = RequestMethod.POST)
    public ResponseEntity<Optional<Surface>> findByArea(@PathVariable("area")BigDecimal area) {
        return ResponseEntity.ok(surfaceService.findByArea(area));
    }

    @RequestMapping(value = "deleteByArea/{area}", method = RequestMethod.DELETE)
    public ResponseEntity deleteByArea(@PathVariable("area") BigDecimal area) {
        surfaceService.deleteByArea(area);
        return ResponseEntity.ok("Row deleted.");
    }
}
package francesca.pascalau.thesis.rest.controller;

import francesca.pascalau.thesis.business.api.SurfaceService;
import francesca.pascalau.thesis.data.entity.Surface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

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
    public ResponseEntity addArea(@PathVariable("area")BigDecimal area){
        surfaceService.addSurface(area);
        return ResponseEntity.ok("Area inserted.");
    }
}

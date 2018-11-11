package francesca.pascalau.thesis.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/area")
public class AreaController {

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<String> getResponse(){
        return ResponseEntity.ok("I am the Response to your question.");
    }
}

package meowpay.restcontroller.meow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MeowController {
    @Autowired
    private MeowService meowService;

    @RequestMapping("/meow")
    public ResponseEntity<List<Meow>> getAllMeow(){
        return ResponseEntity.ok(meowService.getMeow());
    }

    @RequestMapping(value = "/meow", method = RequestMethod.POST)
    public ResponseEntity<Meow> addMeow(@RequestBody Meow meow){
        return ResponseEntity.ok(meowService.addMeow(meow));
    }

    @RequestMapping("/meow/{id}")
    public ResponseEntity<Meow> getMeowByID(@PathVariable int id){
        return ResponseEntity.ok(meowService.getMeowByID(id));
    }

}

package meowpay.restcontroller.meow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MeowController {
    @Autowired
    private MeowService meowService;

    @RequestMapping("/meow")
    public String getAllMeow(){
        return meowService.getMeow().toString();
    }

    @RequestMapping(value = "/meow", method = RequestMethod.POST)
    public String addMeow(@RequestBody Meow meow){
        meowService.addMeow(meow);
        return "Added successfully";
    }

    @RequestMapping("/meow/{id}")
    public String getMeowByID(@PathVariable int id){
        return meowService.getMeowByID(id).toString();
    }
}

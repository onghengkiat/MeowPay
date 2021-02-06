package meowpay;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")
    public String homePage(Model model){
        return "home";
    }

    @RequestMapping("/claim")
    public String claimPage(Model model){
        return "claim";
    }


    @RequestMapping("/transaction")
    public String transactionPage(Model model){
        return "transaction";
    }


    @RequestMapping("/profile")
    public String profilePage(Model model){
        return "profile";
    }

    /*
    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

     */

}

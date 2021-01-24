package meowpay.restcontroller.claim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClaimController {
    @Autowired
    private ClaimService claimService;

    @RequestMapping("/claim")
    public String getAllCLaim(){
        return claimService.getClaim().toString();
    }

    @RequestMapping(value = "/claim", method = RequestMethod.POST)
    public String addClaim(@RequestBody Claim claim){
        claimService.addClaim(claim);
        return "Added successfully";
    }

    @RequestMapping("/claim/{id}")
    public String getClaimByID(@PathVariable int id){
        return claimService.getClaimByID(id).toString();
    }

}

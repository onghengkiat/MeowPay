package meowpay.restcontroller.claim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClaimController {
    @Autowired
    private ClaimService claimService;

    @RequestMapping("/claim")
    public ResponseEntity<List<Claim>> getAllCLaim(){
        return ResponseEntity.ok(claimService.getClaim());
    }

    @RequestMapping("/claim/meow/{meow_id}")
    public ResponseEntity<List<Claim>> getAllClaimByMeowId(@PathVariable int meow_id){

        return ResponseEntity.ok(claimService.getClaimByMeow(meow_id));
    }

    @RequestMapping(value = "/claim", method = RequestMethod.POST)
    public ResponseEntity<Claim> addClaim(@RequestBody Claim claim){
        return ResponseEntity.ok(claimService.addClaim(claim));
    }


    @RequestMapping("/claim/{id}")
    public ResponseEntity<Claim> getClaimByID(@PathVariable int id){
        return ResponseEntity.ok(claimService.getClaimByID(id));
    }

}

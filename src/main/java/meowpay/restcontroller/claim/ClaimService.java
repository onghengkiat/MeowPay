package meowpay.restcontroller.claim;

import meowpay.restcontroller.claim.Claim;
import meowpay.restcontroller.meow.Meow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class ClaimService {
    @Autowired
    private ClaimRepository claimRepository;

    public ClaimService(){

    }


    public List<Claim> getClaim(){
        List <Claim> list = new LinkedList<>();
        for(Claim claim : claimRepository.findAll()){
            list.add(claim);
        }
        return list;
    }

    public List<Claim> getClaimByMeow(int id){
        List<Claim> claims = new LinkedList<>();
        for (Claim claim : claimRepository.findByMeow(new Meow(id))){
            claims.add(claim);
        }
        return claims;
    }

    public Claim getClaimByID(int id){
        return claimRepository.findById(id).get();
    }

    public Claim addClaim(Claim claim){
        return this.claimRepository.save(claim);
    }
}

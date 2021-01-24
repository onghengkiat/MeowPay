package meowpay.restcontroller.claim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class ClaimService {
    @Autowired
    private ClaimRepository claimRepository;

    public ClaimService(){

    }


    public Queue<Claim> getClaim(){
        Queue<Claim> list = new LinkedList<>();
        for(Claim claim : claimRepository.findAll()){
            list.add(claim);
        }
        return list;
    }

    public Claim getClaimByID(int id){
        return claimRepository.findById(id).get();
    }

    public void addClaim(Claim claim){
        this.claimRepository.save(claim);
    }
}

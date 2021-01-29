package meowpay.restcontroller.claim;

import meowpay.restcontroller.claim.Claim;
import meowpay.restcontroller.meow.Meow;
import meowpay.restcontroller.meow.MeowService;
import meowpay.restcontroller.transaction.Transaction;
import meowpay.restcontroller.transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClaimService {
    @Autowired
    private ClaimRepository claimRepository;
    @Autowired
    private EntryRepository entryRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private MeowService meowService;

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

    public Claim balance(){
        Claim claim = this.addClaim(new Claim(meowService.getCentralMeow(),"Balancing Claim",0,0));
        HashMap<Meow, Integer> balances = new HashMap<>();
        for( Entry entry: entryRepository.findAll()){
            if(balances.containsKey(entry.getCreditor())){
                balances.put(entry.getCreditor(), balances.get(entry.getCreditor()) + entry.getAmount() );
            }else{
                balances.put(entry.getCreditor(), entry.getAmount() );
            }

            if(balances.containsKey(entry.getDebitor())){
                balances.put(entry.getDebitor(), balances.get(entry.getDebitor()) - entry.getAmount() );
            }else{
                balances.put(entry.getDebitor(), -entry.getAmount() );
            }
        }

        for (Map.Entry<Meow, Integer> entry : balances.entrySet()) {
            entryRepository.save(new Entry(claim, meowService.getCentralMeow(), entry.getKey(),entry.getValue()));
            transactionRepository.save(new Transaction(claim,new Meow(1),entry.getKey(),entry.getValue(), 1));
        }
        return claim;
    }
}

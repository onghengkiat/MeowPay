package meowpay.restcontroller.claim;

import meowpay.restcontroller.meow.Meow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimRepository extends CrudRepository <Claim,Integer> {
    List<Claim> findByMeow(Meow meow);
}

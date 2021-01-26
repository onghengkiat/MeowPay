package meowpay.restcontroller.comment;

import meowpay.restcontroller.claim.Claim;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    List<Comment> findByClaim(Claim cliam);
}

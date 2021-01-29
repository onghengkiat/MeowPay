package meowpay.restcontroller.meow;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MeowRepository extends CrudRepository<Meow, Integer> {
    Meow findByRole(String role);
}

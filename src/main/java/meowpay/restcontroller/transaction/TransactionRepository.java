package meowpay.restcontroller.transaction;

import meowpay.restcontroller.entry.Entry;
import meowpay.restcontroller.meow.Meow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    List<Transaction> findByCreditorOrDebitor(Meow meow1, Meow meow2);
}

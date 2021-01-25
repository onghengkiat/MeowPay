package meowpay.restcontroller.entry;

import meowpay.restcontroller.meow.Meow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends CrudRepository<Entry, Integer> {
    List<Entry> findByCreditorOrDebitor(Meow meow1,Meow meow2);
}

package meowpay.restcontroller.claim;

import meowpay.restcontroller.meow.Meow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class EntryService {
    @Autowired
    private EntryRepository entryRepository;

    public EntryService(){

    }

    public String getEntryByMeow(int id){
        List <Entry> entries = new LinkedList<>();
        int balance = 0;
        for (Entry entry : entryRepository.findByCreditorOrDebitor(new Meow(id), new Meow(id))){
            if(entry.getCreditor().getMeow_id() == id)
                balance += entry.getAmount();
            if (entry.getDebitor().getMeow_id() == id)
                balance -= entry.getAmount();
            entries.add(entry);
        }
        return "{entries:"+entries + ",balance:"+balance + "}";
    }
    public List<Entry> getEntryByClaim(int id){
        List <Entry> entries = new LinkedList<>();
        for (Entry entry : entryRepository.findByClaim(new Claim(id))){
            entries.add(entry);
        }
        return entries;
    }


}

package meowpay.restcontroller.entry;

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


    public String getEntry(){
        List<Entry> list = new LinkedList<>();
        for(Entry entry : entryRepository.findAll()){
            list.add(entry);
        }
        return list.toString();
    }


    public String getEntryByMeow(int id){
        List <Entry> entries = new LinkedList<>();
        Collections.sort(entries);
        int balance = 0;
        for (Entry entry : entryRepository.findByCreditorOrDebitor(new Meow(id), new Meow(id))){
            if(entry.getCreditor().getMeow_id() == id)
                balance += entry.getAmount();
            if (entry.getDebitor().getMeow_id() == id)
                balance -= entry.getAmount();
            entries.add(entry);
        }
        return "{entries:"+entries.toString() + ",balance:"+balance + "}";
    }

    public String getEntryByID(int id){
        return entryRepository.findById(id).get().toString();
    }

    public void addEntry(Entry entry){
        this.entryRepository.save(entry);
    }

}

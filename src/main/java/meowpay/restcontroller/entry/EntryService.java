package meowpay.restcontroller.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class EntryService {
    @Autowired
    private EntryRepository entryRepository;

    public EntryService(){

    }


    public Queue<Entry> getEntry(){
        Queue<Entry> list = new LinkedList<>();
        for(Entry entry : entryRepository.findAll()){
            list.add(entry);
        }
        return list;
    }

    public Entry getEntryByID(int id){
        return entryRepository.findById(id).get();
    }

    public void addEntry(Entry entry){
        this.entryRepository.save(entry);
    }

}

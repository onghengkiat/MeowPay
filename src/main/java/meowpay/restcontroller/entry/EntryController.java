package meowpay.restcontroller.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EntryController {

    @Autowired
    private EntryService entryService;

    @RequestMapping("/entry")
    public ResponseEntity<List<Entry>> getAllEntry(){
        return ResponseEntity.ok(entryService.getEntry());
    }

    @RequestMapping("/entry/meow/{meow_id}")
    public ResponseEntity<String> getAllEntryByMeowId(@PathVariable int meow_id){
        return ResponseEntity.ok(entryService.getEntryByMeow(meow_id));
    }

    @RequestMapping(value = "/entry", method = RequestMethod.POST)
    public ResponseEntity<Entry> addEntry(@RequestBody Entry entry){
        return ResponseEntity.ok(entryService.addEntry(entry));
    }

    @RequestMapping("/entry/{id}")
    public ResponseEntity<Entry> getEntryByID(@PathVariable int id){
        return ResponseEntity.ok(entryService.getEntryByID(id));
    }
}

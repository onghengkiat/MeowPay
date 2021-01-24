package meowpay.restcontroller.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EntryController {

    @Autowired
    private EntryService entryService;

    @RequestMapping("/entry")
    public String getAllEntry(){
        return entryService.getEntry().toString();
    }

    @RequestMapping(value = "/entry", method = RequestMethod.POST)
    public String addEntry(@RequestBody Entry entry){
        entryService.addEntry(entry);
        return "Added successfully";
    }

    @RequestMapping("/entry/{id}")
    public String getEntryByID(@PathVariable int id){
        return entryService.getEntryByID(id).toString();
    }
}

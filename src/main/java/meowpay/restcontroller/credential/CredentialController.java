package meowpay.restcontroller.credential;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CredentialController {

    @Autowired
    private CredentialService credentialService;

    @RequestMapping("/credential")
    public String getAllCredential(){
        return credentialService.getCredential().toString();
    }

    @RequestMapping(value = "/credential", method = RequestMethod.POST)
    public String addCredential(@RequestBody Credential credential){
        credentialService.addCredential(credential);
        return "Added successfully";
    }

    @RequestMapping("/credential/{id}")
    public String getCredentialByID(@PathVariable String id){
        return credentialService.getCredentialByID(id).toString();
    }

}

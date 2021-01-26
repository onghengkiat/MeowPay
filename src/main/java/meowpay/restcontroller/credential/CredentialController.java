package meowpay.restcontroller.credential;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CredentialController {

    @Autowired
    private CredentialService credentialService;

    @RequestMapping("/credential")
    public ResponseEntity<List<Credential>> getAllCredential(){
        return ResponseEntity.ok(credentialService.getCredential());
    }

    @RequestMapping(value = "/credential", method = RequestMethod.POST)
    public ResponseEntity<Credential> addCredential(@RequestBody Credential credential){
        return ResponseEntity.ok(credentialService.addCredential(credential));
    }

    @RequestMapping("/credential/{id}")
    public ResponseEntity<Credential> getCredentialByID(@PathVariable String id){
        return ResponseEntity.ok(credentialService.getCredentialByID(id));
    }

    @RequestMapping("/credential/authenticate")
    public ResponseEntity<Credential> authenticateCredential(@RequestBody Credential credential){
        if (credentialService.authenticateCredential(credential)){
            return getCredentialByID(credential.getUsername());
        }else{
            return ResponseEntity.status(400).body(null);
        }
    }
}

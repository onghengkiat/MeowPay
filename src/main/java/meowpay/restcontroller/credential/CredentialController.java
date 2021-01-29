package meowpay.restcontroller.credential;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CredentialController {

    @Autowired
    private CredentialService credentialService;

    @RequestMapping("/credential/authenticate")
    public ResponseEntity<Credential> authenticateCredential(@RequestBody String username, @RequestBody String password){
        return ResponseEntity.ok(null);
    }
}

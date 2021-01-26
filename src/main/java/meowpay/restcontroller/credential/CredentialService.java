package meowpay.restcontroller.credential;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CredentialService {

    @Autowired
    private CredentialRepository credentialRepository;

    public CredentialService() {
    }

    public List<Credential> getCredential(){
        List<Credential> list = new LinkedList<>();
        for(Credential credential : credentialRepository.findAll()){
            list.add(credential);
        }
        return list;
    }

    public Credential getCredentialByID(String id){
        return credentialRepository.findById(id).get();
    }

    public Credential addCredential(Credential credential){
        return this.credentialRepository.save(credential);
    }

    public boolean authenticateCredential(Credential credential){
        Credential credential_in_db = getCredentialByID(credential.getUsername());
        if(credential_in_db.getPassword().equals(credential.getPassword())){
            return true;
        }else{
            return false;
        }
    }
}

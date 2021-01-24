package meowpay.restcontroller.credential;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class CredentialService {

    @Autowired
    private CredentialRepository credentialRepository;

    public CredentialService() {
    }

    public Queue<Credential> getCredential(){
        Queue<Credential> list = new LinkedList<>();
        for(Credential credential : credentialRepository.findAll()){
            list.add(credential);
        }
        return list;
    }

    public Credential getCredentialByID(String id){
        return credentialRepository.findById(id).get();
    }

    public void addCredential(Credential credential){
        this.credentialRepository.save(credential);
    }

}

package meowpay.restcontroller.meow;

import meowpay.restcontroller.credential.Credential;
import meowpay.restcontroller.credential.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class MeowService {
    @Autowired
    private MeowRepository meowRepository;
    @Autowired
    private CredentialRepository credentialRepository;

    public MeowService() {
    }

    public List<Meow> getMeow(){
        List<Meow> list = new LinkedList<>();
        for(Meow meow : meowRepository.findAll()){
            list.add(meow);
        }
        return list;
    }

    public Meow getMeowByID(int id){
        return meowRepository.findById(id).get();
    }

    public Meow getCentralMeow(){
        return meowRepository.findByRole("CentralMeow");
    }

    public Meow addMeow(Meow meow, Credential credential){
        try{
            credentialRepository.findById(credential.getUsername()).get();
            return null;
        }catch (Exception e){
            Meow meow_in_db = this.meowRepository.save(meow);
            String pw_hash = BCrypt.hashpw(credential.getPassword(), BCrypt.gensalt());
            credential.setPassword(pw_hash);
            credential.setMeow(meow_in_db);
            this.credentialRepository.save(credential);
            return meow;
        }

    }
}

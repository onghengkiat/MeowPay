package meowpay.restcontroller.credential;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class CredentialService implements UserDetailsService {

    @Autowired
    private CredentialRepository credentialRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Credential user = credentialRepository.findById(username).get();
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CredentialPrincipal(user);
    }

    public UserDetails updatePassword(String username, String password){
        Credential user = credentialRepository.findById(username).get();
        String pw_hash = BCrypt.hashpw(password, BCrypt.gensalt());
        user.setPassword(pw_hash);
        System.out.println(pw_hash);
        System.out.println(password);
        credentialRepository.save(user);
        System.out.println("Changes successfully");
        return new CredentialPrincipal(user);
    }


}
package meowpay.restcontroller.credential;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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


}
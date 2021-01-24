package meowpay.restcontroller.credential;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends CrudRepository<Credential, String> {
}

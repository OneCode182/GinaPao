

package usa.ciclo4.reto2.repositories.crud;


import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import usa.ciclo4.reto2.models.User;




public interface UserInterface extends CrudRepository<User, Integer> {
    
    public Optional<User> findByEmail(String email);
    public Optional<User> findByEmailAndPassword(String email, String password);
    
}




package usa.ciclo4.reto1.repositories.crud;


import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import usa.ciclo4.reto1.models.User;




public interface UserInterface extends CrudRepository<User, Integer> {
    
    public Optional<User> findByEmail(String email);
    
    public Optional<User> findByEmailAndPassword(String email, String password);
    
}



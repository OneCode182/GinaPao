
package usa.ciclo4.reto4.repositories.crud;

import java.util.List;
import usa.ciclo4.reto4.models.User;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserInterface extends MongoRepository<User, Integer> {
    
    public Optional<User> findByEmail(String email);
    public Optional<User> findByEmailAndPassword(String email, String password);
    
    public List<User> findByMonthBirthtDay(String birthday);
    
}



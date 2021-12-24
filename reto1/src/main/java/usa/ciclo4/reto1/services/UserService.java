
package usa.ciclo4.reto1.services;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo4.reto1.models.User;
import usa.ciclo4.reto1.repositories.UserRepo;



@Service
public class UserService {
    
    @Autowired
    private UserRepo metodosCrud;
    
    public User save(User user) {
        return metodosCrud.save(user);
    }
    
    public List<User> getAll() {
        return metodosCrud.getAll();
    }
    
    public boolean getUserByEmail(String email) {
        return metodosCrud.getUserByEmail(email).isPresent();
    }
    
    public boolean getUser(String email, String password) {
        return metodosCrud.getUserByEmailAndPassword(email, password).isPresent();
    }
    
    public User jsonUser(String email, String password) {
        Optional<User> user = metodosCrud.getUserByEmailAndPassword(email, password);
        
        if (user.isPresent()) {
            return user.get();
            
        } return new User(
            null,
            email,
            password,
            "NO DEFINIDO"
        );
        
    }
    
    
}




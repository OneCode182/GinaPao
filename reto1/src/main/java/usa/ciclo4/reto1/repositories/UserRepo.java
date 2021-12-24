
package usa.ciclo4.reto1.repositories;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo4.reto1.models.User;
import usa.ciclo4.reto1.repositories.crud.UserInterface;


@Repository
public class UserRepo {
    
    @Autowired
    private UserInterface crud;
    
    public List<User> getAll() {
        return (List<User>) crud.findAll();
    }
    
    public Optional<User> getUserByEmail(String email) {
        return crud.findByEmail(email);
    }
    
    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        return crud.findByEmailAndPassword(email, password);
    }
    
    public User save(User user) {
        return crud.save(user);
    }
    
    public void delete(User user) {
        crud.delete(user);
    }
    
}




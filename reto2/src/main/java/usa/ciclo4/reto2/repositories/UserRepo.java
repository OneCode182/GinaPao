
package usa.ciclo4.reto2.repositories;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo4.reto2.models.User;
import usa.ciclo4.reto2.repositories.crud.UserInterface;


@Repository
public class UserRepo {
    
    @Autowired
    private UserInterface crud;
    
    public User saveUser(User user) {
        return crud.save(user);
    }
    
    public List<User> getAll() {
        return (List<User>) crud.findAll();
    }
    
    public Optional<User> getById(Integer id) {
        return crud.findById(id);
    }
    
    public Optional<User> getUserByEmail(String email) {
        return crud.findByEmail(email);
    }
    
    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        return crud.findByEmailAndPassword(email, password);
    }
    
    public void delete(Integer id) {
        crud.deleteById(id);
    }
    
    
    
}




package usa.ciclo4.reto3.repositories;

import usa.ciclo4.reto3.models.User;
import usa.ciclo4.reto3.repositories.crud.UserInterface;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    
    public int getAmount() {
        return (int) crud.count();
    }
    
    public Optional<User> getUserById(Integer id) {
        return crud.findById(id);
    }
    
    public Optional<User> getUserByEmail(String email) {
        return crud.findByEmail(email);
    }
    
    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        return crud.findByEmailAndPassword(email, password);
    }
    
    public void deleteUserById(Integer id) {
        crud.deleteById(id);
    }
    
    public List<User> findByMonthBirthtDay(String birthday){
        return  crud.findByMonthBirthtDay(birthday);
    }
    
    
    
}



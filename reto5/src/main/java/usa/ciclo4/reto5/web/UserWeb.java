

package usa.ciclo4.reto5.web;

import usa.ciclo4.reto5.models.User;
import usa.ciclo4.reto5.services.UserService;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserWeb {
    
    
    // ------------------ ATRIBUTOS ------------------
    @Autowired
    private UserService service;
    
    
    // ------------------ RETO 2 ------------------
    
    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return service.getUserByEmail(email);
    }
    
    @GetMapping("/{email}/{password}")
    public User userExists(@PathVariable("email") String email,
    @PathVariable("password") String password) {
        return service.getUserByEmailAndPassword(email, password);
    }
    
    
    // ------------------ RETO 3 ------------------
    
    
    
    // ------------------ RETO 4 ------------------
    
    
    
    // ------------------ RETO 5 ------------------
    
    @GetMapping("/birthday/{birthday}")
    public List<User> getByBirthday(@PathVariable("birthday") String birthday) {
        return service.findByMonthBirthtDay(birthday);
    }
    
    
    
    // ------------------ CONTROLLER ------------------
    
    
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        return service.save(user);
    }
    
    @GetMapping("/all")
    public List<User> getUsers() {
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public User getUserByID(@PathVariable("id") Integer id) {
        return service.getUserByID(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@RequestBody User user) {
        return service.update(user);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteUser(@PathVariable("id") int id) {
        return service.delete(id);
    } 
    
}




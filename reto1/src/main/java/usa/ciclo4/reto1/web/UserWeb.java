
package usa.ciclo4.reto1.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import usa.ciclo4.reto1.services.UserService;
import usa.ciclo4.reto1.models.User;



@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserWeb {
    
    @Autowired
    private UserService servicios;
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User usuario) {
        return servicios.save(usuario);
    }
    
    @GetMapping("/all")
    public List<User> getAll() {
        return servicios.getAll();
    }
    
    @GetMapping("/{email}")
    public boolean getEmailExists(@PathVariable("email") String email) {
        return servicios.getUserByEmail(email);
    }
    
    @GetMapping("/{email}/{password}")
    public User getJsonUser(@PathVariable("email") String email,
    @PathVariable("password") String password) {
        return servicios.jsonUser(email, password);
    }
    
}




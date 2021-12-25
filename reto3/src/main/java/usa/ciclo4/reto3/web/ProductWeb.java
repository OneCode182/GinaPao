
package usa.ciclo4.reto3.web;

import usa.ciclo4.reto3.models.Product;
import usa.ciclo4.reto3.services.ProductService;



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
@RequestMapping("/clone")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProductWeb {
    
    // ------------------ ATRIBUTOS ------------------
    
    @Autowired
    private ProductService services;
   
    
    // ------------------ RETO 2 ------------------
    // ------------------ RETO 3 ------------------
    // ------------------ RETO 4 ------------------
    // ------------------ RETO 5 ------------------
    
    @GetMapping("/price/{price}")
    public List<Product> findByPrice(@PathVariable("price") double price) {
        return services.findByPrice(price);
    }
    
    @GetMapping("/description/{description}")
    public List<Product> findByDescription(@PathVariable("description") String description) {
        return services.findByDescription(description);
    }
    
    
    // ------------------ CONTROLLER ------------------
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody Product product) {
        return services.saveProduct(product);
    }
    
    @GetMapping("/all")
    public List<Product> getAll() {
        return services.getAll();
    }
    
    @GetMapping("/{id}")
    public Product getByID(@PathVariable("id") String id) {
        return services.getById(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Product updateProduct(@RequestBody Product product) {
        return services.update(product);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteProduct(@PathVariable("id") String id) {
        return services.delete(id);
    } 
    
}


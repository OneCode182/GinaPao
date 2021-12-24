

package usa.ciclo4.reto2.repositories.crud;


import java.util.Optional;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import usa.ciclo4.reto2.models.Product;


public interface ProductInterface extends CrudRepository<Product, String> {
    
    @Query("{'reference': ?0}")
    public Optional<Product> findByReference(String reference);
 
}



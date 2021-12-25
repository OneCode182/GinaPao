

package usa.ciclo4.reto4.repositories.crud;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import usa.ciclo4.reto4.models.Product;




public interface ProductInterface extends MongoRepository<Product, String> {
    
    @Query("{'reference': ?0}")
    public Optional<Product> findByReference(String reference);
    
    public List<Product> findByPrice(double price);
    
}



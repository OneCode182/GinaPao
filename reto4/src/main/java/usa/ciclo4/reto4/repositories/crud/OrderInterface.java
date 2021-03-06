

package usa.ciclo4.reto4.repositories.crud;

import usa.ciclo4.reto4.models.Order;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;





public interface OrderInterface extends MongoRepository<Order, Integer> {
    
    @Query("{'salesMan.zone' : ?0}")
    public List<Order> findUserByZone(String zone);

    @Query("{'salesMan.id' : ?0}")
    public List<Order> findUserById(Integer id);

    public List<Order> findByStatus(String status);
    
}



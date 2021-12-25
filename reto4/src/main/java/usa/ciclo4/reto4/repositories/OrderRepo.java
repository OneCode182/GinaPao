
package usa.ciclo4.reto4.repositories;

import usa.ciclo4.reto4.models.Order;
import usa.ciclo4.reto4.repositories.crud.OrderInterface;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class OrderRepo {
    
    @Autowired
    private OrderInterface crudRepo;
    
    public Order save(Order order) {
        return crudRepo.save(order);
    }
    
    public List<Order> getAll() {
        return crudRepo.findAll();
    }
    
    public List<Order> getUserByZone(String zone) {
        return crudRepo.findUserByZone(zone);
    }
    
    public Optional<Order> getByID(Integer id) {
        return crudRepo.findById(id);
    }
    
    public void deleteByID(Integer id) {
        crudRepo.deleteById(id);
    }

    public List<Order> getUserById(Integer id) { 
        return crudRepo.findUserById(id);
    }

    public List<Order> getOrderByStatus(String status) {
        return crudRepo.findByStatus(status);
    }



}



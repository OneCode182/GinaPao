
package usa.ciclo4.reto5.services;

import usa.ciclo4.reto5.models.Order;
import usa.ciclo4.reto5.repositories.OrderRepo;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;




@Service
public class OrderService {
    
    @Autowired
    private OrderRepo repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Order save(Order order) {
        if (order.getRegisterDay() == null || order.getStatus() == null ||
        order.getSalesMan() == null || order.getProducts() == null ||
        order.getQuantities() == null) {
            return order;
            
        } else {
            Optional<Order> exists = repository.getByID(order.getId());
            if (exists.isEmpty()) {
                return repository.save(order);
                
            } else {
                return order;
                
            }
        }
        
    }
    
    public List<Order> getAll() {
        return repository.getAll();
    }
    
    public Order getByID(Integer id) {
        Optional<Order> exists = repository.getByID(id);
        if (exists.isPresent()) {
            return exists.get();
                    
        } return new Order();
    }
    
    public List<Order> getUsersByZone(String zone) {
        return repository.getUserByZone(zone);
    }
    
    public Order update(Order order){
        if(order.getId() != null){
            Optional<Order> exists = repository.getByID(order.getId());
            if(exists.isPresent()){
                if(order.getRegisterDay()!= null){
                    exists.get().setRegisterDay(order.getRegisterDay());
                }
                if(order.getStatus()!= null){
                    exists.get().setStatus(order.getStatus());
                }
                if(order.getSalesMan() != null){
                    exists.get().setSalesMan(order.getSalesMan());
                }
                if(order.getProducts()!= null){
                    exists.get().setProducts(order.getProducts());
                }
                if(order.getQuantities()!= null){
                    exists.get().setQuantities(order.getQuantities());
                }
                
                return repository.save(exists.get());
                
            } return order;
            
        } return order;
        
    }
    
    public boolean delete(Integer id) {
        Optional<Order> exists = repository.getByID(id);
        if (exists.isPresent()) {
            repository.deleteByID(id);
            return true;
            
        } return false;
        
    }

    public List<Order> getUsersById(Integer id) {return repository.getUserById(id);}

    public List<Order> getOrderByStatus(String status) {return repository.getOrderByStatus(status);}

    public List<Order> getByStatusAndByUserId(String state, Integer id) {
        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id)
                .and("status").is(state);

        query.addCriteria(criterio);

        List<Order> orders = mongoTemplate.find(query,Order.class);

        return orders;
    }

    public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
        
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();

        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(dateStr, dtf).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dateCriteria);

        List<Order> orders = mongoTemplate.find(query,Order.class);

        return orders;
        
    }

}



package usa.ciclo4.reto5.repositories;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo4.reto5.models.Product;
import usa.ciclo4.reto5.repositories.crud.ProductInterface;


@Repository
public class ProductRepo {
    
    @Autowired
    private ProductInterface crud;
    
    public Product saveProduct(Product product) {
        return crud.save(product);
    }
    
    public List<Product> getAll() {
        return (List<Product>) crud.findAll();
    }
    
    public Optional<Product> getById(String reference) {
        return crud.findByReference(reference);
    }
    
    public void delete(String id) {
        crud.deleteById(id);
    }
    
    public void deleteAll() {
        crud.deleteAll();
    }
    
    public List<Product> findByPrice(double price){
        return  crud.findByPrice(price);
    }
    
    
}


package usa.ciclo4.reto2.services;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo4.reto2.models.Product;
import usa.ciclo4.reto2.repositories.ProductRepo;



@Service
public class ProductService {
    
    @Autowired
    private ProductRepo metodosCrud;
    
    public Product saveProduct(Product product) {
        if (product.getBrand() == null || product.getCategory()== null ||
        product.getDescription()== null || product.getPrice() == 0.0 ||
        product.getQuantity() == 0 || product.getPhotography() == null) {
            return product;
            
        } else {
            Optional<Product> productExists = metodosCrud.getById(product.getReference());
            if (productExists.isEmpty()) {
                return metodosCrud.saveProduct(product);
                
            } return product;
            
        }
        
    }
    
    public List<Product> getAll() {
        return metodosCrud.getAll();
    }
    
    public Product getById(String reference) {
        Optional<Product> productExists = metodosCrud.getById(reference);
        
        if (productExists.isPresent()) {
            return productExists.get();
            
        } return new Product();
        
    }
    
    public Product update(Product product){
        if (product.getBrand() == null || product.getCategory()== null ||
        product.getDescription()== null || product.getPrice() == 0.0 ||
        product.getQuantity() == 0 || product.getPhotography() == null) {
            return product;
            
        } else {
            Optional<Product> productExists = metodosCrud.getById(product.getReference());
            if (productExists.isPresent()) {
                metodosCrud.deleteAll();
                return metodosCrud.saveProduct(product);
                
            } return product;
            
        }
    }
    
    public boolean delete(String reference) {
        metodosCrud.deleteAll();
        return true;
        
    }
    
}



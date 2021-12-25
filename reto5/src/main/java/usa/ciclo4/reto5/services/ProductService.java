
package usa.ciclo4.reto5.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo4.reto5.models.Product;
import usa.ciclo4.reto5.repositories.ProductRepo;



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
    
    public List<Product> findByPrice(double price){
        return  metodosCrud.findByPrice(price);
    }
    
    private boolean checkStrings(String string1, String string2) {
        return string1.indexOf(string2)>=0;
    }
    
    public List<Product> findByDescription(String description2){
        List <Product> productos = metodosCrud.getAll();
        ArrayList<Product> productos2 = new ArrayList();
        for(Product producto: productos){
            String descripcion1 = producto.getDescription();
            
            if (checkStrings(descripcion1, description2)) {
                productos2.add(producto);
            }
            
        }
        
        return (List<Product>) productos2;
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



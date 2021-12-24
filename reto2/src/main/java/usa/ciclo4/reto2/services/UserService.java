
package usa.ciclo4.reto2.services;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo4.reto2.models.User;
import usa.ciclo4.reto2.repositories.UserRepo;



@Service
public class UserService {
    
    @Autowired
    private UserRepo crudRepo;
    
    
    public User save(User user) {
        if (user.getIdentification() == null || user.getName()== null ||
        user.getAddress()== null || user.getCellPhone()== null ||
        user.getEmail()== null || user.getPassword()== null || 
        user.getZone()== null || user.getType()== null) {
            return user;
            
        } else {
            Optional<User> exist = crudRepo.getById(user.getId());
            if (exist.isEmpty()) {
                return crudRepo.saveUser(user);

            } return user;
            
        }
        
    }
    
    
    public List<User> getAll() {
        return crudRepo.getAll();
    }
    
    public boolean getUserByEmail(String email) {
        return crudRepo.getUserByEmail(email).isPresent();
    }
    
    public User getUserByEmailAndPassword(String email, String password) {
        Optional<User> user = crudRepo.getUserByEmailAndPassword(email, password);
        
        if (user.isPresent()) {
            return user.get();
            
        } return new User();
        
    }
    
    public User updateUser(User user){
        if(user.getId()!=null){
            Optional<User> userExist = crudRepo.getById(user.getId());
            if(userExist.isPresent()){
                if(user.getIdentification()!=null){
                    userExist.get().setIdentification(user.getIdentification());
                }
                if(user.getName()!=null){
                    userExist.get().setName(user.getName());
                }
                if(user.getAddress()!=null){
                    userExist.get().setAddress(user.getAddress());
                }
                if(user.getCellPhone()!=null){
                    userExist.get().setCellPhone(user.getCellPhone());
                }
                if(user.getEmail()!=null){
                    userExist.get().setEmail(user.getEmail());
                }
                if(user.getPassword()!=null){
                    userExist.get().setPassword(user.getPassword());
                }
                if(user.getZone()!=null){
                    userExist.get().setZone(user.getZone());
                }
                if(user.getType()!=null){
                    userExist.get().setType(user.getType());
                }
                return crudRepo.saveUser(userExist.get());
                
            } return user;
            
        } return user;
        
    }
    
    public boolean delete(Integer id) {
        Optional<User> user = crudRepo.getById(id);
        if (user.isPresent()) {
            crudRepo.delete(id);
            return true;
            
        } return false;
        
    }
    
}



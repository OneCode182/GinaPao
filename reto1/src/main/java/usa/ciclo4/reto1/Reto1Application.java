/** < - - - - - - - - {  } - - - - - - - - > */

package usa.ciclo4.reto1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;



@SpringBootApplication
@EntityScan(basePackages = {"usa.ciclo4.reto1.models"})
public class Reto1Application {
    public static void main(String[] args) {
        
        SpringApplication.run(Reto1Application.class, args);
            
    }

}



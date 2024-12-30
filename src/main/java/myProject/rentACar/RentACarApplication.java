package myProject.rentACar;

//import org.modelmapper.ModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class RentACarApplication {

	public static void main(String[] args) {SpringApplication.run(RentACarApplication.class, args);


		System.out.println("Hello World!");


	}
	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}


}

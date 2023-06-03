package Lab4;

import Lab4.domain.Post;
import Lab4.domain.Users;
import Lab4.repositotry.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Autowired
	UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		List<Post> p = new ArrayList<>();
		Users u1 = new Users(0,"Admin",p);
		userRepo.save(u1);
	}
}

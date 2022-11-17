package com.db.webapp;

/* import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired; */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class WebappApplication {

/* 	@Autowired
	UserRepository userRepo; */

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
	}

/* 	@PostConstruct
	public void init() { */

		//List<String> names = userRepo.getName()


/* 		List<User> users = userRepo.findByName("Pena");
		for (User user : users) {
			System.out.println(user.getPassword());
		} */



		//userRepo.save(new User("Pena", "passw"));

		/*
		 * Optional<User> opt = userRepo.findById(0L);
		 * 
		 * if (opt.isPresent()) {
		 * User u = opt.get();
		 * System.out.println(u.getName());
		 * }
		 */
/* 	} */
} 
package com.userlist.userlist;

import com.userlist.userlist.entity.User;
import com.userlist.userlist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class UserlistApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UserlistApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		List<User> user = userRepository.findAllByDeletedUser(false);
		System.out.println("000000000000000000000000000000000000000000000000 " + user);
	}

}

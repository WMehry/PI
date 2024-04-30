package com.example.microfinancepi.appConfig;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FirstAdminConfig {
    @Bean
    public CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            List<User> admins = userRepository.findUserByRole(User_role.ADMIN);
            if (admins == null || admins.size() == 0) {
                User user = new User();
                user.setRole(User_role.ADMIN);
                user.setEmail("admin");
                user.setUser_password("admin");
                userRepository.save(user);
                System.out.println("First adminUser created");

            }

        };
    }
}

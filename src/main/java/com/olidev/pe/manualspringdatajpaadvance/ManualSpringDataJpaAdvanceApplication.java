package com.olidev.pe.manualspringdatajpaadvance;

import com.olidev.pe.manualspringdatajpaadvance.domain.Client;
import com.olidev.pe.manualspringdatajpaadvance.domain.User;
import com.olidev.pe.manualspringdatajpaadvance.repository.ClientRepository;
import com.olidev.pe.manualspringdatajpaadvance.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManualSpringDataJpaAdvanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManualSpringDataJpaAdvanceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            UserRepository userRepository,
            ClientRepository clientRepository
    ) {
        return args -> {
            User user1 = userRepository.save(new User(null, "Olidev", "123456"));
            Client client1 = clientRepository.save(new Client(null, "Jean Yantas", user1)); // Se agrega user1 para la relación 1 a 1
            System.out.println(client1.toString());
        };
    }

}

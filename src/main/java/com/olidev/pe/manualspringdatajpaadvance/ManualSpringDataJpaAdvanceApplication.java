package com.olidev.pe.manualspringdatajpaadvance;

import com.olidev.pe.manualspringdatajpaadvance.domain.Address;
import com.olidev.pe.manualspringdatajpaadvance.domain.Client;
import com.olidev.pe.manualspringdatajpaadvance.domain.User;
import com.olidev.pe.manualspringdatajpaadvance.repository.AddressRepository;
import com.olidev.pe.manualspringdatajpaadvance.repository.ClientRepository;
import com.olidev.pe.manualspringdatajpaadvance.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class ManualSpringDataJpaAdvanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManualSpringDataJpaAdvanceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            UserRepository userRepository,
            ClientRepository clientRepository,
            AddressRepository addressRepository
    ) {
        return args -> {
            User user1 = userRepository.save(new User(null, "Olidev", "123456"));
            Client client1 = clientRepository.save(new Client(null, "juan", user1, null)); // Se agrega user1 para la relación 1 a 1
            Address address1 = addressRepository.save(new Address(null, "calle 1", "012A", client1));
            Address address2 = addressRepository.save(new Address(null, "calle 2", "034B", client1));
            Address address3 = addressRepository.save(new Address(null, "calle 3", "056C", client1));
            Address address4 = addressRepository.save(new Address(null, "calle 4", "078D", client1));
            client1.setAddresses(Set.of(address1, address2, address3, address4));
            Client juan = clientRepository.save(client1); // save detecta que el id de client1 existe y no realiza un insert, solo un update con las nuevas direcciones
            System.out.println("Client name: " + juan.getName());
            System.out.println("User name: " + juan.getUser().getUsername());
            juan.getAddresses().forEach(a -> System.out.println("Address: " + a.getStreet() + " " + a.getNumber() ));

            System.out.println(juan); // Debugear en este punto para que se imprima en consola los datos (si se ejecuta el proyecto general habrá error)
        };
    }

}

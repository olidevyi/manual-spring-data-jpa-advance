package com.olidev.pe.manualspringdatajpaadvance;

import com.olidev.pe.manualspringdatajpaadvance.domain.Address;
import com.olidev.pe.manualspringdatajpaadvance.domain.Client;
import com.olidev.pe.manualspringdatajpaadvance.domain.Product;
import com.olidev.pe.manualspringdatajpaadvance.domain.User;
import com.olidev.pe.manualspringdatajpaadvance.repository.AddressRepository;
import com.olidev.pe.manualspringdatajpaadvance.repository.ClientRepository;
import com.olidev.pe.manualspringdatajpaadvance.repository.ProductRepository;
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
            AddressRepository addressRepository,
            ProductRepository productRepository
    ) {
        return args -> {
            User user1 = userRepository.save(new User(null, "Olidev", "123456"));
            Client client1 = clientRepository.save(new Client(null, "juan", user1, null, null)); // Se agrega user1 para la relación 1 a 1

            // Addresses creation
            Address address1 = addressRepository.save(new Address(null, "calle 1", "012A", client1));
            Address address2 = addressRepository.save(new Address(null, "calle 2", "034B", client1));
            Address address3 = addressRepository.save(new Address(null, "calle 3", "056C", client1));
            Address address4 = addressRepository.save(new Address(null, "calle 4", "078D", client1));
            client1.setAddresses(Set.of(address1, address2, address3, address4));

            // Products creation
            Product product1 = productRepository.save(new Product(null, "iphone 1", 6666.99));
            Product product2 = productRepository.save(new Product(null, "iphone 2", 7777.99));
            Product product3 = productRepository.save(new Product(null, "iphone 3", 8888.99));
            Product product4 = productRepository.save(new Product(null, "iphone 4", 9999.99));
            client1.setProducts(Set.of(product1, product2, product3, product4));

            // Update Data
            Client juan = clientRepository.save(client1); // save detecta que el id de client1 existe y no realiza un insert, solo un update con las nuevas direcciones

            // Print in console
            System.out.println("Client name: " + juan.getName());
            System.out.println("User name: " + juan.getUser().getUsername());
            System.out.println("=============================================================================================");
            juan.getAddresses().forEach(a -> System.out.println("Address: " + a.getStreet() + " " + a.getNumber() ));
            System.out.println("=============================================================================================");
            juan.getProducts().forEach(p -> System.out.println("Products: " + p.getName() + " - Value: " + p.getPrice() ));

            System.out.println(juan); // Debugear en este punto para que se imprima en consola los datos (si se ejecuta el proyecto general habrá error)
        };
    }

}

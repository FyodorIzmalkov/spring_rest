package com.example.mySpringBoot.util;

import com.example.mySpringBoot.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.mySpringBoot.repository.EmployeeRepository;

@Configuration
@Slf4j // @Slf4j is a Lombok annotation to autocreate an Slf4j-based LoggerFactory as log, allowing us to log these newly created "employees".
public class LoadDatabase {

    /**
     * Spring Boot will run ALL CommandLineRunner beans once the application context is loaded.
     */
    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository){
        return args -> {
            log.info("Preloading {}", repository.save(new Employee("Bilbo", "Baggins", "burglar")));
            log.info("Preloading {}", repository.save(new Employee("Frodo","Baggins", "thief")));
        };
    }

}

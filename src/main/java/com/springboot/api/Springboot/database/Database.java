package com.springboot.api.Springboot.database;

import com.springboot.api.Springboot.models.Product;
import com.springboot.api.Springboot.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Database {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository){


        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product productA= new Product(
//                        1L,
                        "Macbook pro 18 inch", 2020, 2400.0, "");
                Product productB= new Product(
//                        2L,
                        "Ipad", 2021, 599.0, "");
//                System.out.println("inter data: "+ productRepository.save(productA));
//                System.out.println("inter data: "+ productRepository.save(productB));
                logger.info("inter data: "+ productRepository.save(productA));
                logger.info("inter data: "+ productRepository.save(productB));
            }
        };
    }
}

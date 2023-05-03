package com.springboot.api.Springboot.database;

import com.springboot.api.Springboot.models.Product;
import com.springboot.api.Springboot.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Now connect with mysql using JPA
/*
docker run -d --rm --name mysql-spring-boot \
-e MYSQL_ROOT_PASSWORD=123456 \
-e MYSQL_USER=sangnd \
-e MYSQL_PASSWORD=123456 \
-e MYSQL_DATABASE=test_db \
-p 3306:3306 \
--volume mysql-spring-boot-volume:/var/lib/mysql \
mysql:latest
mysql:8.0.29

mysql -h localhost -P 3306 --protocol=tcp -u sangnd -p
show databases;
* */

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
//                logger.info("inter data: "+ productRepository.save(productA));
//                logger.info("inter data: "+ productRepository.save(productB));
            }
        };
    }
}

package com.coffee.coffee.fakerData;

import com.coffee.coffee.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Database {






    @Bean
    CommandLineRunner commandLineRunner()
    {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                //khởi tạo dữ liệu mẫu cho role và acceptRole;


            }
        };
    }
}

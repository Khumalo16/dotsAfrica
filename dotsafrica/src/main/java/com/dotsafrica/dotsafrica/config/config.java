package com.dotsafrica.dotsafrica.config;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dotsafrica.dotsafrica.entity.AppUser;
import com.dotsafrica.dotsafrica.entity.Item;
import com.dotsafrica.dotsafrica.repository.ItemRepository;
import com.dotsafrica.dotsafrica.repository.UserRepository;


@Configuration
public class config {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, ItemRepository itemRepository) {
        return args -> {
           AppUser first_user = new AppUser();
           AppUser second_user = new AppUser();

           first_user.setUsername("Ismail");
           userRepository.save(first_user);
           second_user.setUsername("Khumalo");
           userRepository.save(second_user);
           Optional<AppUser> user1 = userRepository.findUserByUsername("Ismail");

           Item item1 = new Item();

           item1.setLabel("Tracking");
           item1.setDescription("Add tags after completing a prject");
           item1.setStatus("not started");
           item1.setUser(user1.get());

           itemRepository.save(item1);
           Item item2 = new Item();

           item2.setLabel("Content");
           item2.setDescription("Meet with the coordinator");
           item2.setStatus("cancelled");
           item2.setUser(user1.get());
           itemRepository.save(item2);




           Optional<AppUser> user2 = userRepository.findUserByUsername("Khumalo");

           Item item3 = new Item();
           
           item3.setLabel("Shop");
           item3.setDescription("Opening a shop in two months");
           item3.setStatus("in progres");
           item3.setUser(user2.get());
           itemRepository.save(item3);

           Item item4 = new Item();

           item4.setLabel("School");
           item4.setDescription("Scheduling time table");
           item4.setStatus("not started");
           item4.setUser(user2.get());
           itemRepository.save(item4);


           Item item5 = new Item();

           item5.setLabel("Verify");
           item5.setDescription("Checking all user if they are stored in the database");
           item5.setStatus("cancelled");
           item5.setUser(user2.get());
           itemRepository.save(item5);

           Item item6 = new Item(); 

           item6.setLabel("Studying");
           item6.setDescription("Preparing for final exams");
           item6.setStatus("in progress");
           item6.setUser(user2.get());
           itemRepository.save(item6);
        };
    }
}

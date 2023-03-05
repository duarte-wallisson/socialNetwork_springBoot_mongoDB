package com.duartewallisson.socialnetworkmongo.config;

import java.util.Arrays;

import com.duartewallisson.socialnetworkmongo.domain.User;
import com.duartewallisson.socialnetworkmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;



@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userReposiroty;

    @Override
    public void run(String... arg0) throws Exception {

        userReposiroty.deleteAll();


        User monica = new User(null, "Monica Green", "monica.green@gmail.com");
        User eduardo = new User(null, "Eduardo Green", "eduardo.green@gmail.com");
        User maria = new User(null, "Maria Brown", "maria@gmail.com");

        userReposiroty.saveAll(Arrays.asList(monica, eduardo, maria));
    }

}
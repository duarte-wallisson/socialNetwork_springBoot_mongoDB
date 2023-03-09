package com.duartewallisson.socialnetworkmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.duartewallisson.socialnetworkmongo.domain.Post;
import com.duartewallisson.socialnetworkmongo.domain.User;
import com.duartewallisson.socialnetworkmongo.repository.PostRepository;
import com.duartewallisson.socialnetworkmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... arg0) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        userRepository.deleteAll();
        postRepository.deleteAll();

        User monica = new User(null, "Monica Green", "monica.green@gmail.com");
        User eduardo = new User(null, "Eduardo Green", "eduardo.green@gmail.com");
        User maria = new User(null, "Maria Brown", "maria@gmail.com");

        Post post1 = new Post(null, sdf.parse("09/03/2023"), "Partiu viagem", "Vou viajar para a Tailândia. Abraços!", eduardo);
        Post post2 = new Post(null, sdf.parse("09/03/2023"), "Bom dia", "Acordei feliz hoje!", monica);

        userRepository.saveAll(Arrays.asList(monica, eduardo, maria));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }

}
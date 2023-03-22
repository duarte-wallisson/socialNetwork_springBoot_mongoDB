package com.duartewallisson.socialnetworkmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import com.duartewallisson.socialnetworkmongo.domain.Post;
import com.duartewallisson.socialnetworkmongo.domain.User;
import com.duartewallisson.socialnetworkmongo.dto.AuthorDTO;
import com.duartewallisson.socialnetworkmongo.repository.PostRepository;
import com.duartewallisson.socialnetworkmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.duartewallisson.socialnetworkmongo.dto.CommentDTO;

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
        userRepository.saveAll(Arrays.asList(monica, eduardo, maria));

        Post post1 = new Post(null, sdf.parse("09/03/2023"), "Partiu viagem", "Vou viajar para a Tailândia. Abraços!", new AuthorDTO(eduardo));
        Post post2 = new Post(null, sdf.parse("09/03/2023"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(monica));

        CommentDTO c1 = new CommentDTO("Boa viagem!", sdf.parse("21/03/2018"), new AuthorDTO(maria));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(monica));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(eduardo));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        eduardo.getPosts().add(post1);
        monica.getPosts().add(post2);
        userRepository.saveAll(Arrays.asList(eduardo, monica));
    }
}
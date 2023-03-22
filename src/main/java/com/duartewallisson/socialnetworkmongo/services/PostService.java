package com.duartewallisson.socialnetworkmongo.services;

import com.duartewallisson.socialnetworkmongo.domain.Post;
import com.duartewallisson.socialnetworkmongo.repository.PostRepository;
import com.duartewallisson.socialnetworkmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;

    public  Post findById(String id) {
        Optional<Post> o = repo.findById(id);
        return o.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }

}

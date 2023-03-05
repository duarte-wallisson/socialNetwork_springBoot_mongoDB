package com.duartewallisson.socialnetworkmongo.services;

import com.duartewallisson.socialnetworkmongo.domain.User;
import com.duartewallisson.socialnetworkmongo.repository.UserRepository;
import com.duartewallisson.socialnetworkmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> o = repo.findById(id);
        return o.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}

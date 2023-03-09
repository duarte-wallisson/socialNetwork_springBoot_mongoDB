package com.duartewallisson.socialnetworkmongo.services;

import com.duartewallisson.socialnetworkmongo.domain.User;
import com.duartewallisson.socialnetworkmongo.dto.UserDTO;
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

    public User findById(String id) {
        Optional<User> o = repo.findById(id);
        return o.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDTO) {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public void update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

}

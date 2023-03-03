package com.duartewallisson.socialnetworkmongo.resources;

import com.duartewallisson.socialnetworkmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User eduardo = new User("1", "Eduardo Green", "eduardo.green@email.com");
        User monica = new User("1", "Monica Green", "monica.green@email.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(eduardo, monica));
        return ResponseEntity.ok().body(list);
    }
}

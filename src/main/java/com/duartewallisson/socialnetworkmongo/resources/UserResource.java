package com.duartewallisson.socialnetworkmongo.resources;

import com.duartewallisson.socialnetworkmongo.domain.User;
import com.duartewallisson.socialnetworkmongo.dto.UserDTO;
import com.duartewallisson.socialnetworkmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService service;
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(it -> new UserDTO(it)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}

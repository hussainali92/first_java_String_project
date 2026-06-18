package com.in28minutes.rest.web.rest_web_services.User;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> retrieveallusers(){
        return userDaoService.findall();
    }
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User user= userDaoService.findone(id);
        if(user==null)
            throw new UserNotFoundException("id"+ id);
        return user;
    }
    @PostMapping("/users")
    public ResponseEntity<User> createuser(@Valid @RequestBody User user){
        User saverUser = userDaoService.save(user);
        User savedUser = userDaoService. save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                . buildAndExpand(savedUser.getId())
                . toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/users/{id}")
    public void deleteuser(@PathVariable int id){
        userDaoService.deletebyid(id);
    }


}

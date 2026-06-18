package com.in28minutes.rest.web.rest_web_services.Jpa;

import com.in28minutes.rest.web.rest_web_services.User.User;
import com.in28minutes.rest.web.rest_web_services.User.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResource {

    private JpaUserRepository jpaUserRepository;
    private PostRepository postRepository;


    public UserJpaResource(JpaUserRepository jpaUserRepository, PostRepository postRepository) {
        this.jpaUserRepository = jpaUserRepository;
        this.postRepository = postRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveallusers(){
        return jpaUserRepository.findAll();
    }
    @GetMapping("/jpa/users/{id}")
    public Optional<User> retrieveUser(@PathVariable int id){
        Optional<User> user= jpaUserRepository.findById(id);
        if(user==null)
            throw new UserNotFoundException("id"+ id);
        return user;
    }
    @PostMapping("/jpa/users")
    public ResponseEntity<User> createuser(@Valid @RequestBody User user){
        User savedUser = jpaUserRepository. save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                . buildAndExpand(savedUser.getId())
                . toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/jpa/users/{id}")
    public void deleteuser(@PathVariable int id){
        jpaUserRepository.deleteById(id);
    }
    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveAllPostsForUser(@PathVariable int id){
        Optional<User> user= jpaUserRepository.findById(id);
        if(user==null)
            throw new UserNotFoundException("id"+ id);
        return user.get().getPosts();
    }
    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostForAUser(@PathVariable int id , @Valid @RequestBody Post post){
        Optional<User> user= jpaUserRepository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("id"+ id);
        post.setUser(user.get());
        Post saved_post= postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand (saved_post.getId ())
                .toUri();
        return ResponseEntity. created(location).build();
    }

}

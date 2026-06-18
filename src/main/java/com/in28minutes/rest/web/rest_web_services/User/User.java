package com.in28minutes.rest.web.rest_web_services.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.in28minutes.rest.web.rest_web_services.Jpa.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "user_details")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2)
    private String full_name;
    @Past
    private LocalDate birthdate;


   @OneToMany(mappedBy = "user")
   @JsonIgnore
    private List<Post> posts ;

    public User() {
    }

    public User(Integer id, String name, LocalDate date) {
        this.id = id;
        this.full_name = name;
        this.birthdate = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return full_name;
    }

    public void setName(String name) {
        this.full_name = name;
    }

    public LocalDate getBirthDate() {
        return birthdate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthdate = birthDate;
    }

    public List<Post> getPosts() {
       return posts;
    }

    public void setPosts(List<Post> posts) {
     this.posts = posts;
  }
}

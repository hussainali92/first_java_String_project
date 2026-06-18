package com.in28minutes.rest.web.rest_web_services.Jpa;

import com.in28minutes.rest.web.rest_web_services.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<User,Integer> {
}

package com.in28minutes.rest.web.rest_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonSbiController {

@GetMapping(value="/{version}/personsbi", version="1.0.0")
public Personv1 getFirstVersionofPerson() {
        return new Personv1 ("Bob Charlie");
        }
@GetMapping (value="/{version}/personsbi", version="2.0.0")
public Personv2 getSecondVersion0fPerson() {
        return new Personv2 (new Name ("Bob", "Charlie"));
}
@GetMapping (path = "/personsbi", version="1.0.0")
public Personv1 getFirstVersionOfPersonRequestParameter() {
        return new Personv1 ("'Bob Charlie");
        }
@GetMapping (path = "/personsbi", version="2.0.0")
public Personv2 getSecondVersionOfPersonRequestParameter() {
        return new Personv2 (new Name ("Bob", "Charlie"));
        }
}
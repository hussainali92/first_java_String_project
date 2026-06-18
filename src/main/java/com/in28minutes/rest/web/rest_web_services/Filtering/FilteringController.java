package com.in28minutes.rest.web.rest_web_services.Filtering;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public Somebean filtering(){
        return new Somebean("value1","value2","value3") ;
    }
    @GetMapping("/filtering-list")
    public List<Somebean> filteringList(){
        return Arrays.asList(new Somebean("value1","value2","value3"),
                             new Somebean("value4","value5","value6")) ;
    }
    @GetMapping("/filtering-with-view") //Static_Filtering
    @JsonView(View.View1.class)
    public Somebean filteringWithView(){
        return new Somebean("value1","value2","value3") ;
    }
    @JsonView(View.View2.class)
    @GetMapping("/filtering-list-with-view")  //Static_Filtering
    public List<Somebean> filteringListWithView(){
        return Arrays.asList(new Somebean("value1","value2","value3"),
                new Somebean("value4","value5","value6")) ;
    }
}

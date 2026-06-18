package com.in28minutes.rest.web.rest_web_services.Filtering;

import com.fasterxml.jackson.annotation.JsonView;

//@JsonIgnoreProperties("field2") //another_static_filtering
public class Somebean {

    @JsonView(View.View1.class)  //Static_Filtering
    private String field1;
    @JsonView(View.View2.class)  //Static_Filtering
    private String field2;
    @JsonView({View.View1.class,View.View2.class})  //Dynamic_Filtering
    private String field3;

    public Somebean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }
}


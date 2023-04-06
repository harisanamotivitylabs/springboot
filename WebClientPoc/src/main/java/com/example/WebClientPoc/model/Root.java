package com.example.WebClientPoc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Root{

    @JsonIgnoreProperties(ignoreUnknown = true)
    public HashMap<String,Name> name;

    public Root() {
    }

    public Root(HashMap<String, Name> name) {
        this.name = name;
    }

    public HashMap<String, Name> getName() {
        return name;
    }

    public void setName(HashMap<String, Name> name) {
        this.name = name;
    }

//    private List<Name> name;
//
//    public List<Name> getName() {
//        return name;
//    }
//
//    public void setName(List<Name> name) {
//        this.name = name;
//    }
//
//    public Root(List<Name> name) {
//        this.name = name;
//    }
//
//    public Root() {
//    }
}

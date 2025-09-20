package org.taib.pom.objects;

import org.taib.pom.utils.JacksonUtils;

import java.io.IOException;

public class Products {
    private int id;
    private String name;


    public Products(){}

    public Products(int id) throws IOException {

       Products[] products = JacksonUtils.deserialize("products.json", Products[].class);
       for(Products prod: products){
           if(prod.getId() == id){
               this.id = prod.getId();
               this.name = prod.getName();
           }
       }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}



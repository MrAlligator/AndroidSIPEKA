package com.example.sipeka.Model.Indonesia;

public class Provinsi {

    String id;
    String name;

    public Provinsi() {
    }

    public Provinsi(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

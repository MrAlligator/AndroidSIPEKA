package com.example.sipeka.Model.Indonesia;

public class Kecamatan {

    String id;
    String regency_id;
    String name;

    public Kecamatan() {
    }

    public Kecamatan(String id, String regency_id, String name) {
        this.id = id;
        this.regency_id = regency_id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegency_id() {
        return regency_id;
    }

    public void setRegency_id(String regency_id) {
        this.regency_id = regency_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

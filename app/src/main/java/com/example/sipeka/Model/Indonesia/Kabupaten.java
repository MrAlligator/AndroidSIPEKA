package com.example.sipeka.Model.Indonesia;

public class Kabupaten {

    String id;
    String province_id;
    String name;

    public Kabupaten() {
    }

    public Kabupaten(String id, String province_id, String name) {
        this.id = id;
        this.province_id = province_id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

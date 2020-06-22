package com.example.sipeka.Model.Indonesia;

public class Desa {

    String id;
    String district_id;
    String name;

    public Desa(){

    }

    public Desa(String id, String district_id, String name) {
        this.id = id;
        this.district_id = district_id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

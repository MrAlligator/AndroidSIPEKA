package com.example.sipeka.Model.Ktp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetKtp {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Ktp> listDataKtp;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<Ktp> getListDataKtp() {
        return listDataKtp;
    }
    public void setListDataKtp(List<Ktp> listDataKtp) {
        this.listDataKtp = listDataKtp;
    }
}

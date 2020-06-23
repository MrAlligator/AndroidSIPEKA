package com.example.sipeka.Model.Kk;

import com.example.sipeka.Model.Ktp.Ktp;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetKk {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Kk> listDataKk;
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
    public List<Kk> getListDataKk() {
        return listDataKk;
    }
    public void setListDataKtp(List<Kk> listDataKk) {
        this.listDataKk = listDataKk;
    }
}

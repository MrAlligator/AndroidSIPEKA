package com.example.sipeka.Model.Anggota;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetAnggota {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Anggota> listDataAnggota;
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
    public List<Anggota> getListDataAnggota() {
        return listDataAnggota;
    }
    public void setListDataAnggota(List<Anggota> listDataAnggota) {
        this.listDataAnggota = listDataAnggota;
    }
}

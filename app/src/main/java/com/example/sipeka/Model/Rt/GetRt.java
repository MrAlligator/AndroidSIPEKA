package com.example.sipeka.Model.Rt;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetRt {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Rt> listDataRt;
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
    public List<Rt> getListDataRt() {
        return listDataRt;
    }
    public void setListDataRt(List<Rt> listDataRt) {
        this.listDataRt = listDataRt;
    }
}

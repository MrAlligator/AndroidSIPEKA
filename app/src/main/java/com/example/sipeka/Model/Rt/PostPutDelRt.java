package com.example.sipeka.Model.Rt;

import com.google.gson.annotations.SerializedName;

public class PostPutDelRt {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Rt mRt;
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
    public Rt getKontak() {
        return mRt;
    }
    public void setKontak(Rt Rt) { mRt = Rt;
    }
}

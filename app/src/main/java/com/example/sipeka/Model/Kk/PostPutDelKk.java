package com.example.sipeka.Model.Kk;

import com.example.sipeka.Model.Kk.Kk;
import com.google.gson.annotations.SerializedName;

public class PostPutDelKk {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Kk mKk;
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
    public Kk getKontak() {
        return mKk;
    }
    public void setKontak(Kk Kk) { mKk = Kk;
    }
}

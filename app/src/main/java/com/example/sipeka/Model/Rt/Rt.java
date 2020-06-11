package com.example.sipeka.Model.Rt;

import com.google.gson.annotations.SerializedName;

public class Rt {
    @SerializedName("kodeRt")
    private String kodeRt;
    @SerializedName("rt")
    private String rt;
    @SerializedName("rw")
    private String rw;

    public Rt(String id, String rt, String rw) {
        this.kodeRt = kodeRt;
        this.rt = rt;
        this.rw = rw;
    }
    public String getKodeRt() {
        return kodeRt;
    }

    public String getRt() {
        return rt;
    }

    public String getRw() {
        return rw;
    }

    public void setKodeRt(String kodeRt) {
        this.kodeRt = kodeRt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public void setRw(String rw) {
        this.rw = rw;
    }
}


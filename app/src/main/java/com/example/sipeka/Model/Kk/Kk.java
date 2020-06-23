package com.example.sipeka.Model.Kk;

import com.google.gson.annotations.SerializedName;

public class Kk {
    @SerializedName("noKk")
    private String noKk;
    @SerializedName("namaKk")
    private String namaKk;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("kelurahan")
    private String kelurahan;
    @SerializedName("kecamatan")
    private String kecamatan;
    @SerializedName("kabupaten")
    private String kabupaten;
    @SerializedName("kodePos")
    private String kodePos;
    @SerializedName("provinsi")
    private String provinsi;
    @SerializedName("dikeluarkanTanggal")
    private String dikeluarkanTanggal;
    @SerializedName("kodeRt")
    private String kodeRt;

    public Kk(String noKk, String namaKk, String alamat, String kelurahan, String kecamatan, String kabupaten, String kodePos, String provinsi, String dikeluarkanTanggal, String kodeRt) {
        this.noKk = noKk;
        this.namaKk = namaKk;
        this.alamat = alamat;
        this.kelurahan = kelurahan;
        this.kecamatan = kecamatan;
        this.kabupaten = kabupaten;
        this.kodePos = kodePos;
        this.provinsi = provinsi;
        this.dikeluarkanTanggal = dikeluarkanTanggal;
        this.kodeRt = kodeRt;
    }

    public String getNoKk() {
        return noKk;
    }

    public void setNoKk(String noKk) {
        this.noKk = noKk;
    }

    public String getNamaKk() {
        return namaKk;
    }

    public void setNamaKk(String namaKk) {
        this.namaKk = namaKk;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getDikeluarkanTanggal() {
        return dikeluarkanTanggal;
    }

    public void setDikeluarkanTanggal(String dikeluarkanTanggal) {
        this.dikeluarkanTanggal = dikeluarkanTanggal;
    }

    public String getKodeRt() {
        return kodeRt;
    }

    public void setKodeRt(String kodeRt) {
        this.kodeRt = kodeRt;
    }
}

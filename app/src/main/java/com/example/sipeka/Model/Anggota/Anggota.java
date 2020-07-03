package com.example.sipeka.Model.Anggota;

import com.google.gson.annotations.SerializedName;

public class Anggota {
    @SerializedName("provinsi")
    private String provinsi;
    @SerializedName("kabupaten")
    private String kabupaten;
    @SerializedName("nik")
    private String nik;
    @SerializedName("noKk")
    private String noKk;
    @SerializedName("nama")
    private String nama;
    @SerializedName("tempatLahir")
    private String tempatLahir;
    @SerializedName("tanggalLahir")
    private String tanggalLahir;
    @SerializedName("jenisKelamin")
    private String jenisKelamin;
    @SerializedName("golDarah")
    private String golDarah;
    @SerializedName("kodeRt")
    private String kodeRt;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("kelurahan")
    private String kelurahan;
    @SerializedName("kecamatan")
    private String kecamatan;
    @SerializedName("agama")
    private String agama;
    @SerializedName("statusPerkawinan")
    private String statusPerkawinan;
    @SerializedName("pekerjaan")
    private String pekerjaan;
    @SerializedName("kewarganegaraan")
    private String kewarganegaraan;
    @SerializedName("berlakuHingga")
    private String berlakuHingga;
    @SerializedName("gambar_Ktp")
    private String gambar_Ktp;

    public Anggota(String provinsi, String kabupaten, String nik, String noKk, String nama, String tempatLahir, String tanggalLahir, String jenisKelamin, String golDarah, String alamat, String kodeRt, String kodeRw, String kelurahan, String kecamatan, String agama, String statusPerkawinan, String pekerjaan, String kewarganegaraan, String berlakuHingga, String gambar_Ktp) {
        this.provinsi = provinsi;
        this.kabupaten = kabupaten;
        this.nik = nik;
        this.noKk = noKk;
        this.nama = nama;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
        this.golDarah = golDarah;
        this.alamat = alamat;
        this.kodeRt = kodeRt;
        this.kelurahan = kelurahan;
        this.kecamatan = kecamatan;
        this.agama = agama;
        this.statusPerkawinan = statusPerkawinan;
        this.pekerjaan = pekerjaan;
        this.kewarganegaraan = kewarganegaraan;
        this.berlakuHingga = berlakuHingga;
        this.gambar_Ktp = gambar_Ktp;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNoKk() {
        return noKk;
    }

    public void setNoKk(String noKk) {
        this.noKk = noKk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getGolDarah() {
        return golDarah;
    }

    public void setGolDarah(String golDarah) {
        this.golDarah = golDarah;
    }

    public String getKodeRt() {
        return kodeRt;
    }

    public void setKodeRt(String kodeRt) {
        this.kodeRt = kodeRt;
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

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getStatusPerkawinan() {
        return statusPerkawinan;
    }

    public void setStatusPerkawinan(String statusPerkawinan) {
        this.statusPerkawinan = statusPerkawinan;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getKewarganegaraan() {
        return kewarganegaraan;
    }

    public void setKewarganegaraan(String kewarganegaraan) {
        this.kewarganegaraan = kewarganegaraan;
    }

    public String getBerlakuHingga() {
        return berlakuHingga;
    }

    public void setBerlakuHingga(String berlakuHingga) {
        this.berlakuHingga = berlakuHingga;
    }

    public String getGambar_Ktp() {
        return gambar_Ktp;
    }

    public void setGambar_Ktp(String gambar_Ktp) {
        this.gambar_Ktp = gambar_Ktp;
    }
}

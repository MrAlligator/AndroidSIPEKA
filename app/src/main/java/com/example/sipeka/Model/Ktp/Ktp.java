package com.example.sipeka.Model.Ktp;

import com.google.gson.annotations.SerializedName;

public class Ktp {
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

    public Ktp(String provinsi, String kabupaten, String nik, String noKk, String nama, String tempatLahir, String tanggalLahir, String jenisKelamin, String golDarah, String alamat, String kodeRt, String kodeRw, String kelurahan, String kecamatan, String agama, String statusPerkawinan, String pekerjaan, String kewarganegaraan, String berlakuHingga, String gambar_Ktp) {
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

        public String getKabupaten() {
            return kabupaten;
        }

        public String getNik() {
            return nik;
        }

        public String getNoKk() {
            return noKk;
        }

        public String getNama() {
            return nama;
        }

        public String getTempatLahir() {
            return tempatLahir;
        }

        public String getTanggalLahir() {
            return tanggalLahir;
        }

        public String getJenisKelamin() {
            return jenisKelamin;
        }

        public String getGolDarah() {
            return golDarah;
        }

        public String getKodeRt() {
            return kodeRt;
        }

        public String getAlamat() {
            return alamat;
        }

        public String getKelurahan() {
            return kelurahan;
        }

        public String getKecamatan() {
            return kecamatan;
        }

        public String getAgama() {
            return agama;
        }

        public String getStatusPerkawinan() {
            return statusPerkawinan;
        }

        public String getPekerjaan() {
            return pekerjaan;
        }

        public String getKewarganegaraan() {
            return kewarganegaraan;
        }

        public String getBerlakuHingga() {
            return berlakuHingga;
        }

        public String getGambar_Ktp() {
            return gambar_Ktp;
        }

        public void setProvinsi(String provinsi) {
            this.provinsi = provinsi;
        }

        public void setKabupaten(String kabupaten) {
            this.kabupaten = kabupaten;
        }

        public void setNik(String nik) {
            this.nik = nik;
        }

        public void setNoKk(String noKk) {
            this.noKk = noKk;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public void setTempatLahir(String tempatLahir) {
            this.tempatLahir = tempatLahir;
        }

        public void setTanggalLahir(String tanggalLahir) {
            this.tanggalLahir = tanggalLahir;
        }

        public void setJenisKelamin(String jenisKelamin) {
            this.jenisKelamin = jenisKelamin;
        }

        public void setGolDarah(String golDarah) {
            this.golDarah = golDarah;
        }

        public void setKodeRt(String kodeRt) {
            this.kodeRt = kodeRt;
        }

        public void setAlamat(String alamat) {
            this.alamat = alamat;
        }

        public void setKelurahan(String kelurahan) {
            this.kelurahan = kelurahan;
        }

        public void setKecamatan(String kecamatan) {
            this.kecamatan = kecamatan;
        }

        public void setAgama(String agama) {
            this.agama = agama;
        }

        public void setStatusPerkawinan(String statusPerkawinan) {
            this.statusPerkawinan = statusPerkawinan;
        }

        public void setPekerjaan(String pekerjaan) {
            this.pekerjaan = pekerjaan;
        }

        public void setKewarganegaraan(String kewarganegaraan) {
            this.kewarganegaraan = kewarganegaraan;
        }

        public void setBerlakuHingga(String berlakuHingga) {
            this.berlakuHingga = berlakuHingga;
        }

        public void setGambar_Ktp(String gambar_Ktp) {
            this.gambar_Ktp = gambar_Ktp;
        }
    }




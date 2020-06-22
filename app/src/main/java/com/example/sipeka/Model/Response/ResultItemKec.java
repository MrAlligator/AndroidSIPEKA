package com.example.sipeka.Model.Response;

public class ResultItemKec {
    private String id_kec;
    private String nama_kec;

    public String getId_kec() {
        return id_kec;
    }

    public void setId_kec(String id_kec) {
        this.id_kec = id_kec;
    }

    public String getNama_kec() {
        return nama_kec;
    }

    public void setNama_kec(String nama_kec) {
        this.nama_kec = nama_kec;
    }

    @Override
    public String toString(){
        return
                "ResultItemKec{" +
                        "id_kabkot = '" + id_kec + '\'' +
                        ",nama_kabkot = '" + nama_kec + '\'' +
                        "}";
    }
}

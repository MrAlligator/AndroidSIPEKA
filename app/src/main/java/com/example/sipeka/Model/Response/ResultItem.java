package com.example.sipeka.Model.Response;

public class ResultItem {
	private String namaKabkot;
	private String idKabkot;

	public String getNamaKabkot() {
		return namaKabkot;
	}

	public void setNamaKabkot(String namaKabkot) {
		this.namaKabkot = namaKabkot;
	}

	public String getIdKabkot() {
		return idKabkot;
	}

	public void setIdKabkot(String idKabkot) {
		this.idKabkot = idKabkot;
	}

	@Override
 	public String toString(){
		return 
			"ResultItem{" + 
			"id_kabkot = '" + idKabkot + '\'' +
			",nama_kabkot = '" + namaKabkot + '\'' +
			"}";
		}
}

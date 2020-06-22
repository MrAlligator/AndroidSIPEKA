package com.example.sipeka.Model.Response;

public class ResultItem {
	private String id_kabkot;
	private String nama_kabkot;
	private String id_kec;
	private String nama_kec;

	public String getId_kabkot() {
		return id_kabkot;
	}

	public void setId_kabkot(String id_kabkot) {
		this.id_kabkot = id_kabkot;
	}

	public String getNama_kabkot() {
		return nama_kabkot;
	}

	public void setNama_kabkot(String nama_kabkot) {
		this.nama_kabkot = nama_kabkot;
	}

	@Override
	public String toString(){
		return
				"ResultItem{" +
						"id_kabkot = '" + id_kabkot + '\'' +
						",nama_kabkot = '" + nama_kabkot + '\'' +
						"}";
	}
}

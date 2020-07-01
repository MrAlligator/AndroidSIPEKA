package com.example.sipeka.Model.Response;

public class ResultItem{
	private String kodeRt;
	private String rt;
	private String rw;

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt= rt;
	}

	public String getKodeRt() {
		return kodeRt;
	}

	public void setKodeRt(String kodeRt) {
		this.kodeRt = kodeRt;
	}

	public String getRw() {
		return rw;
	}

	public void setRw(String rw) {
		this.rw = rw;
	}

	@Override
	public String toString(){
		return
				"ResultItem{" +
						"kodeRt = '" + kodeRt + '\'' +
						",rt = '" + rt + '\'' +
						",rw = '" + rw + '\'' +
						"}";
	}
}

package com.example.sipeka.Model.Response;

import java.util.List;

public class ResponseRt{
	private List<ResultItem> result;
	private int jsonMember0;

	public void setResult(List<ResultItem> result){
		this.result = result;
	}

	public List<ResultItem> getResult(){
		return result;
	}

	public void setJsonMember0(int jsonMember0){
		this.jsonMember0 = jsonMember0;
	}

	public int getJsonMember0(){
		return jsonMember0;
	}

	@Override
	public String toString(){
		return
				"ResponseRt{" +
						"result = '" + result + '\'' +
						",0 = '" + jsonMember0 + '\'' +
						"}";
	}
}
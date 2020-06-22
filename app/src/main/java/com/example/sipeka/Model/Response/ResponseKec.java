package com.example.sipeka.Model.Response;

import java.util.List;

public class ResponseKec {
    private List<ResultItemKec> result;
    private int jsonMember0;

    public void setResult(List<ResultItemKec> result){
        this.result = result;
    }

    public List<ResultItemKec> getResultKec(){
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
                "ResponseKec{" +
                        "result = '" + result + '\'' +
                        ",0 = '" + jsonMember0 + '\'' +
                        "}";
    }
}

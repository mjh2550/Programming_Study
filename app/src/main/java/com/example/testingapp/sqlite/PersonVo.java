package com.example.testingapp.sqlite;

public class PersonVo {

    private int Idx;
    private String name;
    private String tel;

    public int getIdx() {
        return Idx;
    }

    public void setIdx(int idx) {
        Idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}

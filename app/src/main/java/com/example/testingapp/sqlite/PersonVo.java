package com.example.testingapp.sqlite;

import java.io.Serializable;

public class PersonVo implements Serializable {

    private int Idx;
    private String name;
    private String tel;

    public PersonVo() {
    }

    public PersonVo(int idx, String name, String tel) {
        Idx = idx;
        this.name = name;
        this.tel = tel;
    }

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

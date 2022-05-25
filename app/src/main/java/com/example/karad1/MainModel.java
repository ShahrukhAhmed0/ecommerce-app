package com.example.karad1;

public class MainModel {

    Integer langLogo;
    String langName;
    public MainModel(Integer langLogo,String langName)
    {
        this.langLogo=langLogo;
        this.langName=langName;
    }

    public Integer getLangLogo() {
        return langLogo;
    }

    public String getLangName() {
        return langName;
    }
}


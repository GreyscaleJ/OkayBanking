package com.bpcbt.OkayBanking.controller.faces;


public class MainPage {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String navigateToUserData() {
        return "userdata";
    }
}

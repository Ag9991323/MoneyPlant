package com.example.networkmarketing.models;

public class myChild {
    String mobilenumber,name,referer;

    public myChild() {
    }

    public myChild(String mobilenumber, String name, String referer) {
        this.mobilenumber = mobilenumber;
        this.name = name;
        this.referer = referer;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }
}

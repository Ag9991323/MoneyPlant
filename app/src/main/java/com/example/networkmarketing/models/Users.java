package com.example.networkmarketing.models;

public class Users {
   String MobileNumber,bankaccount,referid,ifsccode,name,payment,uid;

    public Users() {
    }

    public Users(String MobileNumber, String bankaccount, String referid, String ifsccode, String name, String payment, String uid) {
        this.MobileNumber = MobileNumber;
        this.bankaccount = bankaccount;
        this.referid = referid;
        this.ifsccode = ifsccode;
        this.name = name;
        this.payment = payment;
        this.uid = uid;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String MobileNumber) {
        MobileNumber = MobileNumber;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

    public String getReferid() {
        return referid;
    }

    public void setReferid(String referid) {
        this.referid = referid;
    }

    public String getIfsccode() {
        return ifsccode;
    }

    public void setIfsccode(String ifsccode) {
        this.ifsccode = ifsccode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}

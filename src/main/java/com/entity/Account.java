package com.entity;

public class Account {

    private long phone;
    private String passwd;
    private byte frozen;
    private String name;
    private String identity;

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public byte getFrozen() {
        return frozen;
    }

    public void setFrozen(byte frozen) {
        this.frozen = frozen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}


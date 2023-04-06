package com.example.WebClientPoc.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Name {
    @JsonProperty("name")
    public String name;
    @JsonProperty("company")
    public String company;
    @JsonProperty("department")
    public String department;

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", department='" + department + '\'' +
                ", phone='" + phone + '\'' +
                ", roles=" + roles +
                ", apps=" + apps +
                ", is_active=" + is_active +
                ", mfa_on=" + mfa_on +
                '}';
    }

    @JsonProperty("phone")
    public String phone;
    @JsonProperty("roles")
    public ArrayList<Object> roles;
    @JsonProperty("apps")
    public ArrayList<Object> apps;
    @JsonProperty("is_active")
    public boolean is_active;

    @JsonProperty("mfa_on")
    public boolean mfa_on;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Object> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Object> roles) {
        this.roles = roles;
    }

    public ArrayList<Object> getApps() {
        return apps;
    }

    public void setApps(ArrayList<Object> apps) {
        this.apps = apps;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public boolean isMfa_on() {
        return mfa_on;
    }

    public void setMfa_on(boolean mfa_on) {
        this.mfa_on = mfa_on;
    }

    public Name(String name, String company, String department, String phone, ArrayList<Object> roles, ArrayList<Object> apps, boolean is_active, boolean mfa_on) {
        this.name = name;
        this.company = company;
        this.department = department;
        this.phone = phone;
        this.roles = roles;
        this.apps = apps;
        this.is_active = is_active;
        this.mfa_on = mfa_on;
    }

    public Name() {
    }

}


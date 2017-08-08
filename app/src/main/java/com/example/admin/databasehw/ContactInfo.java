package com.example.admin.databasehw;

/**
 * Created by Admin on 8/7/2017.
 */

public class ContactInfo
{
    String name;
    String phone;
    String email;
    String Address;
    String JobTitle;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public ContactInfo(String name, String phone, String email, String address, String JobTitle) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.Address = address;
        this.JobTitle = JobTitle;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

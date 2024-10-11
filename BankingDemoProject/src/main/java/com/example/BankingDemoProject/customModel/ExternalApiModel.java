package com.example.BankingDemoProject.customModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExternalApiModel {

    private int id;
    private String name;
    private String company;
    private String email;
    private String address;
    private String zip;
    private String state;
    private String country;
    private String phone;
    private String photo;


    public ExternalApiModel(int id, String name, String company, String email, String address, String zip, String state, String country, String phone, String photo) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.email = email;
        this.address = address;
        this.zip = zip;
        this.state = state;
        this.country = country;
        this.phone = phone;
        this.photo = photo;
    }

    public ExternalApiModel(){}

    @Override
    public String toString() {
        return "ExternalApiModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", zip='" + zip + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}

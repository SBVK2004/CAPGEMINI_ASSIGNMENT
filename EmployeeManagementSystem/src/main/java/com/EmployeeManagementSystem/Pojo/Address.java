package com.EmployeeManagementSystem.Pojo;


public class Address {

    private int id;
    private String city;
    private String state;
    private String country;
    private int pincode;

    // Constructor Injection - used by Spring XML
    public Address(int id, String city, String state, String country, int pincode) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }

    // Getters
    public int getId()       { return id; }
    public String getCity()  { return city; }
    public String getState() { return state; }
    public String getCountry() { return country; }
    public int getPincode()  { return pincode; }

    // Setters
    public void setId(int id)             { this.id = id; }
    public void setCity(String city)      { this.city = city; }
    public void setState(String state)    { this.state = state; }
    public void setCountry(String country){ this.country = country; }
    public void setPincode(int pincode)   { this.pincode = pincode; }

    @Override
    public String toString() {
        return "City: " + city + "\nState: " + state +
               "\nCountry: " + country + "\nPincode: " + pincode;
    }
}
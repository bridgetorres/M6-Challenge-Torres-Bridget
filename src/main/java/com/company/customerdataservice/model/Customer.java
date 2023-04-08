package com.company.customerdataservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="customer")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private int customerId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;
    private String company;
    private String phone;
    private String address_one;
    private String address_two;
    @NotNull
    private String city;
    @NotNull
    private String state;

    private int postalCode;
    private String country;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress_one() {
        return address_one;
    }

    public void setAddress_one(String address_one) {
        this.address_one = address_one;
    }

    public String getAddress_two() {
        return address_two;
    }

    public void setAddress_two(String address_two) {
        this.address_two = address_two;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getId(), customer.getCustomerId()) &&
                Objects.equals(getFirstName(), customer.getFirstName()) &&
                Objects.equals(getLastName(), customer.getLastName()) &&
                Objects.equals(getEmail(), customer.getEmail()) &&
                Objects.equals(getAddress_one(), customer.getAddress_one()) &&
                Objects.equals(getAddress_two(), customer.getAddress_two()) &&
                Objects.equals(getPostalCode(), customer.getPostalCode()) &&
                Objects.equals(getCompany(), customer.getCompany()) &&
                Objects.equals(getCity(), customer.getCity()) &&
                Objects.equals(getPhone(), customer.getPhone()) &&
                Objects.equals(getCountry(), customer.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getCompany(), getPhone(),getAddress_one(),getAddress_two(),getPostalCode(), getEmail(),getCountry(), getCity());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                ", address_one='" + address_one + '\'' +
                ", address_two='" + address_two + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode=" + postalCode +
                ", country='" + country + '\'' +
                '}';
    }
}

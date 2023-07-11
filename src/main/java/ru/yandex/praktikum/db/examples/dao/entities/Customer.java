package ru.yandex.praktikum.db.examples.dao.entities;

import java.util.Objects;

public class Customer {

    private long id;
    private String name;
    private String phone;
    private String email;

    public Customer(long id, String name, String phone, String email) {
        this(name, phone, email);
        this.setId(id);
    }

    public Customer(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(phone, customer.phone) && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, email);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
package ru.yandex.praktikum.db.examples.dao.dao;

import ru.yandex.praktikum.db.examples.dao.entities.Customer;

import java.util.List;

public interface ICustomerDao {
    Customer getById(long id);
    List<Customer> getAll();
    void add(Customer customer);
    void update(Customer customer);
    void delete(Customer customer);
}
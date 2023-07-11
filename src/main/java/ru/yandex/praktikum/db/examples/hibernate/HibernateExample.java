package ru.yandex.praktikum.db.examples.hibernate;

import ru.yandex.praktikum.db.examples.hibernate.dao.CustomerDao;
import ru.yandex.praktikum.db.examples.hibernate.entities.Customer;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HibernateExample {

    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDao();

        prettyPrint("1. All customers (initial state):", customerDao.getAll());

        Customer newCustomer = new Customer("Александра",
                "+7(81153)37060", "roamer@yahoo.ca");
        customerDao.add(newCustomer);

        prettyPrint("2. All customers (+ new):", customerDao.getAll());

        newCustomer.setPhone("+7(3513)885877");
        newCustomer.setEmail("jfinke@live.com");
        customerDao.update(newCustomer);

        prettyPrint("3. All customers (updated):", customerDao.getAll());

        customerDao.delete(newCustomer);

        prettyPrint("4. All customers (removed):", customerDao.getAll());
    }

    public static void prettyPrint(String msg, List<Customer> customers) {
        System.out.println("\n" + msg);
        for (Customer customer : customers) {
            System.out.println("\t" + customer);
        }
    }

}
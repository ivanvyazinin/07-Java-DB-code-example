package ru.yandex.praktikum.db.examples.hibernate.dao;

import ru.yandex.praktikum.db.examples.hibernate.core.EntityManagerFactoryHolder;
import ru.yandex.praktikum.db.examples.hibernate.entities.Customer;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerDao implements ICustomerDao {

    EntityManagerFactoryHolder entityManagerFactoryHolder = new EntityManagerFactoryHolder();

    @Override
    public Customer getById(long id) {
        EntityManager entityManager = entityManagerFactoryHolder.getEntityManagerFactory().createEntityManager();
        return entityManager.createQuery("SELECT c FROM Customer c WHERE c.id = :id", Customer.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Customer> getAll() {
        EntityManager entityManager = entityManagerFactoryHolder.getEntityManagerFactory().createEntityManager();
        return entityManager.createQuery("FROM Customer", Customer.class).getResultList();
    }

    @Override
    public void add(Customer customer) {
        EntityManager entityManager = entityManagerFactoryHolder.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error during adding customer '" + customer + "': " + e.getMessage());
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void update(Customer customer) {
        EntityManager entityManager = entityManagerFactoryHolder.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(customer);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error during updating customer '" + customer + "': " + e.getMessage());
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(Customer customer) {
        EntityManager entityManager = entityManagerFactoryHolder.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Customer.class, customer.getId()));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error during deleting customer '" + customer + "': " + e.getMessage());
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            entityManager.close();
        }
    }
}
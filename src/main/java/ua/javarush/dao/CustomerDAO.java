package ua.javarush.dao;

import org.hibernate.SessionFactory;
import ua.javarush.entity.Customer;

public class CustomerDAO extends AbstractDAO<Customer, Short> {

    public CustomerDAO(SessionFactory sessionFactory) {
        super(Customer.class, sessionFactory);
    }
}

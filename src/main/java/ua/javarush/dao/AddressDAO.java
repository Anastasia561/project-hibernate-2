package ua.javarush.dao;

import org.hibernate.SessionFactory;
import ua.javarush.entities.Address;

public class AddressDAO extends AbstractDAO<Address> {

    public AddressDAO(SessionFactory sessionFactory) {
        super(Address.class, sessionFactory);
    }
}

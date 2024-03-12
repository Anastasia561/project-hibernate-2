package ua.javarush.dao;

import org.hibernate.SessionFactory;
import ua.javarush.entity.Address;

public class AddressDAO extends AbstractDAO<Address, Short> {

    public AddressDAO(SessionFactory sessionFactory) {
        super(Address.class, sessionFactory);
    }
}

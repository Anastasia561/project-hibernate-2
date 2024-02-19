package ua.javarush.dao;

import org.hibernate.SessionFactory;
import ua.javarush.entities.Store;

public class StoreDAO extends AbstractDAO<Store> {

    public StoreDAO(SessionFactory sessionFactory) {
        super(Store.class, sessionFactory);
    }
}

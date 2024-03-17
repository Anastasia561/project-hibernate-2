package ua.javarush.dao;

import org.hibernate.SessionFactory;
import ua.javarush.entity.Store;

public class StoreDAO extends AbstractDAO<Store, Byte> {

    public StoreDAO(SessionFactory sessionFactory) {
        super(Store.class, sessionFactory);
    }
}

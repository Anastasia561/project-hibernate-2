package ua.javarush.dao;

import org.hibernate.SessionFactory;
import ua.javarush.entity.Country;

public class CountryDAO extends AbstractDAO<Country> {

    public CountryDAO(SessionFactory sessionFactory) {
        super(Country.class, sessionFactory);
    }
}

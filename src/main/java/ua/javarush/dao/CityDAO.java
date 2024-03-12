package ua.javarush.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.javarush.entity.City;

public class CityDAO extends AbstractDAO<City, Short> {

    public CityDAO(SessionFactory sessionFactory) {
        super(City.class, sessionFactory);
    }

    public City getByName(String name) {
        String hql = "from City c where c.name = :name";
        Query<City> query = getCurrentSession().createQuery(hql, City.class);
        query.setParameter("name", name);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}

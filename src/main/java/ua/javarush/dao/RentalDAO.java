package ua.javarush.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.javarush.entities.Rental;

public class RentalDAO extends AbstractDAO<Rental> {

    public RentalDAO(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }

    public Rental getAnyUnreturnedItem(){
        String hql = "from Rental r where r.returnDate is null";
        Query<Rental> query = getCurrentSession().createQuery(hql, Rental.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}

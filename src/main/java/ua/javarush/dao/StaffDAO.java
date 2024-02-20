package ua.javarush.dao;

import org.hibernate.SessionFactory;
import ua.javarush.entity.Staff;

public class StaffDAO extends AbstractDAO<Staff> {

    public StaffDAO(SessionFactory sessionFactory) {
        super(Staff.class, sessionFactory);
    }
}

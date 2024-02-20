package ua.javarush.dao;

import org.hibernate.SessionFactory;
import ua.javarush.entity.Payment;

public class PaymentDAO extends AbstractDAO<Payment> {

    public PaymentDAO(SessionFactory sessionFactory) {
        super(Payment.class, sessionFactory);
    }
}

package ua.javarush;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.javarush.entities.Actor;
import ua.javarush.entities.Address;
import ua.javarush.entities.Category;
import ua.javarush.entities.City;
import ua.javarush.entities.Country;
import ua.javarush.entities.Customer;
import ua.javarush.entities.Film;
import ua.javarush.entities.FilmText;
import ua.javarush.entities.Inventory;
import ua.javarush.entities.Language;
import ua.javarush.entities.Payment;
import ua.javarush.entities.Rental;
import ua.javarush.entities.Staff;
import ua.javarush.entities.Store;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Film.class)
                .addAnnotatedClass(FilmText.class)
                .addAnnotatedClass(Inventory.class)
                .addAnnotatedClass(Language.class)
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(Rental.class)
                .addAnnotatedClass(Staff.class)
                .addAnnotatedClass(Store.class)
                .buildSessionFactory();

    }
}

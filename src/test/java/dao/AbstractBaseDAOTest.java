package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ua.javarush.dao.ActorDAO;
import ua.javarush.dao.AddressDAO;
import ua.javarush.dao.CategoryDAO;
import ua.javarush.dao.CityDAO;
import ua.javarush.dao.CountryDAO;
import ua.javarush.dao.CustomerDAO;
import ua.javarush.dao.FilmDAO;
import ua.javarush.dao.FilmTextDAO;
import ua.javarush.dao.InventoryDAO;
import ua.javarush.dao.LanguageDAO;
import ua.javarush.dao.PaymentDAO;
import ua.javarush.dao.RentalDAO;
import ua.javarush.dao.StaffDAO;
import ua.javarush.dao.StoreDAO;
import ua.javarush.entity.Actor;
import ua.javarush.entity.Address;
import ua.javarush.entity.Category;
import ua.javarush.entity.City;
import ua.javarush.entity.Country;
import ua.javarush.entity.Customer;
import ua.javarush.entity.Film;
import ua.javarush.entity.FilmText;
import ua.javarush.entity.Inventory;
import ua.javarush.entity.Language;
import ua.javarush.entity.Payment;
import ua.javarush.entity.Rental;
import ua.javarush.entity.Staff;
import ua.javarush.entity.Store;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class AbstractBaseDAOTest {
    protected SessionFactory sessionFactory;
    protected Session session;
    protected ActorDAO actorDAO;
    protected AddressDAO addressDAO;
    protected CategoryDAO categoryDAO;
    protected CityDAO cityDAO;
    protected CountryDAO countryDAO;
    protected CustomerDAO customerDAO;
    protected FilmDAO filmDAO;
    protected FilmTextDAO filmTextDAO;
    protected InventoryDAO inventoryDAO;
    protected LanguageDAO languageDAO;
    protected PaymentDAO paymentDAO;
    protected RentalDAO rentalDAO;
    protected StaffDAO staffDAO;
    protected StoreDAO storeDAO;

    @BeforeEach
    void setup() {
        sessionFactory = new Configuration()
                .configure("h2.cfg.xml")
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

        actorDAO = new ActorDAO(sessionFactory);
        addressDAO = new AddressDAO(sessionFactory);
        categoryDAO = new CategoryDAO(sessionFactory);
        cityDAO = new CityDAO(sessionFactory);
        countryDAO = new CountryDAO(sessionFactory);
        customerDAO = new CustomerDAO(sessionFactory);
        filmDAO = new FilmDAO(sessionFactory);
        filmTextDAO = new FilmTextDAO(sessionFactory);
        inventoryDAO = new InventoryDAO(sessionFactory);
        languageDAO = new LanguageDAO(sessionFactory);
        paymentDAO = new PaymentDAO(sessionFactory);
        rentalDAO = new RentalDAO(sessionFactory);
        staffDAO = new StaffDAO(sessionFactory);
        storeDAO = new StoreDAO(sessionFactory);

        runSqlScriptFile("C:\\Users\\User\\JavaProjects\\project-hibernate-2\\src\\test\\resources\\schema.sql");
        runSqlScriptFile("C:\\Users\\User\\JavaProjects\\project-hibernate-2\\src\\test\\resources\\data.sql");
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
    }

    @AfterEach
    void tear() {
        session.getTransaction().commit();
        sessionFactory.close();
    }

    void runSqlScriptFile(String path) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            String sqlScript = new String(Files.readAllBytes(Paths.get(path)));
            Query query = session.createNativeQuery(sqlScript);
            query.executeUpdate();

            transaction.commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

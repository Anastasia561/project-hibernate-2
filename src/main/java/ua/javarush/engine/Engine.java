package ua.javarush.engine;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
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

import java.time.LocalDateTime;

public class Engine {
    private final SessionFactory sessionFactory;
    private final ActorDAO actorDAO;
    private final AddressDAO addressDAO;
    private final CategoryDAO categoryDAO;
    private final CityDAO cityDAO;
    private final CountryDAO countryDAO;
    private final CustomerDAO customerDAO;
    private final FilmDAO filmDAO;
    private final FilmTextDAO filmTextDAO;
    private final InventoryDAO inventoryDAO;
    private final LanguageDAO languageDAO;
    private final PaymentDAO paymentDAO;
    private final RentalDAO rentalDAO;
    private final StaffDAO staffDAO;
    private final StoreDAO storeDAO;

    public Engine() {
        sessionFactory = new Configuration()
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
    }

    public Customer createCustomer(String firstName, String lastName, String email, String addressName, String district, String cityName, String phone) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();

            Store store = storeDAO.getItems(0, 1).get(0);
            City city = cityDAO.getByName(cityName);

            Address address = new Address();
            address.setAddress(addressName);
            address.setDistrict(district);
            address.setCity(city);
            address.setPhone(phone);
            addressDAO.save(address);

            Customer customer = new Customer();
            customer.setStore(store);
            customer.setFirstname(firstName);
            customer.setLastName(lastName);
            customer.setEmail(email);
            customer.setAddress(address);
            customer.setIsActive(true);
            customerDAO.save(customer);

            transaction.commit();
            return customer;
        }

    }

    public void returnAnyInventoryToStore() {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();

            Rental rental = rentalDAO.getAnyUnreturnedItem();
            rental.setReturnDate(LocalDateTime.now());
            rentalDAO.save(rental);

            transaction.commit();
        }
    }
}

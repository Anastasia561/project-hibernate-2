package ua.javarush.service;

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
import ua.javarush.enumeration.Feature;
import ua.javarush.enumeration.Rating;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

public class Service {
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

    public Service() {
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

    public void rentAnyAvailableFilmAndMakePayment(Customer customer) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();

            Film film = filmDAO.getAnyAvailableFilmForRent();
            Store store = storeDAO.getItems(0, 1).get(0);

            Inventory inventory = new Inventory();
            inventory.setFilm(film);
            inventory.setStore(store);
            inventoryDAO.save(inventory);

            Rental rental = new Rental();
            rental.setRentalDate(LocalDateTime.now());
            rental.setInventory(inventory);
            rental.setCustomer(customer);
            rental.setStaff(store.getManager());
            rentalDAO.save(rental);

            Payment payment = new Payment();
            payment.setStaff(store.getManager());
            payment.setCustomer(customer);
            payment.setPaymentDate(LocalDateTime.now());
            payment.setRental(rental);
            payment.setAmount(BigDecimal.valueOf(Math.random() * 20 + 100));
            paymentDAO.save(payment);

            transaction.commit();
        }
    }

    public Film createFilm(String title, String languageName, String originalLanguageName,
                           String[] categoryNames, int actorsCount, int rentalDuration,
                           double rentalRate, double replacementCost) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();

            Language language = languageDAO.getLanguageByName(languageName);
            Language originalLanguage = languageDAO.getLanguageByName(originalLanguageName);
            Set<Category> categories = categoryDAO.getCategorySetByNames(categoryNames);
            Set<Actor> actors = new HashSet<>(actorDAO.getItems(0, actorsCount));

            Film film = new Film();
            film.setTitle(title);
            film.setYear(Year.now());
            film.setLanguage(language);
            film.setOriginalLanguage(originalLanguage);
            film.setRentalDuration((byte) rentalDuration);
            film.setRentalRate(BigDecimal.valueOf(rentalRate));
            film.setReplacementCost(BigDecimal.valueOf(replacementCost));
            film.setRating(Rating.G);
            film.setSpecialFeatures(Set.of(Feature.COMMENTARIES, Feature.TRAILERS));
            film.setActors(actors);
            film.setCategories(categories);
            filmDAO.save(film);

            transaction.commit();
            return film;
        }
    }

    public Customer getCustomerById(short id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Customer customer = customerDAO.getById(id);
            transaction.commit();
            return customer;
        }
    }
}

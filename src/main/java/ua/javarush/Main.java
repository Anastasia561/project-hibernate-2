package ua.javarush;

import ua.javarush.engine.Engine;
import ua.javarush.entity.Customer;
import ua.javarush.entity.Film;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();

        Customer customer = engine.createCustomer(
                "John", "Brown",
                "custom@gmail.com", "Dale street, 23", "Nile",
                "Adana", "123-456-789");

        engine.returnAnyInventoryToStore();

        engine.rentAnyAvailableFilmAndMakePayment(customer);

        Film film = engine.createFilm("TEST", "English", "English",
                new String[]{"Comedy", "Animation"}, 6, 3, 2.4D,
                34.5D);
    }
}

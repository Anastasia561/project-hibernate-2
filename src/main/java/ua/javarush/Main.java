package ua.javarush;

import ua.javarush.controller.Controller;
import ua.javarush.service.Service;
import ua.javarush.view.ConsoleViewProvider;

public class Main {
    public static void main(String[] args) {
//        Service engine = new Service();
//
//        Customer customer = engine.createCustomer(
//                "John", "Brown",
//                "custom@gmail.com", "Dale street, 23", "Nile",
//                "Adana", "123-456-789");
//
//        engine.returnAnyInventoryToStore();
//
//        engine.rentAnyAvailableFilmAndMakePayment(customer);
//
//        Film film = engine.createFilm("TEST", "English", "English",
//                new String[]{"Comedy", "Animation"}, 6, 3, 2.4D,
//                34.5D);
        Controller controller = new Controller(new Service(), new ConsoleViewProvider());
        controller.process();
    }
}

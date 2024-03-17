package ua.javarush.controller;

import ua.javarush.entity.Customer;
import ua.javarush.service.Service;
import ua.javarush.view.ConsoleViewProvider;

public class Controller {
    private final Service service;
    private final ConsoleViewProvider consoleViewProvider;

    public Controller(Service service, ConsoleViewProvider consoleViewProvider) {
        this.service = service;
        this.consoleViewProvider = consoleViewProvider;
    }

    public void process() {
        consoleViewProvider.printMessage("Choose option:");
        consoleViewProvider.printMessage("[1]-to create new customer");
        consoleViewProvider.printMessage("[2]-to create new film");
        consoleViewProvider.printMessage("[3]-to return any inventory to store");
        consoleViewProvider.printMessage("[4]-to rent film and make payment");
        consoleViewProvider.printMessage("[5]-to end");
        String answer = consoleViewProvider.getMessage();
        switch (answer) {
            case "1":
                createNewCustomer();
                break;
            case "2":
                createNewFilm();
                break;
            case "3":
                returnAnyInventoryToStore();
                break;
            case "4":
                rentFilmAndMakePayment();
                break;
            default:
                consoleViewProvider.printMessage("incorrect option");
        }
    }

    private void createNewCustomer() {
        consoleViewProvider.printMessage("Creating new customer");

        consoleViewProvider.printMessage("Enter first name: ");
        String firstName = consoleViewProvider.getMessage();
        consoleViewProvider.printMessage("Enter last name: ");
        String lastName = consoleViewProvider.getMessage();
        consoleViewProvider.printMessage("Enter email: ");
        String email = consoleViewProvider.getMessage();
        consoleViewProvider.printMessage("Enter address: ");
        String address = consoleViewProvider.getMessage();
        consoleViewProvider.printMessage("Enter district: ");
        String district = consoleViewProvider.getMessage();
        consoleViewProvider.printMessage("Enter city {example : Aden}: ");
        String city = consoleViewProvider.getMessage();
        consoleViewProvider.printMessage("Enter phone: ");
        String phone = consoleViewProvider.getMessage();

        service.createCustomer(firstName, lastName, email, address, district, city, phone);
        consoleViewProvider.printMessage("Customer created");
    }

    private void createNewFilm() {
        consoleViewProvider.printMessage("Creating new film");

        consoleViewProvider.printMessage("Enter title: ");
        String title = consoleViewProvider.getMessage();
        consoleViewProvider.printMessage("Enter language {example : English}: ");
        String language = consoleViewProvider.getMessage();
        consoleViewProvider.printMessage("Enter original language {example : English}: ");
        String originalLanguage = consoleViewProvider.getMessage();
        consoleViewProvider.printMessage("Enter set od nominations (separated with coma): ");
        String[] categories = consoleViewProvider.getMessage().split(",");
        consoleViewProvider.printMessage("Enter number of actors: ");
        int actorsCount = Integer.parseInt(consoleViewProvider.getMessage());
        consoleViewProvider.printMessage("Enter rental duration (number of days): ");
        int rentalDuration = Integer.parseInt(consoleViewProvider.getMessage());
        consoleViewProvider.printMessage("Enter rental rate: ");
        double rentalRate = Double.parseDouble(consoleViewProvider.getMessage());
        consoleViewProvider.printMessage("Enter replacement cost: ");
        double replacementCost = Double.parseDouble(consoleViewProvider.getMessage());

        service.createFilm(title, language, originalLanguage, categories,
                actorsCount, rentalDuration, rentalRate, replacementCost);
        consoleViewProvider.printMessage("Film created");
    }

    private void returnAnyInventoryToStore() {
        consoleViewProvider.printMessage("Returning any inventory to store");
        service.returnAnyInventoryToStore();
        consoleViewProvider.printMessage("Inventory returned");
    }

    private void rentFilmAndMakePayment() {
        consoleViewProvider.printMessage("Renting film and making payment");
        consoleViewProvider.printMessage("Enter customer id: ");
        short id = Short.parseShort(consoleViewProvider.getMessage());
        Customer customer = service.getCustomerById(id);
        service.rentAnyAvailableFilmAndMakePayment(customer);
        consoleViewProvider.printMessage("Film rented and payment made");
    }
}

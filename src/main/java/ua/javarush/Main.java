package ua.javarush;

import ua.javarush.controller.Controller;
import ua.javarush.service.Service;
import ua.javarush.view.ConsoleViewProvider;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        ConsoleViewProvider consoleViewProvider = new ConsoleViewProvider();
        Controller controller = new Controller(service, consoleViewProvider);
        controller.process();
    }
}

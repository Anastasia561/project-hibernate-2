package ua.javarush;

import ua.javarush.engine.Engine;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();

//        Customer customer = engine.createCustomer(
//                "John", "Brown",
//                "custom@gmail.com", "Dale street, 23", "Nile",
//                "Adana", "123-456-789");

        engine.returnAnyInventoryToStore();

    }
}

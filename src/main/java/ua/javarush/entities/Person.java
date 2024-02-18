package ua.javarush.entities;

import java.sql.Timestamp;

public class Person {
    private long id;
    private String firstName;
    private String lastName;
    private Address address;
    private String email;
    private Store store;
    private boolean active;
    private Timestamp lastUpdate;
}

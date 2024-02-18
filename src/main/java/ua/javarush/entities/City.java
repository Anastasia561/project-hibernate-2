package ua.javarush.entities;

import java.sql.Timestamp;

public class City {
    private long id;
    private String name;
    private Country country;
    private Timestamp lastUpdate;
}

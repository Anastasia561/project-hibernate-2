package ua.javarush.entities;

import java.sql.Timestamp;

public class Address {
    private long id;
    private String address;
    private String address2;
    private String district;
    private City city;
    private String postalCode;
    private String phone;
    private Timestamp lastUpdate;
}

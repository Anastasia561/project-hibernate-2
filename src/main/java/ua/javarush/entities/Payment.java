package ua.javarush.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Payment {
    private long id;
    private Customer customer;
    private Staff staff;
    private Rental rental;
    private double amount;
    private LocalDateTime paymentDate;
    private Timestamp lastUpdate;

}

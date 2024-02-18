package ua.javarush.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Rental {
    private long id;
    private LocalDateTime rentalDate;
    private Inventory inventory;
    private Customer customer;
    private LocalDateTime returnDate;
    private Staff staff;
    private Timestamp lastUpdate;
}

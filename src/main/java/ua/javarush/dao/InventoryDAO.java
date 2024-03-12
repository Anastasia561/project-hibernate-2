package ua.javarush.dao;

import org.hibernate.SessionFactory;
import ua.javarush.entity.Inventory;

public class InventoryDAO extends AbstractDAO<Inventory, Integer> {

    public InventoryDAO(SessionFactory sessionFactory) {
        super(Inventory.class, sessionFactory);
    }
}

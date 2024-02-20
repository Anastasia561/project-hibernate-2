package ua.javarush.dao;

import org.hibernate.SessionFactory;
import ua.javarush.entity.Category;

public class CategoryDAO extends AbstractDAO<Category> {

    public CategoryDAO(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }
}

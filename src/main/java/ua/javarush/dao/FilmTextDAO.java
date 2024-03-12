package ua.javarush.dao;

import org.hibernate.SessionFactory;
import ua.javarush.entity.FilmText;

public class FilmTextDAO extends AbstractDAO<FilmText, Short> {

    public FilmTextDAO(SessionFactory sessionFactory) {
        super(FilmText.class, sessionFactory);
    }
}

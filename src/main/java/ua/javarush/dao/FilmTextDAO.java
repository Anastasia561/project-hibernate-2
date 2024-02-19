package ua.javarush.dao;

import org.hibernate.SessionFactory;
import ua.javarush.entities.FilmText;

public class FilmTextDAO extends AbstractDAO<FilmText> {

    public FilmTextDAO(SessionFactory sessionFactory) {
        super(FilmText.class, sessionFactory);
    }
}

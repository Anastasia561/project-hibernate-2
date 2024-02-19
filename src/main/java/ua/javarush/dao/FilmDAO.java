package ua.javarush.dao;

import org.hibernate.SessionFactory;
import ua.javarush.entities.Film;

public class FilmDAO extends AbstractDAO<Film> {

    public FilmDAO(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
    }
}

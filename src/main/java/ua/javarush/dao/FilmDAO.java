package ua.javarush.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import ua.javarush.entity.Film;

public class FilmDAO extends AbstractDAO<Film, Short> {

    public FilmDAO(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
    }

    public Film getAnyAvailableFilmForRent() {
        String sql = "select * from movie.film where film_id not in (select distinct film_id from movie.inventory) limit 1";
        NativeQuery<Film> nativeQuery = getCurrentSession().createNativeQuery(sql, Film.class);
        return nativeQuery.getSingleResult();
    }
}

package ua.javarush.dao;

import org.hibernate.SessionFactory;
import ua.javarush.entity.Language;

public class LanguageDAO extends AbstractDAO<Language> {

    public LanguageDAO(SessionFactory sessionFactory) {
        super(Language.class, sessionFactory);
    }
}

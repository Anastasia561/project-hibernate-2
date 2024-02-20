package ua.javarush.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.javarush.entity.Language;

public class LanguageDAO extends AbstractDAO<Language> {

    public LanguageDAO(SessionFactory sessionFactory) {
        super(Language.class, sessionFactory);
    }

    public Language getLanguageByName(String name) {
        String hql = "from Language l where l.name = :name";
        Query<Language> query = getCurrentSession().createQuery(hql, Language.class);
        query.setParameter("name", name);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}

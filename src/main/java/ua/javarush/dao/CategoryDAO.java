package ua.javarush.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import ua.javarush.entity.Category;

import java.util.HashSet;
import java.util.Set;

public class CategoryDAO extends AbstractDAO<Category, Byte> {

    public CategoryDAO(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }

    public Set<Category> getCategorySetByNames(String[] names) {
        String hql = "from Category c where c.name in (:names)";
        String sql = "select * from movie.category where name in (:names)";
        NativeQuery<Category> query = getCurrentSession().createNativeQuery(sql, Category.class);
        query.setParameterList("names", names);
        return new HashSet<>(query.getResultList());
    }
}

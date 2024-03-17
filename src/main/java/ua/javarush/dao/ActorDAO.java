package ua.javarush.dao;

import org.hibernate.SessionFactory;
import ua.javarush.entity.Actor;

public class ActorDAO extends AbstractDAO<Actor, Short> {

    public ActorDAO(SessionFactory sessionFactory) {
        super(Actor.class, sessionFactory);
    }
}

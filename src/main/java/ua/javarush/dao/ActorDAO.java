package ua.javarush.dao;

import org.hibernate.SessionFactory;
import ua.javarush.entities.Actor;

public class ActorDAO extends AbstractDAO<Actor> {

    public ActorDAO(SessionFactory sessionFactory) {
        super(Actor.class, sessionFactory);
    }
}

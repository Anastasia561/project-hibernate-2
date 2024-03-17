package dao;

import org.junit.jupiter.api.Test;
import ua.javarush.entity.Actor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorTest extends AbstractBaseDAOTest {
    @Test
    void getByIdTestShouldReturnActor() {
        String actual = actorDAO.getById((short) 1).getFirstName();
        assertEquals("PENELOPE", actual);
    }

    @Test
    void getItemsTestShouldReturnThreeActors() {
        int actual = actorDAO.getItems(0, 3).size();
        assertEquals(3, actual);
    }

    @Test
    void findAllTestShouldReturnFiveActors() {
        int actual = actorDAO.findAll().size();
        assertEquals(5, actual);
    }

    @Test
    void updateTestShouldChangeActorFirstName() {
        Actor actor = actorDAO.getById((short) 1);
        actor.setFirstName("test");
        actorDAO.update(actor);
        assertEquals("test", actorDAO.getById((short) 1).getFirstName());
    }
}

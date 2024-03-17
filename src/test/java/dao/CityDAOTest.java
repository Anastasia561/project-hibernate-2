package dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CityDAOTest extends AbstractBaseDAOTest {
    @Test
    void getByNameShouldReturnAdana() {
        String actual = cityDAO.getByName("Adana").getName().trim();
        assertEquals("Adana", actual);
    }
}

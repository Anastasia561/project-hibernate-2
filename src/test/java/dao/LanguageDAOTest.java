package dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanguageDAOTest extends AbstractBaseDAOTest {
    @Test
    void getLanguageByNameTestShouldReturnEnglish() {
        String actual = languageDAO.getLanguageByName("Italian").getName().trim();
        assertEquals("Italian", actual);
    }
}

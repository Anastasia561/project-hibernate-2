package dao;

import org.junit.jupiter.api.Test;
import ua.javarush.entity.Language;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanguageDAOTest extends AbstractBaseDAOTest {
    @Test
    void getLanguageByNameTestShouldReturnEnglish() {
        String actual = languageDAO.getLanguageByName("Italian").getName().trim();
        assertEquals("Italian", actual);
    }

    @Test
    void deleteTestShouldReturnFourLanguages() {
        Language language = languageDAO.getById((byte) 1);
        languageDAO.delete(language);
        assertEquals(4, languageDAO.findAll().size());
    }

    @Test
    void deleteByIdTestShouldReturnFourLanguages() {
        languageDAO.deleteById((byte) 1);
        assertEquals(4, languageDAO.findAll().size());
    }
}

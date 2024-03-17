package enumeration;

import org.junit.jupiter.api.Test;
import ua.javarush.enumeration.Rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RatingTest {
    @Test
    void getRatingByValueTestShouldReturnNullForEmptyString() {
        assertNull(Rating.getRatingByValue(""));
    }

    @Test
    void getRatingByValueTestShouldReturnNullForNullString() {
        assertNull(Rating.getRatingByValue(null));
    }

    @Test
    void getRatingByValueTestShouldReturnNullForInvalidString() {
        assertNull(Rating.getRatingByValue("PPP"));
    }

    @Test
    void getRatingByValueTestShouldReturnRatingForNotEmptyString() {
        Rating actual = Rating.getRatingByValue("R");
        assertEquals(Rating.R, actual);
    }
}

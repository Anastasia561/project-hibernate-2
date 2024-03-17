package converter;

import org.junit.jupiter.api.Test;
import ua.javarush.converter.RatingConverter;
import ua.javarush.enumeration.Rating;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RatingConverterTest {
    private RatingConverter converter = new RatingConverter();

    @Test
    void convertToDatabaseColumnShouldReturnString() {
        String actual = converter.convertToDatabaseColumn(Rating.PG);
        assertEquals("PG", actual);
    }

    @Test
    void convertToEntityAttributeShouldReturnRating() {
        Rating actual = converter.convertToEntityAttribute("PG");
        assertEquals(Rating.PG, actual);
    }
}

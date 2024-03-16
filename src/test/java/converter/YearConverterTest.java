package converter;

import org.junit.jupiter.api.Test;
import ua.javarush.converter.YearConverter;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class YearConverterTest {
    YearConverter converter = new YearConverter();

    @Test
    void convertToDatabaseColumnShouldReturnShortWhenYearIsNotNull() {
        Short actual = converter.convertToDatabaseColumn(Year.of(2000));
        assertEquals((short) 2000, actual);
    }

    @Test
    void convertToDatabaseColumnShouldReturnNullWhenYearIsNull() {
        assertNull(converter.convertToDatabaseColumn(null));
    }

    @Test
    void convertToEntityAttributeShouldReturnYearWhenValueIsNotNull() {
        Year actual = converter.convertToEntityAttribute((short) 2000);
        assertEquals(Year.of(2000), actual);
    }

    @Test
    void convertToEntityAttributeShouldReturnNullWhenValueIsNull() {
        assertNull(converter.convertToEntityAttribute(null));
    }
}

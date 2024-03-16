package enumeration;

import org.junit.jupiter.api.Test;
import ua.javarush.enumeration.Feature;
import ua.javarush.enumeration.Rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FeatureTest {
    @Test
    void getFeatureByValueShouldReturnNullForEmptyString() {
        assertNull(Feature.getFeatureByValue(""));
    }

    @Test
    void getFeatureByValueShouldReturnNullForNullString() {
        assertNull(Feature.getFeatureByValue(null));
    }

    @Test
    void getFeatureByValueTestShouldReturnNullForInvalidString() {
        assertNull(Feature.getFeatureByValue("PPP"));
    }

    @Test
    void getFeatureByValueTestShouldReturnFeatureForNotEmptyString() {
        Feature actual = Feature.getFeatureByValue("Trailers");
        assertEquals(Feature.TRAILERS, actual);
    }
}

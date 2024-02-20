package ua.javarush.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ua.javarush.enumeration.Rating;

@Converter(autoApply = true)
public class RatingConverter implements AttributeConverter<Rating, String> {
    @Override
    public String convertToDatabaseColumn(Rating rating) {
        return rating.getValue();
    }

    @Override
    public Rating convertToEntityAttribute(String s) {
        return Rating.getRatingByValue(s);
    }
}

package ua.javarush.enumeration;

import static java.util.Objects.isNull;

public enum Rating {
    G("G"),
    PG("PG"),
    PG13("PG-13"),
    R("R"),
    NC17("NC-17");

    private final String value;

    Rating(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Rating getRatingByValue(String value) {
        if (isNull(value) || value.isEmpty()) {
            return null;
        }
        Rating[] ratings = Rating.values();
        for (Rating rating : ratings) {
            if (rating.value.equals(value)) {
                return rating;
            }
        }
        return null;
    }
}

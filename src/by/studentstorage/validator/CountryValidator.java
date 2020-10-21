package by.studentstorage.validator;

public class CountryValidator {
    public static boolean ValidCountryName(String country) {
        return country.length() > 0;
    }
}

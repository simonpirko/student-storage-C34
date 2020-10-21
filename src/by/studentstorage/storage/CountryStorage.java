package by.studentstorage.storage;

import by.studentstorage.domain.Country;

import java.util.List;

public interface CountryStorage {
    boolean save(Country country);

    Country remove(long userId);

    String updateCountry(Country country, String countryName);

    List<Country> getAll();

    List<Country> getAllByCountryName(String name);

    boolean contains(Country country);


}

package by.studentstorage.storage;

import by.studentstorage.domain.Country;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCountryStorage implements CountryStorage {
    List<Country> countries = new ArrayList<>();

    @Override
    public boolean save(Country country) {
        return countries.add(country);
    }

    @Override
    public Country remove(long userId) {
        Country country = null;
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getUserId() == userId) {
                country = countries.get(i);
                countries.remove(i);
            }
        }
        return country;
    }

    @Override
    public String updateCountry(Country country, String countryName) {
        country.setCountryName(countryName);
        return countryName;
    }

    @Override
    public List<Country> getAll() {
        return countries;
    }

    @Override
    public List<Country> getAllByCountryName(String name) {
        List<Country> countryList = new ArrayList<>();
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getCountryName().equals(name)) {
                countryList.add(countries.get(i));
            }
        }
        return countryList;
    }

    @Override
    public boolean contains(Country country) {
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).equals(country)) {
                return true;
            }
        }
        return false;
    }
}

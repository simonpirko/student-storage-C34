package by.studentstorage.service;

import by.studentstorage.domain.Country;
import by.studentstorage.storage.InMemoryCountryStorage;

import java.util.ArrayList;
import java.util.List;

public class CountryService {
    private InMemoryCountryStorage inMemoryCountryStorage = new InMemoryCountryStorage();

    public boolean saveCountry(Country country) {
        return inMemoryCountryStorage.save(country);
    }

    public Country remove(long userId) {
        Country remCountry = inMemoryCountryStorage.remove(userId);
        if (remCountry == null) {
            throw new CountryNotFoundException();
        }
        return remCountry;
    }

    public String updateCountry(Country country, String countryName) {
        if (inMemoryCountryStorage.contains(country)) {
            return inMemoryCountryStorage.updateCountry(country, countryName);
        }
        return countryName;
    }

    public List<Country> getAll() {
        if (inMemoryCountryStorage.getAll().size() != 0) {
            return inMemoryCountryStorage.getAll();
        }
        throw new CountryNotFoundException();
    }

    public List<Country> getByCountryName(String name) {
        List<Country> allCountry = getAll();
        if (allCountry.size() == 0) {
            throw new CountryNotFoundException();
        }
        List<Country> byName = new ArrayList<>();
        for (int i = 0; i < allCountry.size(); i++) {
            if (allCountry.get(i).getCountryName().equals(name)) {
                byName.add(allCountry.get(i));
            }
        }
        return byName;
    }
}

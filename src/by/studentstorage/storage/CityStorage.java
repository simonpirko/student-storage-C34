package by.studentstorage.storage;

import by.studentstorage.domain.City;
import java.util.List;

public interface CityStorage {

    boolean save(City city);
    City remove(long userID);
    String updateCity(City city, String cityName);
    List<City> getAll();
    List<City> getAllByCityName(String name);
    boolean contains(City city);
}

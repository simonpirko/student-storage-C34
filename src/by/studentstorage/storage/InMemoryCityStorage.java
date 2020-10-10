package by.studentstorage.storage;

import by.studentstorage.domain.City;
import java.util.ArrayList;
import java.util.List;

public class InMemoryCityStorage implements CityStorage {
    private List<City> cities = new ArrayList<>();
    @Override
    public boolean save(City city) {
        return cities.add(city);
    }

    @Override
    public City remove(long userID) {
        City city = null;
        for (int i = 0; i <cities.size() ; i++) {
            if (cities.get(i).getUserID() == userID){
                city = cities.get(i);
                cities.remove(i);
            }
        }
        return city;
    }

    @Override
    public String updateCity(City city, String cityName) {
         city.setCityName(cityName);
         return cityName;
    }

    @Override
    public List<City> getAll() {
        return cities;
    }

    @Override
    public List<City> getAllByCityName(String name) {
        List<City> cityList = new ArrayList<>();
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getCityName().equals(name)){
                cityList.add(cities.get(i));
            }
        }
        return cityList;
    }

    @Override
    public boolean contains(City city) {
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).equals(city)){
                return true;
            }
        }
        return false;
    }

}

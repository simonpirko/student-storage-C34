package by.studentstorage.service;

import by.studentstorage.domain.City;
import by.studentstorage.storage.InMemoryCityStorage;

import java.util.ArrayList;
import java.util.List;

public class CityService {
    private InMemoryCityStorage inMemoryCityStorage = new InMemoryCityStorage();

    public boolean saveCity(City city){
        return inMemoryCityStorage.save(city);
    }

    public City remove(long userID){
        City removedCity = inMemoryCityStorage.remove(userID);
        if (removedCity == null){
            throw new CityNotFoundException();
        }
        return removedCity;
    }

    public String updateCity(City city, String cityName){
        if (inMemoryCityStorage.contains(city)){
            return inMemoryCityStorage.updateCity(city, cityName);
        }
        return cityName;
    }

    public List<City> getAll(){
        if (inMemoryCityStorage.getAll().size() != 0){
            return inMemoryCityStorage.getAll();
        }
        throw new CityNotFoundException();
    }

    public List<City> getByCityName(String name){
        List<City> all = getAll();
        if (all.size() == 0){
            throw new CityNotFoundException();
        }
        List<City> byName = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getCityName().equals(name)){
                byName.add(all.get(i));
            }
        }
        return byName;

    }
}

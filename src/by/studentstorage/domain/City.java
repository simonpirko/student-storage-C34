package by.studentstorage.domain;

import java.util.Objects;

public class City {
    private String cityName;
    private long userID;

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", userID=" + userID +
                '}';
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public City(String cityName, long userID) {
        this.cityName = cityName;
        this.userID = userID;
    }

    public City() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(cityName, city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName);
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public City(String cityNAme) {
        this.cityName = cityNAme;
    }
}

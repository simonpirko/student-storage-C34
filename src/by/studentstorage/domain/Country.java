package by.studentstorage.domain;

import java.util.Objects;

public class Country {
    private String countryName;
    private long userId;

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return userId == country.userId &&
                Objects.equals(countryName, country.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryName, userId);
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Country(String countryName, long userId) {
        this.countryName = countryName;
        this.userId = userId;
    }

    public Country() {
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Country(String countryName) {
        this.countryName = countryName;
    }
}

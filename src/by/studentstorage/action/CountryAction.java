package by.studentstorage.action;

import by.studentstorage.console.ConsoleApplication;
import by.studentstorage.console.ConsoleReader;
import by.studentstorage.console.ConsoleWriter;
import by.studentstorage.domain.Country;
import by.studentstorage.service.CountryService;
import by.studentstorage.service.UserService;
import by.studentstorage.validator.CountryValidator;

public class CountryAction {
    private CountryService countryService = new CountryService();
    private UserService userService = new UserService();
    private ConsoleWriter consoleWriter = new ConsoleWriter();
    private ConsoleReader consoleReader = new ConsoleReader();

    public boolean addCountry() {
        consoleWriter.writeString("Please enter your country of birth");
        String countryName = consoleReader.readString();
        while (!CountryValidator.ValidCountryName(countryName)) {
            consoleWriter.writeString("Wrong input! Try again");
            countryName = consoleReader.readString();
        }
        return countryService.saveCountry(new Country(countryName, ConsoleApplication.session.getCurrentUser().getId()));
    }

    public String changeCountry() {
        consoleWriter.writeString("Please enter new Country name");
        String newName = consoleReader.readString();
        while (!CountryValidator.ValidCountryName(newName)) {
            consoleWriter.writeString("Wrong input! Try again");
            newName = consoleReader.readString();
        }
        countryService.updateCountry(new Country(newName, ConsoleApplication.session.getCurrentUser().getId()), newName);
        return "You successfully changed country name to" + newName;
    }

    public boolean removeCountry() {
        consoleWriter.writeString("Please enter user ID");
        long id = consoleReader.readLong();
        userService.getUserById(id);
        countryService.remove(id);
        return true;
    }
}

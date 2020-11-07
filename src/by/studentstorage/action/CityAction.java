package by.studentstorage.action;

import by.studentstorage.console.ConsoleApplication;
import by.studentstorage.console.ConsoleReader;
import by.studentstorage.console.ConsoleWriter;
import by.studentstorage.domain.City;
import by.studentstorage.service.CityService;
import by.studentstorage.service.UserService;
import by.studentstorage.validator.CityValidator;

public class CityAction {
    private CityService cityService = new CityService();
    private UserService userService = new UserService();
    private ConsoleWriter consoleWriter = new ConsoleWriter();
    private ConsoleReader consoleReader = new ConsoleReader();

    public boolean addCity() {
        consoleWriter.writeString("Please enter your city of birth");
        String cityName = consoleReader.readString();
        while (!CityValidator.ValidCityName(cityName)) {
            consoleWriter.writeString("Wrong input! Try again");
            cityName = consoleReader.readString();
        }
        return cityService.saveCity(new City(cityName, ConsoleApplication.session.getCurrentUser().getId()));
    }

    public String changeCity(){
        consoleWriter.writeString("Please enter new city name");
        String newName = consoleReader.readString();
        while (!CityValidator.ValidCityName(newName)) {
            consoleWriter.writeString("Wrong input! Try again");
            newName = consoleReader.readString();
        }
        cityService.updateCity(new City(newName,ConsoleApplication.session.getCurrentUser().getId()), newName);
        return "You successfully changed city name to" + newName;
    }

    public boolean removeCity(){
        consoleWriter.writeString("Please enter user ID");
        long id;
        do{
            while(!consoleReader.hasInt()){
                String input=consoleReader.readString();
                consoleWriter.writeString("Error: input only numbers");
            }
            id=consoleReader.readLong();
            if(id<=0){
                consoleWriter.writeString("Error: input numbers >0");
            }
            else {
                break;
            }

        } while(true);

        userService.getUserById(id);
        cityService.remove(id);
        return true;
    }
}

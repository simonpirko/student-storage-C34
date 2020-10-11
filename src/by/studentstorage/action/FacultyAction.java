package by.studentstorage.action;

import by.studentstorage.console.ConsoleApplication;
import by.studentstorage.console.ConsoleReader;
import by.studentstorage.console.ConsoleWriter;
import by.studentstorage.domain.Faculty;
import by.studentstorage.service.FacultyService;
import by.studentstorage.service.UserService;
import by.studentstorage.validator.FacultyValidator;

public class FacultyAction {
    private FacultyService facultyService = new FacultyService();
    private UserService userService = new UserService();
    private ConsoleWriter consoleWriter = new ConsoleWriter();
    private ConsoleReader consoleReader = new ConsoleReader();

    public boolean addFaculty() {
        consoleWriter.writeString("Please enter your faculty");
        String facultyName = consoleReader.readString();
        while (!FacultyValidator.ValidFacultyName(facultyName)) {
            consoleWriter.writeString("Wrong input! Try again");
            facultyName = consoleReader.readString();
        }
        return facultyService.saveFaculty(new Faculty(facultyName, ConsoleApplication.session.getCurrentUser().getId()));
    }

    public String changeFaculty(){
        consoleWriter.writeString("Please enter new faculty");
        String newName = consoleReader.readString();
        while (!FacultyValidator.ValidFacultyName(newName)) {
            consoleWriter.writeString("Wrong input! Try again");
            newName = consoleReader.readString();
        }
        facultyService.updateFaculty(new Faculty(newName,ConsoleApplication.session.getCurrentUser().getId()), newName);
        return "You successfully changed city name to" + newName;
    }

    public boolean removeFaculty(){
        consoleWriter.writeString("Please enter user ID");
        long id = consoleReader.readLong();
        userService.getUserById(id);
        facultyService.remove(id);
        return true;
    }
}


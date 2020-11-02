package by.studentstorage.action;

import by.studentstorage.console.ConsoleReader;
import by.studentstorage.console.ConsoleWriter;
import by.studentstorage.service.FacultyService;
import by.studentstorage.service.UserService;
import by.studentstorage.validator.FacultyValidator;

public class FacultyAction {
    private FacultyService facultyService = new FacultyService();
    private UserService userService = new UserService();
    private ConsoleWriter consoleWriter = new ConsoleWriter();
    private ConsoleReader consoleReader = new ConsoleReader();

    public String changeFaculty(){
        consoleWriter.writeString("Please enter new faculty");
        String newName = consoleReader.readString();
        while (!FacultyValidator.validFacultyName(newName)) {
            consoleWriter.writeString("Wrong input! Try again");
            newName = consoleReader.readString();
        }
        return "fdg";
    }

}


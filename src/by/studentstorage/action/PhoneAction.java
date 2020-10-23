package by.studentstorage.action;

import by.studentstorage.console.ConsoleApplication;
import by.studentstorage.console.ConsoleReader;
import by.studentstorage.console.ConsoleWriter;
import by.studentstorage.domain.Phone;
import by.studentstorage.service.PhoneService;
import by.studentstorage.service.UserService;
import by.studentstorage.validator.PhoneValidator;

public class PhoneAction {
    private PhoneService phoneService = new PhoneService();
    private UserService userService = new UserService();
    private ConsoleWriter consoleWriter = new ConsoleWriter();
    private ConsoleReader consoleReader = new ConsoleReader();

    public boolean addPhone() {
        consoleWriter.writeInt("Please enter your phone");
        int phoneNumber = consoleReader.readInt();
        while (!PhoneValidator.ValidPhoneNumber(phoneNumber)) {
            consoleWriter.writeString("Wrong input! Try again");
            phoneNumber = consoleReader.readInt();
        }
        return phoneService.save(new Phone(phoneNumber, ConsoleApplication.session.getCurrentUser().getId()));
    }

    public int changePhone(){
        consoleWriter.writeInt("Please enter new phone");
        int newPhone = consoleReader.readInt();
        while (!PhoneValidator.ValidPhoneNumber(newPhone)) {
            consoleWriter.writeInt("Wrong input! Try again");
            newPhone = consoleReader.readInt();
        }
        phoneService.updatePhone(new Phone(newPhone,ConsoleApplication.session.getCurrentUser().getId()), newPhone);
        return newPhone;
    }

    public boolean removePhone(){
        consoleWriter.writeInt("Please enter user ID");
        long id = consoleReader.readLong();
        userService.getUserById(id);
        phoneService.remove(id);
        return true;
    }
}

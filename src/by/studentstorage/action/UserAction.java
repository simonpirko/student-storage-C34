package by.studentstorage.action;

import by.studentstorage.console.ConsoleReader;
import by.studentstorage.console.ConsoleWriter;
import by.studentstorage.domain.Role;
import by.studentstorage.domain.User;
import by.studentstorage.service.UserService;
import by.studentstorage.validator.UserValidator;

public class UserAction {
    private ConsoleWriter writer = new ConsoleWriter();
    private ConsoleReader reader = new ConsoleReader();
    private UserService userService = new UserService();

    public void registration(){
        writer.writeString("Please enter login");
        String login = reader.readString();
        while (userService.getUserByLogin(login) != null){
            writer.writeString(login + "is already exist! Try another");
            login = reader.readString();
        }

        writer.writeString("Please enter password");
        String password = reader.readString();
        while (!UserValidator.validPassword(password)){
            writer.writeString("Your password is too short");
            writer.newLine();
            writer.writeString("It must be at least 4 symbols. Try again");
            password = reader.readString();
        }

        writer.writeString("Please enter your name");
        String name = reader.readString();
        while (!UserValidator.validName(name)){
            writer.writeString("Your name is too short");
            writer.newLine();
            writer.writeString("It must be at least 1 symbol. Try again");
            name = reader.readString();
        }

        writer.writeString("Please enter your surname");
        String surname = reader.readString();
        while (!UserValidator.validName(surname)){
            writer.writeString("Your surname is too short");
            writer.newLine();
            writer.writeString("It must be at least 1 symbol. Try again");
            surname = reader.readString();
        }
        if (userService.save(new User(name,login,surname,password))){
            writer.writeString("Registration successful!");
        }else{
            writer.writeString("Oooops. Something went wrong! Try again");
        }
    }

    public void authorization(){
        writer.writeString("Please enter login");
        String login = reader.readString();
        User user = userService.getUserByLogin(login);
        while (user == null){
            writer.writeString("Wrong login! Try again");
            login = reader.readString();
            user = userService.getUserByLogin(login);
        }
        writer.writeString("Please enter password");
        String password = reader.readString();
        while(!user.getPassword().equals(password)){
            writer.writeString("Wrong password! Try again");
            password = reader.readString();
        }
        writer.writeString("Welcome " + user.getName());
        writer.writeString("You successfully authorize yourself! ");
    }
}

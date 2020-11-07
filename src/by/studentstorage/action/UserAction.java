package by.studentstorage.action;

import by.studentstorage.console.ConsoleApplication;
import by.studentstorage.console.ConsoleReader;
import by.studentstorage.console.ConsoleWriter;
import by.studentstorage.domain.*;
import by.studentstorage.service.UserService;
import by.studentstorage.validator.UserValidator;

public class UserAction {
    private ConsoleWriter writer = new ConsoleWriter();
    private ConsoleReader reader = new ConsoleReader();
    private UserService userService = new UserService();


    public void registration() {
        writer.writeString("Please enter login");
        String login = reader.readString();
        while (userService.getUserByLogin(login) != null) {
            writer.writeString(login + "is already exist! Try another");
            login = reader.readString();
        }

        writer.writeString("Please enter password");
        String password = reader.readString();
        while (!UserValidator.validPassword(password)) {
            writer.writeString("Your password is too short");
            writer.newLine();
            writer.writeString("It must be at least 4 symbols. Try again");
            password = reader.readString();
        }

        writer.writeString("Please enter your name");
        String name = reader.readString();
        while (!UserValidator.validName(name)) {
            writer.writeString("Your name is too short");
            writer.newLine();
            writer.writeString("It must be at least 1 symbol. Try again");
            name = reader.readString();
        }

        writer.writeString("Please enter your surname");
        String surname = reader.readString();
        while (!UserValidator.validName(surname)) {
            writer.writeString("Your surname is too short");
            writer.newLine();
            writer.writeString("It must be at least 1 symbol. Try again");
            surname = reader.readString();
        }
        if (userService.save(new Student(login, name, surname, password))) {
            writer.writeString("Registration successful!");
        } else {
            writer.writeString("Oooops. Something went wrong! Try again");
        }
    }

    public void authorization() {
        writer.writeString("Please enter login");
        String login = reader.readString();
        if (login.equals("admin")) {
            writer.writeString("Please enter password");
            String password = reader.readString();
            if (password.equals("admin")) {
                Admin admin = new Admin();
                ConsoleApplication.session = new Session(admin);
                return;
            }
        }
        if (login.equals("moder")) {
            writer.writeString("Please enter password");
            String password = reader.readString();
            if (password.equals("moder")) {
                Moderator moder = new Moderator();
                ConsoleApplication.session = new Session(moder);
                return;
            }
        }
        User user = userService.getUserByLogin(login);
        while (user == null) {
            writer.writeString("Wrong login! Try again");
            login = reader.readString();
            user = userService.getUserByLogin(login);
        }

        writer.writeString("Please enter password");
        String password = reader.readString();
        while (!user.getPassword().equals(password)) {
            writer.writeString("Wrong password! Try again");
            password = reader.readString();
        }
        writer.writeString("Welcome " + user.getName());
        writer.writeString("You successfully authorize yourself! ");
        ConsoleApplication.session = new Session(user);
    }

    public void logout() {
        ConsoleApplication.session = null;
    }

    public void changeName() {
        writer.writeString("Please enter new name");
        String name = reader.readString();
        while (!UserValidator.validName(name)) {
            writer.writeString("Wrong input! Try again");
            name = reader.readString();
        }
        userService.updateName(name, ConsoleApplication.session.getCurrentUser().getId());
        writer.writeString("You successfully changed your name to " + name);
    }

    public void changeSurname() {
        writer.writeString("Please enter new surname");
        String surname = reader.readString();
        while (!UserValidator.validSurname(surname)) {
            writer.writeString("Wrong input! Try again");
            surname = reader.readString();
        }
        userService.updateSurname(surname, ConsoleApplication.session.getCurrentUser().getId());
        writer.writeString("You successfully changed your surname to " + surname);
    }

    public void changeEmail() {
        writer.writeString("Please enter your e-mail");
        String email = reader.readString();
        while (!UserValidator.validEmail(email)) {
            writer.writeString("Wrong input! Try again");
            email = reader.readString();
        }
        userService.updateEmail(email, ConsoleApplication.session.getCurrentUser().getId());
        writer.writeString("You successfully changed your email to " + email);
    }

    public void changePassword() {
        writer.writeString("Please enter new password");
        String password = reader.readString();
        while (!UserValidator.validPassword(password)) {
            writer.writeString("Wrong input! Try again");
            password = reader.readString();
        }
        userService.updatePassword(password, ConsoleApplication.session.getCurrentUser().getId());
        writer.writeString("Password was updated!");
    }
}

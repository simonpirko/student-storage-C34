package by.studentstorage.console;

import by.studentstorage.action.UserAction;
import by.studentstorage.domain.Session;

public class ConsoleApplication {
    private int applicationState = 1;
    private ConsoleReader consoleReader = new ConsoleReader();
    private ConsoleWriter consoleWriter = new ConsoleWriter();
    private UserAction userAction = new UserAction();
    public static Session session;

    public void run() {
        while (applicationState != 0){
            menu();
        }
    }

    private void menu() {
        if (applicationState == 1){
            showGuestMenu();
            switch (consoleReader.readInt()) {
                case 0:
                    applicationState = 0;
                    break;
                case 1:
                    userAction.registration();
                    break;
                case 2:
                    userAction.authorization();
                    applicationState = 2;
                    break;
                default:
                    consoleWriter.writeString("Wrong input!");
            }
        }
        if (session != null && applicationState == 2) {
            showUserMenu();
            switch (consoleReader.readInt()) {
                case 0:
                    applicationState = 0;
                    break;
                case 1:
                    userAction.logout();
                    applicationState = 1;
                    break;
                case 2:
                    applicationState = 3;
                    break;
                case 3:
                    applicationState = 4;
                    break;
                default:
                    consoleWriter.writeString("Wrong input!");
            }
        }
        if (applicationState == 3){
            showEditUserMenu();
            switch (consoleReader.readInt()) {
                case 0:
                    applicationState = 2;
                    break;
                case 1:
                    userAction.changeName();
                    break;
                case 2:
                    userAction.changeSurname();
                    break;
                case 3:
                    userAction.changePassword();
                    break;
                case 4:
                    userAction.changeEmail();
                    break;
                default:
                    consoleWriter.writeString("Wrong input!");
            }
        }
        if (applicationState == 4){
            showUserProfile();
            if (consoleReader.readInt() == 0){
                applicationState = 2;
            }
        }
    }

    private void showGuestMenu(){
        consoleWriter.writeString("0 - Exit");
        consoleWriter.writeString("1 - Registration");
        consoleWriter.writeString("2 - Authorization");
    }

    private void showUserMenu(){
        consoleWriter.writeString("0 - Exit");
        consoleWriter.writeString("1 - Log out");
        consoleWriter.writeString("2 - Edit profile");
        consoleWriter.writeString("3 - My profile");
    }

    private void showEditUserMenu(){
        consoleWriter.writeString("0 - Back");
        consoleWriter.writeString("1 - Change name");
        consoleWriter.writeString("2 - Change surname");
        consoleWriter.writeString("3 - Change password");
        consoleWriter.writeString("4 - Change e-mail");
    }

    private void showUserProfile(){
        consoleWriter.writeString(String.valueOf(ConsoleApplication.session.getCurrentUser()));
        consoleWriter.writeString("0 - Back");
    }
}


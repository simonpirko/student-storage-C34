package by.studentstorage.console;

import by.studentstorage.action.FacultyAction;
import by.studentstorage.action.StudentAction;
import by.studentstorage.action.UserAction;
import by.studentstorage.domain.Role;
import by.studentstorage.domain.Session;
import by.studentstorage.domain.Student;
import by.studentstorage.domain.User;

public class ConsoleApplication {
    private int applicationState = 1;
    private ConsoleReader consoleReader = new ConsoleReader();
    private ConsoleWriter consoleWriter = new ConsoleWriter();
    private UserAction userAction = new UserAction();
    private StudentAction studentAction = new StudentAction();
    private FacultyAction facultyAction = new FacultyAction();
    public static Session session;

    public void run() {
        while (applicationState != 0){
            menu();
        }
    }

    private void menu() {
        if (applicationState == 1) {
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
        } else {
            if (session.getCurrentUser().getRole().equals(Role.ADMIN)) {
                applicationState = -1;
                showAdminMenu();
                switch (consoleReader.readInt()) {
                    case 0:
                        applicationState = 0;
                        break;
                    case 1:
                        userAction.logout();
                        applicationState = 1;
                        break;
                    case 2:
                        applicationState = 5;
                        break;
                    case 3:
                        applicationState = 6;
                        break;
                    default:
                        consoleWriter.writeString("Wrong input!");
                }
            }
            if (session != null && applicationState == 2) {
                showUserMenu();
                switch (consoleReader.readInt()) {
                    case 0 -> applicationState = 0;
                    case 1 -> {
                        userAction.logout();
                        applicationState = 1;
                    }
                    case 2 -> applicationState = 3;
                    case 3 -> applicationState = 4;
                    default -> consoleWriter.writeString("Wrong input!");
                }
            }
            if (applicationState == 3) {
                showEditStudentMenu();
                switch (consoleReader.readInt()) {
                    case 0 -> applicationState = 2;
                    case 1 -> userAction.changeName();
                    case 2 -> userAction.changeSurname();
                    case 3 -> userAction.changePassword();
                    case 4 -> userAction.changeEmail();
                    case 5 -> studentAction.changeCourse();
                    case 6 -> studentAction.changeFaculty();
                    default -> consoleWriter.writeString("Wrong input!");
                }
            }
            if (applicationState == 4) {
                showUserProfile();
                if (consoleReader.readInt() == 0) {
                    applicationState = 2;
                }
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

    private void showEditStudentMenu(){
        consoleWriter.writeString("0 - Back");
        consoleWriter.writeString("1 - Change name");
        consoleWriter.writeString("2 - Change surname");
        consoleWriter.writeString("3 - Change password");
        consoleWriter.writeString("4 - Change e-mail");
        consoleWriter.writeString("5 - Change course");
        consoleWriter.writeString("6 - Change faculty");
    }

    private void showUserProfile(){
        Student currentUser = (Student) ConsoleApplication.session.getCurrentUser();
        consoleWriter.writeString("Name: " + ConsoleApplication.session.getCurrentUser().getName());
        consoleWriter.writeString("Surname: " + ConsoleApplication.session.getCurrentUser().getSurname());
        consoleWriter.writeString( "Login: " +(ConsoleApplication.session.getCurrentUser()).getLogin());
        consoleWriter.writeString("Born date: " +((Student) ConsoleApplication.session.getCurrentUser()).getBornDate());
        consoleWriter.writeString("E-mail: " + ConsoleApplication.session.getCurrentUser().getEmail());
        consoleWriter.writeString("Country: " + ((Student) ConsoleApplication.session.getCurrentUser()).getCountry());
        consoleWriter.writeString("Nationality: " + ((Student) ConsoleApplication.session.getCurrentUser()).getNationality());
        consoleWriter.writeString("City: " + ((Student) ConsoleApplication.session.getCurrentUser()).getCity());
        consoleWriter.writeString("Address: " + ((Student) ConsoleApplication.session.getCurrentUser()).getAddress());
        consoleWriter.writeString("Phone number : " + ((Student) ConsoleApplication.session.getCurrentUser()).getPhone());
        consoleWriter.writeString("Form of education: " + ((Student) ConsoleApplication.session.getCurrentUser()).getEducationForm());
        consoleWriter.writeString("Faculty: " + ((Student) ConsoleApplication.session.getCurrentUser()).getFaculty());
        consoleWriter.writeString("Group: " + ((Student) ConsoleApplication.session.getCurrentUser()).getGroup());
        consoleWriter.writeString("Course number: " + ((Student) ConsoleApplication.session.getCurrentUser()).getCourseNumber());
        consoleWriter.writeString("0 - Back");
    }

    private void showAdminMenu(){
        consoleWriter.writeString("0 - Exit");
        consoleWriter.writeString("1 - Log out");
        consoleWriter.writeString("2 - Add Teacher");
        consoleWriter.writeString("3 - Remover");
        consoleWriter.writeString("4 - Updater");
    }
}


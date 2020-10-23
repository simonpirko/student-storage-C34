package by.studentstorage.console;

import by.studentstorage.action.*;
import by.studentstorage.domain.*;
import by.studentstorage.service.LessonService;

import java.util.ArrayList;
import java.util.List;

public class ConsoleApplication {
    private int applicationState = 1;
    private ConsoleReader consoleReader = new ConsoleReader();
    private ConsoleWriter consoleWriter = new ConsoleWriter();
    private UserAction userAction = new UserAction();
    private StudentAction studentAction = new StudentAction();
    private TeacherAction teacherAction = new TeacherAction();
    private LessonAction lessonAction = new LessonAction();
    private AdminAction adminAction = new AdminAction();
    public static Session session;

    public void run() {
        while (applicationState != 0) {
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
                        adminAction.addTeacher();
                        break;
                    case 3:
                        adminAction.addLesson();
                        break;
                    case 4:
                        applicationState = 6;
                        break;
                    case 5:
                        //remover
                        break;
                    case 6:
                        //updater
                        break;
                    case 7:
                        adminAction.showAll();
                        break;
                    default:
                        consoleWriter.writeString("Wrong input!");
                }
            } else {
                if (session.getCurrentUser().getRole().equals(Role.TEACHER)) {
                    applicationState = 5;
                    showTeacherMenu();                                                                                 
                    switch (consoleReader.readInt()) {
                        case 0:
                            userAction.logout();
                            applicationState = 1;
                            break;
                        case 1:
                            teacherAction.addLesson();
                            break;
                        case 2:
                            lessonAction.showAllLessons();
                            break;
                        default:
                            consoleWriter.writeString("Wrong input!");
                    }
                }
            }
            if (applicationState == 6){
                lessonAction.showAllLessons();
                consoleWriter.writeString("0 - Back");
                if (consoleReader.readInt() == 0) {
                    applicationState = -1;
                }
            }
            if (session != null && applicationState == 2) {
                showUserMenu();
                switch (consoleReader.readInt()) {
                    case 0 -> {
                        userAction.logout();
                        applicationState = 1;
                    }
                    case 1 -> applicationState = 3;
                    case 2 -> applicationState = 4;
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

    private void showGuestMenu() {
        consoleWriter.writeString("0 - Exit");
        consoleWriter.writeString("1 - Registration");
        consoleWriter.writeString("2 - Authorization");
    }

    private void showUserMenu() {
        consoleWriter.writeString("0 - Log out");
        consoleWriter.writeString("1 - Edit profile");
        consoleWriter.writeString("2 - My profile");
    }

    private void showEditStudentMenu() {
        consoleWriter.writeString("0 - Back");
        consoleWriter.writeString("1 - Change name");
        consoleWriter.writeString("2 - Change surname");
        consoleWriter.writeString("3 - Change password");
        consoleWriter.writeString("4 - Change e-mail");
        consoleWriter.writeString("5 - Change course");
        consoleWriter.writeString("6 - Change faculty");
    }

    private void showUserProfile() {
        consoleWriter.writeString("ID: " + ConsoleApplication.session.getCurrentUser().getId());
        consoleWriter.writeString("Name: " + ConsoleApplication.session.getCurrentUser().getName());
        consoleWriter.writeString("Surname: " + ConsoleApplication.session.getCurrentUser().getSurname());
        consoleWriter.writeString("Login: " + (ConsoleApplication.session.getCurrentUser()).getLogin());
        consoleWriter.writeString("Born date: " + ((Student) ConsoleApplication.session.getCurrentUser()).getBornDate());
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

    private void showAdminMenu() {
        consoleWriter.writeString("0 - Exit");
        consoleWriter.writeString("1 - Log out");
        consoleWriter.writeString("2 - Add Teacher");
        consoleWriter.writeString("3 - Add Lesson");
        consoleWriter.writeString("4 - Schedule");
        consoleWriter.writeString("5 - Remover");
        consoleWriter.writeString("6 - Updater");
        consoleWriter.writeString("7 - Show all users");
    }

    private void showTeacherMenu() {
        consoleWriter.writeString("0 - Log out");
        consoleWriter.writeString("1 - Add new lesson");
        consoleWriter.writeString("2 - Schedule");
    }
}


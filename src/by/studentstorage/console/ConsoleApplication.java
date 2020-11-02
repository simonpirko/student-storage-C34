package by.studentstorage.console;

import by.studentstorage.action.*;
import by.studentstorage.domain.Role;
import by.studentstorage.domain.Session;
import by.studentstorage.domain.Student;

public class ConsoleApplication {
    private String applicationState = "Guest";
    private ConsoleReader consoleReader = new ConsoleReader();
    private ConsoleWriter consoleWriter = new ConsoleWriter();
    private UserAction userAction = new UserAction();
    private StudentAction studentAction = new StudentAction();
    private TeacherAction teacherAction = new TeacherAction();
    private LessonAction lessonAction = new LessonAction();
    private AdminAction adminAction = new AdminAction();
    private ModeratorAction moderatorAction = new ModeratorAction();
    public static Session session;

    public void run() {
        while (!applicationState.equals("Stop")) {
            menu();
        }
    }

    private void menu() {
        if (applicationState.equals("Guest")) {
            showGuestMenu();
            switch (consoleReader.readString()) {
                case "0":
                    applicationState = "Stop";
                    break;
                case "1":
                    userAction.registration();
                    break;
                case "2":
                    userAction.authorization();
                    RoleDefiner();
                    break;
                default:
                    consoleWriter.writeString("Wrong input!");
            }
        }
        if (applicationState.equals("Admin")){
            showAdminMenu();
            switch (consoleReader.readString()) {
                case "0":
                    applicationState = "Stop";
                    break;
                case "1":
                    userAction.logout();
                    applicationState = "Guest";
                    break;
                case "2":
                    adminAction.addTeacher();
                    break;
                case "3":
                    adminAction.addLesson();
                    break;
                case "4":
                    applicationState = "Schedule";
                    break;
                case "5":
                    //remover
                    break;
                case "6":
                    applicationState = "Updater";
                    break;
                case "7":
                    adminAction.showAll();
                    break;
                default:
                    consoleWriter.writeString("Wrong input!");
            }
        }
        if (applicationState.equals("Moderator")){
            showModeratorMenu();
            switch (consoleReader.readString()) {
                case "0" -> applicationState = "Stop";
                case "1" -> {
                    userAction.logout();
                    applicationState = "Guest";
                }
                case "2" -> applicationState = "Schedule";
                case "3" -> applicationState = "Updater";
                case "4" -> adminAction.showAll();
                default -> consoleWriter.writeString("Wrong input!");
            }
        }
        if (applicationState.equals("Teacher")) {
            showTeacherMenu();
            switch (consoleReader.readString()) {
                case "0":
                    userAction.logout();
                    applicationState = "Guest";
                    break;
                case "1":
                    teacherAction.addLesson();
                    break;
                case "2":
                    lessonAction.showAllLessons();
                    break;
                default:
                    consoleWriter.writeString("Wrong input!");
            }
        }
        if (applicationState.equals("Student")) {
            showStudentMenu();
            switch (consoleReader.readString()) {
                case "0" -> {
                    userAction.logout();
                    applicationState = "Guest";
                }
                case "1" -> applicationState = "EditStudentMenu";
                case "2" -> applicationState = "Profile";
                default -> consoleWriter.writeString("Wrong input!");
            }
        }
        if (applicationState.equals("EditStudentMenu")){
            showEditStudentMenu();
            switch (consoleReader.readString()) {
                case "0" -> applicationState = "Student";
                case "1" -> userAction.changeName();
                case "2" -> userAction.changeSurname();
                case "3" -> userAction.changePassword();
                case "4" -> userAction.changeEmail();
                case "5" -> studentAction.changeCourse();
                case "6" -> studentAction.changeFaculty();
                default -> consoleWriter.writeString("Wrong input!");
            }
        }
        if (applicationState.equals("Profile")){
            showUserProfile();
            if (consoleReader.readString().equals("0")) {
                applicationState = "Student";
            }else{
                consoleWriter.writeString("Wrong input!");
            }
        }
        if (applicationState.equals("Updater")){
            showUpdaterMenu();
            switch (consoleReader.readString()) {
                case "0" -> {
                    if (ConsoleApplication.session.getCurrentUser().getRole().equals(Role.MODERATOR)) {
                        applicationState = "Moderator";
                    } else {
                        applicationState ="Admin";
                    }
                }
                case "1" -> applicationState = "TeacherUpdater";
                case "2" -> applicationState = "StudentUpdater";
                default -> consoleWriter.writeString("Wrong input!");
            }
        }
        if (applicationState.equals("TeacherUpdater")){
            teacherUpdaterMenu();
            switch (consoleReader.readString()) {
                case "0" -> applicationState = "Updater";
                case "1" -> moderatorAction.updateLogin();
                case "2" -> moderatorAction.updateName();
                case "3" -> moderatorAction.updateSurname();
                case "4" -> moderatorAction.updateEmail();
                case "5" -> moderatorAction.updatePass();
                case "6" -> moderatorAction.updateRank();
                case "7" -> moderatorAction.updatePosition();
                case "8" -> moderatorAction.updateDepartment();
                default -> consoleWriter.writeString("Wrong input!");
            }
        }
        if (applicationState.equals("StudentUpdater")){
            studentUpdaterMenu();
            switch (consoleReader.readString()) {
                case "0" -> applicationState = "Updater";
                case "1" -> moderatorAction.updateLogin();
                case "2" -> moderatorAction.updateName();
                case "3" -> moderatorAction.updateSurname();
                case "4" -> moderatorAction.updateEmail();
                case "5" -> moderatorAction.updatePass();
                case "6" -> moderatorAction.updateAddress();
                case "7" -> moderatorAction.updateCity();
                case "8" -> moderatorAction.updateNationality();
                case "9" -> moderatorAction.updateCountry();
                case "10" -> moderatorAction.updatePhone();
                case "11" -> moderatorAction.updateGroup();
                case "12" -> moderatorAction.updateFaculty();
                case "13" -> moderatorAction.updateCourse();
                case "14" -> moderatorAction.updateBirth();
                case "15" -> moderatorAction.updateEducationForm();
                case "16" -> moderatorAction.updateWarrior();
                default -> consoleWriter.writeString("Wrong input!");
            }
        }
    }

    private void RoleDefiner() {
        if (ConsoleApplication.session.getCurrentUser().getRole().equals(Role.ADMIN)){
            applicationState = "Admin";
        }
        if (ConsoleApplication.session.getCurrentUser().getRole().equals(Role.MODERATOR)){
            applicationState = "Moderator";
        }
        if (ConsoleApplication.session.getCurrentUser().getRole().equals(Role.TEACHER)){
            applicationState = "Teacher";
        }
        if (ConsoleApplication.session.getCurrentUser().getRole().equals(Role.STUDENT)){
            applicationState = "Student";
        }
    }

    private void showGuestMenu() {
        consoleWriter.writeString("0 - Exit");
        consoleWriter.writeString("1 - Registration");
        consoleWriter.writeString("2 - Authorization");
    }

    private void showStudentMenu() {
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
        consoleWriter.writeString("Army suitability " + ((Student) ConsoleApplication.session.getCurrentUser()).isWarrior());
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

    private void showModeratorMenu() {
        consoleWriter.writeString("0 - Exit");
        consoleWriter.writeString("1 - Log out");
        consoleWriter.writeString("2 - Show all lessons");
        consoleWriter.writeString("3 - Updater");
        consoleWriter.writeString("4 - Show all users");
    }

    private void showTeacherMenu() {
        consoleWriter.writeString("0 - Log out");
        consoleWriter.writeString("1 - Add new lesson");
        consoleWriter.writeString("2 - Schedule");
    }

    private void showUpdaterMenu() {
        consoleWriter.writeString("0 - Back");
        consoleWriter.writeString("1 - Update teacher");
        consoleWriter.writeString("2 - Update student");
    }

    private void teacherUpdaterMenu() {
        consoleWriter.writeString("0 - Back");
        consoleWriter.writeString("1 - Update login");
        consoleWriter.writeString("2 - Update name");
        consoleWriter.writeString("3 - Update surname");
        consoleWriter.writeString("4 - Update email");
        consoleWriter.writeString("5 - Update password");
        consoleWriter.writeString("6 - Update rank");
        consoleWriter.writeString("7 - Update position");
        consoleWriter.writeString("8 - Update department");
    }

    private void studentUpdaterMenu() {
        consoleWriter.writeString(" 0 - Back");
        consoleWriter.writeString(" 1 - Update login");
        consoleWriter.writeString(" 2 - Update name");
        consoleWriter.writeString(" 3 - Update surname");
        consoleWriter.writeString(" 4 - Update email");
        consoleWriter.writeString(" 5 - Update password");
        consoleWriter.writeString(" 6 - Update address");
        consoleWriter.writeString(" 7 - Update city");
        consoleWriter.writeString(" 8 - Update nationality");
        consoleWriter.writeString(" 9 - Update country");
        consoleWriter.writeString("10 - Update phone");
        consoleWriter.writeString("11 - Update group");
        consoleWriter.writeString("12 - Update faculty");
        consoleWriter.writeString("13 - Update course number");
        consoleWriter.writeString("14 - Update date of birth");
        consoleWriter.writeString("15 - Update form of education");
        consoleWriter.writeString("16 - Update warrior");
    }
}

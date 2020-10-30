package by.studentstorage.action;

import by.studentstorage.console.ConsoleReader;
import by.studentstorage.console.ConsoleWriter;
import by.studentstorage.domain.*;
import by.studentstorage.service.StudentService;
import by.studentstorage.service.TeacherService;
import by.studentstorage.service.UserService;

public class ModeratorAction {
    private ConsoleReader consoleReader = new ConsoleReader();
    private ConsoleWriter consoleWriter = new ConsoleWriter();
    private UserService userService = new UserService();
    private StudentService studentService = new StudentService();
    private TeacherService teacherService = new TeacherService();

    public void updateLogin() {
        consoleWriter.writeString("Please enter user's id");
        int id = consoleReader.readInt();
        User userByLogin = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's login");
        String newLogin = consoleReader.readString();
        userService.updateLogin(newLogin, userByLogin.getId());
    }

    public void updateName() {
        consoleWriter.writeString("Please enter user's ID");
        long id = consoleReader.readLong();
        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's name");
        String name = consoleReader.readString();
        userService.updateName(name, userByID.getId());
    }

    public void updateSurname() {
        consoleWriter.writeString("Please enter user's ID");
        long id = consoleReader.readLong();
        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's surname");
        String surname = consoleReader.readString();
        userService.updateSurname(surname, userByID.getId());
    }

    public void updateEmail() {
        consoleWriter.writeString("Please enter user's ID");
        long id = consoleReader.readLong();
        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's e-mail");
        String email = consoleReader.readString();
        userService.updateEmail(email, userByID.getId());
    }

    public void updatePass() {
        consoleWriter.writeString("Please enter user's ID");
        long id = consoleReader.readLong();
        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's password");
        String pass = consoleReader.readString();
        userService.updatePassword(pass, userByID.getId());
    }

    public void updateAddress() {
        consoleWriter.writeString("Please enter user's ID");
        long id = consoleReader.readLong();
        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's address");
        String address = consoleReader.readString();
        studentService.updateAddress(address, (Student) userByID);
    }

    public void updateCity() {
        consoleWriter.writeString("Please enter user's ID");
        long id = consoleReader.readLong();
        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's City");
        String city = consoleReader.readString();
        studentService.updateCity(city, userByID.getId());
    }

    public void updateNationality() {
        consoleWriter.writeString("Please enter user's ID");
        long id = consoleReader.readLong();
        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's nationality");
        String nat = consoleReader.readString();
        studentService.updateNationality(nat, userByID.getId());
    }

    public void updateCountry() {
        consoleWriter.writeString("Please enter user's ID");
        long id = consoleReader.readLong();
        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's country");
        String coutry = consoleReader.readString();
        studentService.updateCountry(coutry, userByID.getId());
    }

    public void updatePhone() {
        consoleWriter.writeString("Please enter user's ID");
        long id = consoleReader.readLong();
        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's phone");
        int phone = consoleReader.readInt();
        studentService.updatePhone(phone, userByID.getId());
    }


    public void updateGroup() {
        consoleWriter.writeString("Please enter user's ID");
        long id = consoleReader.readLong();
        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's gropu");
        String group = consoleReader.readString();
        studentService.updateGroup(group, (Student) userByID);
    }

    public void updateFaculty() {
        consoleWriter.writeString("Please enter user's ID");
        long id = consoleReader.readLong();
        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's faculty");
        String faculty = consoleReader.readString();
        studentService.updateFaculty(faculty, (Student) userByID);
    }

    public void updateCourse() {
        consoleWriter.writeString("Please enter user's ID");
        long id = consoleReader.readLong();
        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's course number");
        int course = consoleReader.readInt();
        studentService.updateCourse(course, (Student) userByID);
    }

    public void updateBirth() {
        consoleWriter.writeString("Please enter user's ID");
        long id = consoleReader.readLong();
        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's date of birth");
        String birth = consoleReader.readString();
        studentService.updateBirth(birth, userByID.getId());
    }

    public void updateEducationForm() {
        consoleWriter.writeString("Please enter user's ID");
        long id = consoleReader.readLong();
        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's form of education");
        String education = consoleReader.readString();
        studentService.updateEducationForm(education, (Student) userByID);
    }


    public void updateWarrior() {
        consoleWriter.writeString("Please enter user's ID");
        long id = consoleReader.readLong();
        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter users's suitability for the army.");
        consoleWriter.writeString("Where 0 - is not suitable and 1 - is suitable.");
        if (consoleReader.readInt() == 0) {
            studentService.updateWarrior(false, userByID.getId());
        } else {
            studentService.updateWarrior(true, userByID.getId());
        }
    }

    public void updateRank() {
        consoleWriter.writeString("Please enter user's ID");
        long id = consoleReader.readLong();
        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's rank");
        String rank = consoleReader.readString().toUpperCase();
        teacherService.updateRank(Rank.valueOf(rank), (Teacher) userByID);
    }

    public void updatePosition() {
        consoleWriter.writeString("Please enter user's ID");
        long id = consoleReader.readLong();
        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's position");
        String position = consoleReader.readString().toUpperCase();
        teacherService.updatePosition(Position.valueOf(position), (Teacher) userByID);
    }

    public void updateDepartment() {
        consoleWriter.writeString("Please enter user's ID");
        long id = consoleReader.readLong();
        User userByID = userService.getUserById(id);
        consoleWriter.writeString("Please enter new user's department");
        String dep = consoleReader.readString();
        teacherService.updateDepartment(dep, (Teacher) userByID);
    }
}

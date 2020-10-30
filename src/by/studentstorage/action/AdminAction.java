package by.studentstorage.action;

import by.studentstorage.console.ConsoleApplication;
import by.studentstorage.console.ConsoleReader;
import by.studentstorage.console.ConsoleWriter;
import by.studentstorage.domain.*;
import by.studentstorage.service.LessonService;
import by.studentstorage.service.TeacherService;
import by.studentstorage.service.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdminAction {
    private TeacherService teacherService = new TeacherService();
    private LessonService lessonService = new LessonService();
    private ConsoleWriter consoleWriter = new ConsoleWriter();
    private ConsoleReader consoleReader = new ConsoleReader();
    private UserService userService = new UserService();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH/mm");

    public void addLesson(){
        consoleWriter.writeString("Write discipline");
        String discipline = consoleReader.readString();

        consoleWriter.writeString("Write lesson type");
        String lessonType = consoleReader.readString();

        consoleWriter.writeString("Write date in the following format: dd/mm/yy");
        String date = consoleReader.readString();
        Date date1 = null;
        try {
            date1 = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        consoleWriter.writeString("Write start time in the following format: HH/MM");
        String time = consoleReader.readString();
        Date startTime = null;
        try {
            startTime = timeFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time1 = startTime.getTime() + 5400000;
        Date endTime = new Date(time1);

        consoleWriter.writeString("Write users ID");
        long id = consoleReader.readLong();

        Teacher teacher = (Teacher) userService.getUserById(id);
        lessonService.save(new Lesson(lessonType, discipline,startTime, endTime, date1, teacher));
    }

    public void addTeacher(){
        consoleWriter.writeString("Enter name");
        String name = consoleReader.readString();

        consoleWriter.writeString("Enter login");
        String login = consoleReader.readString();

        consoleWriter.writeString("Enter surname");
        String surname = consoleReader.readString();

        consoleWriter.writeString("Enter E-mail");
        String email = consoleReader.readString();

        consoleWriter.writeString("Enter password");
        String password = consoleReader.readString();

        consoleWriter.writeString("Enter rank");
        String rank = consoleReader.readString();
        Rank rank1 = Rank.valueOf(rank.toUpperCase());

        consoleWriter.writeString("Enter department");
        String department = consoleReader.readString();

        consoleWriter.writeString("Enter position");
        String position = consoleReader.readString();
        Position position1 = Position.valueOf(position.toUpperCase());
        Teacher teacher = new Teacher(name, login, surname, email, password, Role.TEACHER, rank1, position1, department);
        teacherService.save(teacher);
    }

    public void showAll(){
        List<User> all = userService.getAll();
        for (int i = 0; i < all.size(); i++) {
            User user = all.get(i);
            consoleWriter.writeString(String.valueOf(user.getRole()));
            consoleWriter.writeString("User's ID: " + user.getId());
            consoleWriter.writeString("User's login: " + user.getLogin());
            consoleWriter.writeString("User's password: " + user.getPassword());
            consoleWriter.writeString("User's name: " + user.getName());
            consoleWriter.writeString("User's surname: " + user.getSurname());
            consoleWriter.writeString("User's e-mail: " + user.getEmail());

            if (user.getRole().equals(Role.TEACHER)){
                Teacher teacher = (Teacher) user;
                consoleWriter.writeString("User's rank: " + teacher.getRank());
                consoleWriter.writeString("User's position: " + teacher.getPosition());
                consoleWriter.writeString("User's department: " + teacher.getDepartment());
                consoleWriter.writeString("////////////////////////////////////////////////");
                consoleWriter.newLine();
            }
            if (user.getRole().equals(Role.STUDENT)){
                Student student = (Student) user;
                consoleWriter.writeString("User's born date: " + student.getBornDate());
                consoleWriter.writeString("User's country: " + student.getCountry());
                consoleWriter.writeString("User's nationality: " + student.getNationality());
                consoleWriter.writeString("User's city: " + student.getCity());
                consoleWriter.writeString("User's address: " + student.getAddress());
                consoleWriter.writeString("User's phone number: " + student.getPhone());
                consoleWriter.writeString("User's form of education: " + student.getEducationForm());
                consoleWriter.writeString("User's faculty: " + student.getFaculty());
                consoleWriter.writeString("User's group: " + student.getGroup());
                consoleWriter.writeString("User's course number: " + student.getCourseNumber());
                consoleWriter.writeString("////////////////////////////////////////////////");
                consoleWriter.newLine();
            }
        }
    }
}

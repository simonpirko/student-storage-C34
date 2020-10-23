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
            consoleWriter.writeString(String.valueOf(all.get(i)));
        }
    }
}

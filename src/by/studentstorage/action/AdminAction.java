package by.studentstorage.action;

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

    public void addLesson() {
        int numDay, numMonth, numYear, hours, minutes;
        int typeLesson;
        String lessonType;
        consoleWriter.writeString("Write discipline");
        String discipline = consoleReader.readString();
        consoleWriter.writeString("Write lesson type:");
        consoleWriter.writeString("1-LABORATORY \n2-LECTURE \n3-PRACTICAL");
        do {
            while (!consoleReader.hasInt()) {
                consoleWriter.writeString("Error: input only numbers:1,2,3");
            }
            typeLesson = consoleReader.readInt();
            if (typeLesson < 1 || typeLesson > 3) {
                consoleWriter.writeString("Error: input numbers >0 and <4");
            } else {
                break;
            }
        } while (true);
        switch (typeLesson) {
            case 1:
                lessonType = "LABORATORY";
                break;
            case 2:
                lessonType = "LECTURE";
                break;
            case 3:
                lessonType = "PRACTICAL";
                break;
            default:
                lessonType = "Error";
        }
        consoleWriter.writeString("Write date:input number of day");
        do {
            while (!consoleReader.hasInt()) {
                consoleWriter.writeString("Error: input only numbers");
            }
            numDay = consoleReader.readInt();
            if (numDay < 1 || numDay > 31) {
                consoleWriter.writeString("Error: input numbers >0 and <32");
            } else {
                break;
            }

        } while (true);


        consoleWriter.writeString("Write date:input number of month");
        do {
            while (!consoleReader.hasInt()) {
                consoleWriter.writeString("Error: input only numbers");
            }
            numMonth = consoleReader.readInt();
            if (numMonth < 1 || numMonth > 12) {
                consoleWriter.writeString("Error: input numbers >0 and <13");
            } else {
                break;
            }

        } while (true);

        consoleWriter.writeString("Write date:input number of year");
        do {
            while (!consoleReader.hasInt()) {
                consoleWriter.writeString("Error: input only numbers");
            }
            numYear = consoleReader.readInt();
            if (numYear < 2020 || numYear > 2100) {
                consoleWriter.writeString("Error: input numbers >2019 and <2101");
            } else {
                break;
            }
        } while (true);
        String date = numDay + "/" + numMonth + "/" + numYear;
        Date date1 = null;
        try {
            date1 = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        consoleWriter.writeString("Write start time: hours");
        do {
            while (!consoleReader.hasInt()) {
                consoleWriter.writeString("Error: input only numbers");
            }
            hours = consoleReader.readInt();
            if (hours < 8 || hours > 22) {
                consoleWriter.writeString("Error: input numbers >7 and <21");
            } else {
                break;
            }
        } while (true);
        consoleWriter.writeString("Write start time: minutes");
        do {
            while (!consoleReader.hasInt()) {
                consoleWriter.writeString("Error: input only numbers");
            }
            minutes = consoleReader.readInt();
            if (minutes < 0 || minutes > 59) {
                consoleWriter.writeString("Error: input numbers >=0 and <=59");
            } else {
                break;
            }
        } while (true);
        String time = hours + "/" + minutes;
        Date startTime = null;
        try {
            startTime = timeFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time1 = startTime.getTime() + 5400000;
        Date endTime = new Date(time1);

        consoleWriter.writeString("Write users ID");
        long id;
        do {
            while (!consoleReader.hasInt()) {
                consoleWriter.writeString("Error: input only numbers");
            }
            id = consoleReader.readLong();
            if (id <= 0) {
                consoleWriter.writeString("Error: input numbers >0");
            } else {
                break;
            }
        } while (true);
        Teacher teacher = (Teacher) userService.getUserById(id);
        lessonService.save(new Lesson(lessonType, discipline, startTime, endTime, date1, teacher));
    }


    public void addTeacher() {
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
        consoleWriter.writeString("1-PROFESSOR \n2-DOCENT");
        int rank;
        do {
            while (!consoleReader.hasInt()) {
                consoleWriter.writeString("Error: input only numbers:1 or 2");
            }
            rank = consoleReader.readInt();
            if (rank < 1 || rank > 2) {
                consoleWriter.writeString("Error: input numbers 1 or 2");
            } else {
                break;
            }
        } while (true);
        Rank rank1;
        switch (rank) {
            case 1:
                rank1 = Rank.PROFESSOR;
                break;
            case 2:
                rank1 = Rank.DOCENT;
                break;
            default:
                rank1 = null;
        }
        consoleWriter.writeString("Enter department");
        String department = consoleReader.readString();
        consoleWriter.writeString("Enter position");
        int position;
        consoleWriter.writeString("1-ASSISTANT \n2-SENIOR");
        do {
            while (!consoleReader.hasInt()) {
                consoleWriter.writeString("Error: input only numbers:1 or 2");
            }
            position = consoleReader.readInt();
            if (position < 1 || position > 2) {
                consoleWriter.writeString("Error: input numbers 1 or 2");
            } else {
                break;
            }
        } while (true);
        Position position1;
        switch (position) {
            case 1:
                position1 = Position.ASSISTANT;
                break;
            case 2:
                position1 = Position.SENIOR;
                break;
            default:
                position1 = null;
        }
        Teacher teacher = new Teacher(name, login, surname, email, password, Role.TEACHER, rank1, position1, department);
        teacherService.save(teacher);
    }

    public void showAll() {
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

            if (user.getRole().equals(Role.TEACHER)) {
                Teacher teacher = (Teacher) user;
                consoleWriter.writeString("User's rank: " + teacher.getRank());
                consoleWriter.writeString("User's position: " + teacher.getPosition());
                consoleWriter.writeString("User's department: " + teacher.getDepartment());
                consoleWriter.writeString("////////////////////////////////////////////////");
                consoleWriter.newLine();
            }
            if (user.getRole().equals(Role.STUDENT)) {
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

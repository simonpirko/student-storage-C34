package by.studentstorage.action;

import by.studentstorage.console.ConsoleApplication;
import by.studentstorage.console.ConsoleReader;
import by.studentstorage.console.ConsoleWriter;
import by.studentstorage.domain.Lesson;
import by.studentstorage.domain.Teacher;
import by.studentstorage.service.LessonService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TeacherAction {
    private LessonService lessonService = new LessonService();
    private ConsoleReader consoleReader = new ConsoleReader();
    private ConsoleWriter consoleWriter = new ConsoleWriter();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH/mm");


    public void addLesson() {
        String lessonType;
        int typeLesson;
        consoleWriter.writeString("Write discipline");
        String discipline = consoleReader.readString();

        consoleWriter.writeString("Write lesson type");
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

        int numDay, numMonth, numYear;
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
        int hours;
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
        int minutes;
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
        lessonService.save(new Lesson(lessonType, discipline, startTime, endTime, date1, (Teacher) ConsoleApplication.session.getCurrentUser()));
    }
}

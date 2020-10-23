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
        lessonService.save(new Lesson(lessonType, discipline,startTime, startTime, endTime, (Teacher) ConsoleApplication.session.getCurrentUser()));
    }
}

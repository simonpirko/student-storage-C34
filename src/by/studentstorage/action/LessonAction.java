package by.studentstorage.action;

import by.studentstorage.console.ConsoleWriter;
import by.studentstorage.domain.Lesson;
import by.studentstorage.service.LessonService;

import java.text.SimpleDateFormat;
import java.util.List;

public class LessonAction {
    private LessonService lessonService = new LessonService();
    private ConsoleWriter consoleWriter = new ConsoleWriter();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH/mm");


    public void showAllLessons() {
        List<Lesson> lessons = lessonService.getAll();
        for (int i = 0; i < lessons.size(); i++) {
            Lesson lesson = lessons.get(i);
            consoleWriter.writeString("Lesson type: " + lesson.getLessonType());
            consoleWriter.writeString("Discipline: " + lesson.getDiscipline());
            consoleWriter.writeString("Date: " +  dateFormat.format(lesson.getData()));
            consoleWriter.writeString("Start time: " + timeFormat.format(lesson.getStartTime()));
            consoleWriter.writeString("End time: " + timeFormat.format(lesson.getEndTime()));
        }
    }
}

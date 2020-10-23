package by.studentstorage.storage;

import by.studentstorage.domain.Discipline;
import by.studentstorage.domain.Lesson;
import by.studentstorage.domain.Teacher;

import java.util.Date;
import java.util.List;

public interface LessonStorage {
    public boolean save(Lesson lesson);

    public List<Lesson> getAll();
    public Lesson getByTeacher(Teacher teacher);
    public Lesson getByDiscipline(String discipline);

    public boolean removeByTeacher(Teacher teacher);
    public boolean removeByDiscipline(String discipline);

    public Date updateByDate(Date date, Teacher teacher);

    public boolean contains(Teacher teacher);
    public boolean contains(Date date);
    public boolean contains(String discipline);

}

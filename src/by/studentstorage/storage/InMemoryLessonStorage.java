package by.studentstorage.storage;

import by.studentstorage.domain.Discipline;
import by.studentstorage.domain.Lesson;
import by.studentstorage.domain.Teacher;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InMemoryLessonStorage implements LessonStorage {
    private static List<Lesson> lessons = new ArrayList<>();

    @Override
    public boolean save(Lesson lesson) {
        return lessons.add(lesson);
    }

    @Override
    public List<Lesson> getAll() {
        return lessons;
    }

    @Override
    public Lesson getByTeacher(Teacher teacher) {
        for (Lesson lesson : lessons) {
            if (lesson.getTeacher().equals(teacher))
                return lesson;
        }
        return null;
    }

    @Override
    public Lesson getByDiscipline(String discipline) {
        for (Lesson lesson : lessons) {
            if (lesson.getDiscipline().equals(discipline))
                return lesson;
        }
        return null;
    }

    @Override
    public boolean removeByTeacher(Teacher teacher) {
        for (int i = 0; i < lessons.size(); i++) {
            if (lessons.get(i).getTeacher().equals(teacher)){
                lessons.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeByDiscipline(String discipline) {
        for (int i = 0; i < lessons.size(); i++) {
            if (lessons.get(i).getDiscipline().equals(discipline)){
                lessons.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Date updateByDate(Date date, Teacher teacher) {
        for (int i = 0; i < lessons.size(); i++) {
            if (lessons.get(i).getTeacher().equals(teacher)){
                lessons.get(i).setData(date);
                return date;
            }
        }
        return null;
    }

    @Override
    public boolean contains(Teacher teacher) {
        for (int i = 0; i < lessons.size(); i++) {
            if (lessons.get(i).getTeacher().equals(teacher)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Date date) {
        if (date == null)return false;
        for (int i = 0; i < lessons.size(); i++) {
            if (lessons.get(i).getData().equals(date)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(String discipline) {
        for (int i = 0; i < lessons.size(); i++) {
            if (lessons.get(i).getDiscipline().equals(discipline)) {
                return true;
            }
        }
        return false;
    }
}

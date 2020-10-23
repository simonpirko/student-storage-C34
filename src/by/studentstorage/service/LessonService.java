package by.studentstorage.service;

import by.studentstorage.domain.Discipline;
import by.studentstorage.domain.Lesson;
import by.studentstorage.domain.Teacher;
import by.studentstorage.storage.InMemoryLessonStorage;

import java.util.List;

public class LessonService {
    private InMemoryLessonStorage inMemoryLessonStorage = new InMemoryLessonStorage();

    public boolean save(Lesson lesson){
        if (inMemoryLessonStorage.contains(lesson.getData()) && inMemoryLessonStorage.contains(lesson.getTeacher()) && inMemoryLessonStorage.contains(lesson.getDiscipline())){
            throw new LessonAlreadyExcist();
        }
        return inMemoryLessonStorage.save(lesson);
    }

    public List<Lesson> getAll(){
        if (inMemoryLessonStorage.getAll().size() == 0){
            throw new LessonNotFoundException();
        }
        return inMemoryLessonStorage.getAll();
    }

    public Lesson getByTeacher(Teacher teacher){
        if (inMemoryLessonStorage.contains(teacher)){
            inMemoryLessonStorage.getByTeacher(teacher);
        }
        throw new LessonNotFoundException();
    }

    public Lesson getByDiscipline(String discipline){
        if (inMemoryLessonStorage.contains(discipline)){
            inMemoryLessonStorage.getByDiscipline(discipline);
        }
        throw new LessonNotFoundException();
    }
}

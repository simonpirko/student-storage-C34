package by.studentstorage.service;

import by.studentstorage.domain.EducationForm;
import by.studentstorage.domain.Faculty;
import by.studentstorage.domain.Group;
import by.studentstorage.domain.Student;
import by.studentstorage.storage.InMemoryStudentStorage;

import java.util.EmptyStackException;
import java.util.List;

public class StudentService {
    private InMemoryStudentStorage inMemoryStudentStorage = new InMemoryStudentStorage();

    public boolean save(Student student){
        if (inMemoryStudentStorage.save(student)) {
            return true;
        }
        throw new StudentNotFoudException();
    }

    public List<Student> getAll(){
        if (inMemoryStudentStorage.getAll().size() != 0){
            return inMemoryStudentStorage.getAll();

        }
        throw new StudentNotFoudException();
    }

    public List<Student> getByGroup(String group) {
        List<Student> byGroup = inMemoryStudentStorage.getByGroup(group);
        if (byGroup == null){
            throw new StudentNotFoudException();
        }
        return byGroup;
    }

    public List<Student> getByFaculty(String faculty) {
        List<Student> byFaculty = inMemoryStudentStorage.getByFaculty(faculty);
        if (byFaculty == null){
            throw new StudentNotFoudException();
        }
        return byFaculty;
    }

    public List<Student> getByCourseNumber(int coursenumber) {
        List<Student> byCourse = inMemoryStudentStorage.getByCourseNumber(coursenumber);
        if (byCourse == null){
            throw new StudentNotFoudException();
        }
        return byCourse;
    }

    public List<Student> getByEducationForm(String educationForm) {
        List<Student> byEducationForm = inMemoryStudentStorage.getByEducationForm(educationForm);
        if (byEducationForm == null){
            throw new StudentNotFoudException();
        }
        return byEducationForm;
    }

    public String  updateGroup(String group, Student student) {
        if (!inMemoryStudentStorage.contains(student)){
            throw new StudentNotFoudException();
        }
        return inMemoryStudentStorage.updateGroup(group,student.getId());
    }

    public int updateCourse(int course, Student student) {
        if (!inMemoryStudentStorage.contains(student)){
            throw new StudentNotFoudException();
        }
        return inMemoryStudentStorage.updateCourse(course,student.getId());
    }

    public String updateEducationForm(String form, Student student) {
        if (!inMemoryStudentStorage.contains(student)){
            throw new StudentNotFoudException();
        }
        return inMemoryStudentStorage.updateEducationForm(form,student.getId());
    }

    public String updateFaculty(String faculty, Student student) {
        if (!inMemoryStudentStorage.contains(student)){
            throw new StudentNotFoudException();
        }
        return inMemoryStudentStorage.updateFaculty(faculty,student.getId());
    }
}

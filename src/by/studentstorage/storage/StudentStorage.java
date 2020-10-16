package by.studentstorage.storage;

import by.studentstorage.domain.*;

import java.util.List;

public interface StudentStorage {
    public boolean save(Student student);

    public List<Student> getAll();
    public List<Student> getByGroup(String group);
    public List<Student> getByFaculty(String faculty);
    public List<Student> getByCourseNumber(int coursenumber);
    public List<Student> getByEducationForm(String educationForm);

    public String updateGroup(String group, long id);
    public int updateCourse(int course, long id);
    public String updateEducationForm(String form, long id);
    public String updateFaculty(String faculty, long id);

    public boolean contains(Student student);
    }

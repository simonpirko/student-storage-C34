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
    public String updateAddress(String address, long id);
    public String updateNationality(String nat, long id);
    public String updateCountry(String country, long id);
    public int updatePhone(int phone, long id);
    public String updateBirth(String birth, long id);
    public String updateCity(String city, long id);
    public boolean updateWarrior(boolean b, long id);

    public boolean contains(Student student);
    public boolean contains(long id);
    }

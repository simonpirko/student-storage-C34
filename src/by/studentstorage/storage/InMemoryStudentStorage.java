package by.studentstorage.storage;

import by.studentstorage.domain.*;
import by.studentstorage.service.UserService;
import java.util.ArrayList;
import java.util.List;

public class InMemoryStudentStorage implements StudentStorage {
    private UserService userService = new UserService();

    @Override
    public boolean save(Student student) {
        student.setRole(Role.STUDENT);
        return userService.save(student);
    }

    @Override
    public List<Student> getAll() {
        List<User> all = userService.getAll();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getRole().equals(Role.STUDENT)) {
                students.add((Student) all.get(i));
            }
        }
        return students;
    }

    @Override
    public List<Student> getByGroup(String group) {
        List<Student> all = getAll();
        List<Student> byGroup = new ArrayList<>();
        for (Student student : all) {
            if (student.getGroup().equals(group)) {
                byGroup.add(student);
            }
        }
        return byGroup;
    }

    @Override
    public List<Student> getByFaculty(String faculty) {
        List<Student> all = getAll();
        List<Student> byFaculty = new ArrayList<>();
        for (Student student : all) {
            if (student.getFaculty().equals(faculty)) {
                byFaculty.add(student);
            }
        }
        return byFaculty;
    }

    @Override
    public List<Student> getByCourseNumber(int coursenumber) {
        List<Student> all = getAll();
        List<Student> byCourse = new ArrayList<>();
        for (Student student : all) {
            if (student.getCourseNumber() == coursenumber) {
                byCourse.add(student);
            }
        }
        return byCourse;
    }

    @Override
    public List<Student> getByEducationForm(String educationForm) {
        List<Student> all = getAll();
        List<Student> byForm = new ArrayList<>();
        for (Student student : all) {
            if (student.getEducationForm().equals(educationForm)) {
                byForm.add(student);
            }
        }
        return byForm;
    }

    @Override
    public String updateGroup(String group, long id) {
        List<Student> all = getAll();
        for (Student student : all) {
            if (student.getId() == id) {
                student.setGroup(group);
            }
        }
        return group;
    }

    @Override
    public int updateCourse(int course, long id) {
        List<Student> all = getAll();
        for (Student student : all) {
            if (student.getId() == id) {
                student.setCourseNumber(course);
            }
        }
        return course;
    }

    @Override
    public String updateEducationForm(String form, long id) {
        List<Student> all = getAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getId() == id) {
                all.get(i).setEducationForm(form);
            }
        }
        return form;
    }

    @Override
    public String updateFaculty(String faculty, long id) {
        List<Student> all = getAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getId() == id) {
                all.get(i).setFaculty(faculty);
            }
        }
        return faculty;
    }

    @Override
    public boolean contains(Student student) {
        List<Student> all = getAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).equals(student)) {
                return true;
            }
        }
        return false;
    }


}

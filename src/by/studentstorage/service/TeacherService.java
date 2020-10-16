package by.studentstorage.service;

import by.studentstorage.domain.Position;
import by.studentstorage.domain.Rank;
import by.studentstorage.domain.Teacher;
import by.studentstorage.storage.InMemoryTeacherStorage;
import by.studentstorage.storage.InMemoryUserStorage;

import java.util.ArrayList;
import java.util.List;

public class TeacherService {
    private InMemoryTeacherStorage inMemoryTeacherStorage = new InMemoryTeacherStorage();
    InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();
    private UserService userService = new UserService();

    public boolean save(Teacher teacher) {
        boolean result = false;
        if (!inMemoryTeacherStorage.contains(teacher) && userService.getUserById(teacher.getId()) != null) {
            inMemoryTeacherStorage.save(teacher);
            result = true;
        } else if (!inMemoryTeacherStorage.contains(teacher) && userService.getUserById(teacher.getId()) == null) {
            userService.save(teacher);
            inMemoryTeacherStorage.save(teacher);
            result = true;
        }
        return result;
    }

    public Teacher remove(long id) {
        userService.remove(id);
        if (inMemoryTeacherStorage.contains(id)) {
            Teacher removeTeacher = inMemoryTeacherStorage.getTeacherById(id);
            inMemoryTeacherStorage.remove(id);
            return removeTeacher;
        }
        throw new UserNotFoundException();
    }

    public Teacher remove(String login) {
        userService.remove(login);
        if (inMemoryTeacherStorage.contains(login)) {
            Teacher removeTeacher = inMemoryTeacherStorage.getTeacherByLogin(login);
            inMemoryTeacherStorage.remove(login);
            return removeTeacher;
        }
        throw new UserNotFoundException();
    }

    public boolean removeAllByDepartment(String department) {
        for (int i = 0; i < inMemoryTeacherStorage.getAllByDepartment(department).size(); i++) {
            Teacher removeTeacher = inMemoryTeacherStorage.getAllByDepartment(department).get(i);
            long teacherId = removeTeacher.getId();
            inMemoryUserStorage.getAll().remove(userService.getUserById(teacherId));
        }
        inMemoryTeacherStorage.removeAllByDepartment(department);
        return true;

    }

    public String updateTeacherName(String name, long id) {
        if (inMemoryTeacherStorage.contains(id)) {
            inMemoryTeacherStorage.updateName(name, id);
            return name;
        }
        userService.updateName(name, id);
        throw new UserNotFoundException();
    }

    public String updateTeacherSurname(String surname, long id) {
        if (inMemoryTeacherStorage.contains(id)) {
            inMemoryTeacherStorage.updateSurname(surname, id);
            return surname;
        }
        userService.updateSurname(surname, id);
        throw new UserNotFoundException();
    }

    public String updateTeacherPassword(String password, long id) {
        if (inMemoryTeacherStorage.contains(id)) {
            inMemoryTeacherStorage.updatePassword(password, id);
            return password;
        }
        userService.updatePassword(password, id);
        throw new UserNotFoundException();
    }

    public String updateTeacherEmail(String email, long id) {
        if (inMemoryTeacherStorage.contains(id)) {
            inMemoryTeacherStorage.updateEmail(email, id);
            return email;
        }
        userService.updateEmail(email, id);
        throw new UserNotFoundException();
    }

    public Rank updateTeacherRank(Rank rank, long id) {
        if (inMemoryTeacherStorage.contains(id)) {
            inMemoryTeacherStorage.updateRank(rank, id);
            return rank;
        }
        throw new UserNotFoundException();
    }

    public Position updateTeacherPosition(Position position, long id) {
        if (inMemoryTeacherStorage.contains(id)) {
            inMemoryTeacherStorage.updatePosition(position, id);
            return position;
        }
        throw new UserNotFoundException();
    }


    public List<Teacher> getAllTeacher() {
        if (inMemoryTeacherStorage.getAllTeachers().size() != 0) {
            return inMemoryTeacherStorage.getAllTeachers();
        }
        throw new UserNotFoundException();
    }

    public Teacher getTeacherById(long id) {
        Teacher teacherById = null;
        if (inMemoryTeacherStorage.contains(id)) {
            teacherById = inMemoryTeacherStorage.getTeacherById(id);
        }
        return teacherById;
    }

    public Teacher getTeacherByLogin(String login) {
        Teacher teacherByLogin = null;
        if (inMemoryTeacherStorage.contains(login)) {
            teacherByLogin = inMemoryTeacherStorage.getTeacherByLogin(login);
        }
        return teacherByLogin;
    }

    public List<Teacher> getTeachersByDepartment(String department) {
        List<Teacher> teachers =inMemoryTeacherStorage.getAllTeachers();
        List<Teacher> teachersByDepartment = new ArrayList<>();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getDepartment().equals(department)){
                teachersByDepartment.add(teachers.get(i));
            }
        }
        if (teachersByDepartment.size()!= 0){
            return teachersByDepartment;
        }
        throw new UserNotFoundException();
    }

    public List<Teacher> getTeacherByName(String name) {
        List<Teacher> teachers = inMemoryTeacherStorage.getAllTeachers();
        List<Teacher> teachersByNames = new ArrayList<>();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getName().equals(name)) {
                teachersByNames.add(teachers.get(i));
            }
        }
        if (teachersByNames.size() != 0) {
            return teachersByNames;
        }
        throw new UserNotFoundException();
    }

    public List<Teacher> getTeachersByRank(Rank rank) {
        if (inMemoryTeacherStorage.contains(rank)) {
            return inMemoryTeacherStorage.getAllByRank(rank);
        }
        throw new UserNotFoundException();

    }

    public List<Teacher> getTeachersByPosition(Position position) {
        if (inMemoryTeacherStorage.contains(position)) {
            return inMemoryTeacherStorage.getAllByPosition(position);
        }
        throw new UserNotFoundException();
    }
}

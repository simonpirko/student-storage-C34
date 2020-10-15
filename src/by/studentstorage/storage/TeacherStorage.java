package by.studentstorage.storage;

import by.studentstorage.domain.Position;
import by.studentstorage.domain.Rank;
import by.studentstorage.domain.Teacher;

import java.util.List;

public interface TeacherStorage {
    boolean save(Teacher teacher);

    boolean remove(Teacher teacher);
    boolean remove(long id);
    boolean remove(String login);
    boolean removeAllByDepartment(String department);

    Rank updateRank(Rank rank, long id);
    Position updatePosition(Position position, long id);
    String updateDepartment(String department, long id);
    String updateName(String name,long id);
    String updateSurname(String surname, long id);
    String updatePassword(String password,long id);
    String updateEmail(String email, long id);

    List<Teacher> getAllTeachers();
    List<Teacher> getAllByRank(Rank rank);
    List<Teacher> getAllByPosition(Position position);
    List<Teacher> getAllByDepartment(String department);
    Teacher getTeacherById(long id);
    Teacher getTeacherByLogin(String login);
    List<Teacher> getTeacherByName(String name);

    boolean contains(Teacher teacher);
    boolean contains(Rank rank);
    boolean contains(Position position);
    boolean contains(long id);
    boolean contains(String login);
}

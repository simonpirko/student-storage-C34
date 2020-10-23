package by.studentstorage.storage;

import by.studentstorage.domain.Position;
import by.studentstorage.domain.Rank;
import by.studentstorage.domain.Teacher;

import java.util.List;

public interface TeacherStorage {
    boolean save(Teacher teacher);

    Rank updateRank(Rank rank, long id);
    Position updatePosition(Position position, long id);
    String updateDepartment(String department, long id);

    List<Teacher> getAllTeachers();
    List<Teacher> getAllByRank(Rank rank);
    List<Teacher> getAllByPosition(Position position);
    List<Teacher> getAllByDepartment(String department);

    boolean contains(Teacher teacher);
    boolean contains(Rank rank);
    boolean contains(Position position);
}

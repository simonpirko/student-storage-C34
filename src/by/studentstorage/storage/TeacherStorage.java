package by.studentstorage.storage;

import by.studentstorage.domain.Position;
import by.studentstorage.domain.Rank;
import by.studentstorage.domain.Teacher;

import java.util.List;

public interface TeacherStorage {
    boolean save(Teacher teacher);

    List<Teacher> getAll();
    List<Teacher> getAllByRank(Rank rank);
    List<Teacher> getAllByPosition(Position position);
    List<Teacher> getAllByDepartment(String department);

    Rank updateRank(Rank rank, long id);
    Position updatePosition(Position position, long id);
    String updateDepartment(String department, long id);

    public boolean remove(String login);
    public boolean remove(long id);
    public boolean remove(Teacher teacher);

    boolean contains(Teacher teacher);
    boolean contains(long id);
    boolean contains(Rank rank);
    boolean contains(Position position);
}

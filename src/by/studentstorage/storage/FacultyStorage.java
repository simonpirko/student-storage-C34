package by.studentstorage.storage;

import by.studentstorage.domain.Faculty;
import java.util.List;

public interface FacultyStorage {
    boolean save(Faculty faculty);
    Faculty remove(long userID);
    String updateFaculty(Faculty faculty, String cityName);
    List<Faculty> getAll();
    List<Faculty> getAllByFacultyName(String name);
    boolean contains(Faculty faculty);
}

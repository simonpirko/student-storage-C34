package by.studentstorage.storage;

import by.studentstorage.domain.Faculty;
import by.studentstorage.domain.Student;

public class InMemoryFacultyStorage implements FacultyStorage {
    /*private InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    public boolean save(Student student, String facultyName) {
        if (inMemoryUserStorage.contains(student)){
            student.setFaculty(new Faculty(facultyName));
            return true;
        }
        return false;
    }

    @Override
    public Faculty remove(Student student) {
        Faculty faculty = student.getFaculty();
        if (inMemoryUserStorage.contains(student)){
            student.setFaculty(null);
        }
        return faculty;
    }

    @Override
    public String updateFaculty(String facultyName, Student student) {
        if (inMemoryUserStorage.contains(student)){
            Faculty faculty = student.getFaculty();
            faculty.setFacultyName(facultyName);

        }
        return facultyName;
    }

    @Override
    public List<Faculty> getAll() {
        return faculties;
    }

    @Override
    public List<Faculty> getAllByFacultyName(String name) {
        List<Faculty> facultiesList = new ArrayList<>();
        for (int i = 0; i < faculties.size(); i++) {
            if (faculties.get(i).getFacultyName().equals(name)){
                facultiesList.add(faculties.get(i));
            }
        }
        return facultiesList;
    }

    @Override
    public boolean contains(Faculty faculty) {
        for (int i = 0; i < faculties.size(); i++) {
            if (faculties.get(i).equals(faculty)){
                return true;
            }
        }
        return false;
    }
 */
}

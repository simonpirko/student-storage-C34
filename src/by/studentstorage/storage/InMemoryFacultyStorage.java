package by.studentstorage.storage;

import by.studentstorage.domain.Faculty;
import java.util.ArrayList;
import java.util.List;

public class InMemoryFacultyStorage implements FacultyStorage {
    private List<Faculty> faculties = new ArrayList<>();

    @Override
    public boolean save(Faculty faculty) {
        return faculties.add(faculty);
    }

    @Override
    public Faculty remove(long userID) {
        Faculty faculty = null;
        for (int i = 0; i <faculties.size() ; i++) {
            if (faculties.get(i).getUserID() == userID){
                faculty = faculties.get(i);
                faculties.remove(i);
            }
        }
        return faculty;
    }

    @Override
    public String updateFaculty(Faculty faculty, String facultyName) {
        faculty.setFaculty(facultyName);
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
            if (faculties.get(i).getFaculty().equals(name)){
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
}

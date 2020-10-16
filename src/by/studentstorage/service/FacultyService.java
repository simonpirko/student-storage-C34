package by.studentstorage.service;

import by.studentstorage.domain.Faculty;
import by.studentstorage.domain.Student;
import by.studentstorage.domain.User;
import by.studentstorage.storage.InMemoryFacultyStorage;
import java.util.ArrayList;
import java.util.List;


public class FacultyService {
   /*private InMemoryFacultyStorage inMemoryFacultyStorage = new InMemoryFacultyStorage();

    public boolean saveFaculty(Student student, String facName){
        return inMemoryFacultyStorage.save(student, facName);
    }

    public Faculty remove(Student student){
        Faculty removedFaculty = inMemoryFacultyStorage.remove(student);
        if (removedFaculty == null){
            throw new FacultyNotFoundException();
        }
        return removedFaculty;
    }

    public String updateFaculty(Faculty faculty, String facultyName, User user){
        if (inMemoryFacultyStorage.contains(faculty)){
            return inMemoryFacultyStorage.updateFaculty(faculty, facultyName, user);
        }
        throw new FacultyNotFoundException();
    }

    public List<Faculty> getAll(){
        if (inMemoryFacultyStorage.getAll().size() != 0){
            return inMemoryFacultyStorage.getAll();
        }
        throw new FacultyNotFoundException();
    }

    public List<Faculty> getByFacultyName(String name){
        List<Faculty> all = getAll();
        if (all.size() == 0){
            throw new FacultyNotFoundException();
        }
        List<Faculty> byName = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getFacultyName().equals(name)){
                byName.add(all.get(i));
            }
        }
        return byName;
    }
    */
}


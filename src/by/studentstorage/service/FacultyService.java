package by.studentstorage.service;

import by.studentstorage.domain.Faculty;
import by.studentstorage.storage.InMemoryFacultyStorage;
import java.util.ArrayList;
import java.util.List;


public class FacultyService {
    private InMemoryFacultyStorage inMemoryFacultyStorage = new InMemoryFacultyStorage();

    public boolean saveFaculty(Faculty faculty){
        return inMemoryFacultyStorage.save(faculty);
    }

    public Faculty remove(long userID){
        Faculty removedFaculty = inMemoryFacultyStorage.remove(userID);
        if (removedFaculty == null){
            throw new FacultyNotFoundException();
        }
        return removedFaculty;
    }

    public String updateFaculty(Faculty faculty, String facultyName){
        if (inMemoryFacultyStorage.contains(faculty)){
            return inMemoryFacultyStorage.updateFaculty(faculty, facultyName);
        }
        return facultyName;
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
            if (all.get(i).getFaculty().equals(name)){
                byName.add(all.get(i));
            }
        }
        return byName;
    }
}


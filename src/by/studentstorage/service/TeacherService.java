package by.studentstorage.service;

import by.studentstorage.domain.Position;
import by.studentstorage.domain.Rank;
import by.studentstorage.domain.Teacher;
import by.studentstorage.storage.InMemoryTeacherStorage;
import java.util.List;

public class TeacherService {
    private InMemoryTeacherStorage inMemoryTeacherStorage = new InMemoryTeacherStorage();

    public boolean save(Teacher teacher){
        if (!inMemoryTeacherStorage.contains(teacher)) {
            return inMemoryTeacherStorage.save(teacher);
        }
        throw new TeacherAlreadyExist();
    }

    public Rank updateRank(Rank rank, Teacher teacher) {
        if (inMemoryTeacherStorage.contains(teacher)){
            return inMemoryTeacherStorage.updateRank(rank,teacher.getId());
        }
        throw new TeacherNotFoundException();
    }

    public Position position(Position position, Teacher teacher) {
        if (!inMemoryTeacherStorage.contains(teacher)){
            throw new TeacherNotFoundException();
        }
        return inMemoryTeacherStorage.updatePosition(position,teacher.getId());
    }

    public List<Teacher> getAll(){
        if (inMemoryTeacherStorage.getAll().size() != 0){
            return inMemoryTeacherStorage.getAll();
        }
        throw new StudentNotFoudException();
    }

    public List<Teacher> getByGroup(Rank rank) {
        List<Teacher> byRank = inMemoryTeacherStorage.getAllByRank(rank);
        if (byRank == null){
            throw new TeacherNotFoundException();
        }
        return byRank;
    }

    public List<Teacher> getByPositon(Position position) {
        List<Teacher> byPosition = inMemoryTeacherStorage.getAllByPosition(position);
        if (byPosition == null){
            throw new TeacherNotFoundException();
        }
        return byPosition;
    }

    public List<Teacher> getByDepartment(String department) {
        List<Teacher> byDepartment = inMemoryTeacherStorage.getAllByDepartment(department);
        if (byDepartment == null){
            throw new TeacherNotFoundException();
        }
        return byDepartment;
    }

    public Position  updatePosition (Position position, Teacher teacher) {
        if (!inMemoryTeacherStorage.contains(teacher)){
            throw new TeacherNotFoundException();
        }
        return inMemoryTeacherStorage.updatePosition(position,teacher.getId());
    }

    public String updateDepartment(String department, Teacher teacher) {
        if (!inMemoryTeacherStorage.contains(teacher)){
            throw new StudentNotFoudException();
        }
        return inMemoryTeacherStorage.updateDepartment(department,teacher.getId());
    }
}

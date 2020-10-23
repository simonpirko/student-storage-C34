package by.studentstorage.storage;

import by.studentstorage.domain.Position;
import by.studentstorage.domain.Rank;
import by.studentstorage.domain.Teacher;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTeacherStorage implements TeacherStorage {
    private List<Teacher> teachers = new ArrayList<>();
    InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    public boolean save(Teacher teacher) {
        boolean resultUserSave = inMemoryUserStorage.save(teacher);
        boolean resultTeacherSave = teachers.add(teacher);
        return resultUserSave && resultTeacherSave;
    }

    @Override
    public boolean remove(Teacher teacher) {
        long removeTeacherId = teacher.getId();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == removeTeacherId) {
                teachers.remove(i);
            }
        }
        boolean resultTeacherRemove = teachers.contains(teacher);
        boolean resultUserRemove = inMemoryUserStorage.contains(inMemoryUserStorage.remove(removeTeacherId));
        return !resultTeacherRemove && !resultUserRemove;
    }

    @Override
    public boolean remove(long id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id){
                teachers.remove(i);
            }
        }
        boolean resultTeacherRemove = teachers.contains(id);
        return !resultTeacherRemove;
    }

    @Override
    public boolean remove(String login) {
        for (int i = 0; i <teachers.size() ; i++) {
            if (teachers.get(i).getLogin().equals(login)){
                teachers.remove(i);
            }
        }
        boolean resultTeacherRemove = teachers.contains(login);
        return !resultTeacherRemove;
    }

    @Override
    public Rank updateRank(Rank rank, long id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.get(i).setRank(rank);
            }
        }
        return rank;
    }

    @Override
    public Position updatePosition(Position position, long id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.get(i).setPosition(position);
            }
        }
        return position;
    }

    @Override
    public String updateDepartment(String department, long id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.get(i).setDepartment(department);
            }
        }
        return department;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teachers;
    }

    @Override
    public List<Teacher> getAllByRank(Rank rank) {
        List<Teacher> allByRank = new ArrayList<>();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getRank().equals(rank)) {
                allByRank.add(teachers.get(i));
            }
        }
        return allByRank;
    }

    @Override
    public List<Teacher> getAllByPosition(Position position) {
        List<Teacher> allByPosition = new ArrayList<>();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getPosition().equals(position)) {
                allByPosition.add(teachers.get(i));
            }
        }
        return allByPosition;
    }

    @Override
    public List<Teacher> getAllByDepartment(String department) {
        List<Teacher> allByDepartment = new ArrayList<>();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getDepartment().equals(department)) {
                allByDepartment.add(teachers.get(i));
            }
        }
        return allByDepartment;
    }

    @Override
    public boolean contains(Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).equals(teacher)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Rank rank) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getRank().equals(rank)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Position position) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }
}

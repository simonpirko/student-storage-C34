package by.studentstorage.storage;

import by.studentstorage.domain.Position;
import by.studentstorage.domain.Rank;
import by.studentstorage.domain.Teacher;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTeacherStorage implements TeacherStorage {
    private static final List<Teacher> teachers = new ArrayList<>();
    InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    public boolean save(Teacher teacher) {
        return teachers.add(teacher);
       
    }

    @Override
    public boolean remove(Teacher teacher) {
        long removeTeacherId = teacher.getId();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == removeTeacherId) {
                teachers.remove(i);
            }
        }
        return true;
    }

    @Override
    public boolean remove(long id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id){
                teachers.remove(i);
            }
        }
        return true;
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
    public boolean removeAllByDepartment(String department) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getDepartment().equals(department)){
                teachers.remove(i);
            }
        }
        return true;
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
    public String updateName(String name, long id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id){
                teachers.get(i).setName(name);
            }
        }
        return name;
    }

    @Override
    public String updateSurname(String surname, long id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id){
                teachers.get(i).setSurname(surname);
            }
        }
        return surname;
    }

    @Override
    public String updatePassword(String password, long id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id){
                teachers.get(i).setPassword(password);
            }
        }
        return password;
    }

    @Override
    public String updateEmail(String email, long id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id){
                teachers.get(i).setEmail(email);
            }
        }
        return email;
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
    public Teacher getTeacherById(long id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId()== id){
                return teachers.get(i);
            }
        }
        return null;
    }

    @Override
    public Teacher getTeacherByLogin(String login) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getLogin().equals(login)){
                return teachers.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Teacher> getTeacherByName(String name) {
        List<Teacher> allTeacherByName = new ArrayList<>();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getName().equals(name)){
                allTeacherByName.add(teachers.get(i));
            }
        }
        return allTeacherByName;
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

    @Override
    public boolean contains(long id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId()==id){
                return  true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(String login) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getLogin().equals(login)){
                return  true;
            }
        }
        return false;
    }
}

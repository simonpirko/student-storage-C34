package by.studentstorage.storage;

import by.studentstorage.domain.*;
import by.studentstorage.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTeacherStorage implements TeacherStorage {
    private UserService userService = new UserService();

    @Override
    public boolean save(Teacher teacher) {
        teacher.setRole(Role.TEACHER);
        return userService.save(teacher);
    }

    @Override
    public Rank updateRank(Rank rank, long id) {
        List<Teacher> all = getAllTeachers();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getId() == id) {
                all.get(i).setRank(rank);
            }
        }
        return rank;
    }

    @Override
    public Position updatePosition(Position position, long id) {
        List<Teacher> all = getAllTeachers();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getId() == id) {
                all.get(i).setPosition(position);
            }
        }
        return position;
    }

    @Override
    public String updateDepartment(String department, long id) {
        List<Teacher> all = getAllTeachers();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getId() == id) {
                all.get(i).setDepartment(department);
            }
        }
        return department;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<User> all = userService.getAll();
        List<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getRole().equals(Role.TEACHER)) {
                teachers.add((Teacher) all.get(i));
            }
        }
        return teachers;
    }

    @Override
    public List<Teacher> getAllByRank(Rank rank) {
        List<Teacher> all = getAllTeachers();
        List<Teacher> byRank = new ArrayList<>();
        for (Teacher teacher : all) {
            if (teacher.getRank().equals(rank)) {
                byRank.add(teacher);
            }
        }
        return byRank;
    }

    @Override
    public List<Teacher> getAllByPosition(Position position) {
        List<Teacher> all = getAllTeachers();
        List<Teacher> byPosition = new ArrayList<>();
        for (Teacher teacher : all) {
            if (teacher.getPosition().equals(position)) {
                byPosition.add(teacher);
            }
        }
        return byPosition;
    }

    @Override
    public List<Teacher> getAllByDepartment(String department) {
        List<Teacher> all = getAllTeachers();
        List<Teacher> byDepartment = new ArrayList<>();
        for (Teacher teacher : all) {
            if (teacher.getDepartment().equals(department)) {
                byDepartment.add(teacher);
            }
        }
        return byDepartment;
    }

    @Override
    public boolean contains(Teacher teacher) {
        List<Teacher> all = getAllTeachers();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).equals(teacher)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Rank rank) {
        List<Teacher> all = getAllTeachers();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getRank().equals(rank)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Position position) {
        List<Teacher> all = getAllTeachers();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }
}

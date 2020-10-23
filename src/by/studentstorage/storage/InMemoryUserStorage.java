package by.studentstorage.storage;

import by.studentstorage.domain.Role;
import by.studentstorage.domain.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserStorage implements UserStorage {
<<<<<<< HEAD

    private static List<User> users = new ArrayList<>();
=======
    private static final List<User> users = new ArrayList<>();
>>>>>>> Adding methods: *updateName(Surname,Password,Email) *getTeacherById(Login,Name) *contains(long id),(String login) Adding TeacerServise class and implementing it.
    @Override
    public boolean save(User user) {
        if (users.add(user)) {
            return true;
        }
        return false;
    }

    @Override
    public User remove(long id) {
        User user = null;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id){
                user = users.get(i);
                users.remove(i);
            }
        }
        return user;
    }

    @Override
    public User remove(String login) {
        User user = null;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login)){
                user = users.get(i);
                users.remove(i);
            }
        }
        return user;
    }

    @Override
    public String updateName(String name, long id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id){
                users.get(i).setName(name);
            }
        }
        return name;
    }

    @Override
    public String updateSurname(String surname, long id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id){
                users.get(i).setSurname(surname);
            }
        }
        return surname;
    }

    @Override
    public String updatePassword(String pass, long id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id){
                users.get(i).setPassword(pass);
            }
        }
        return pass;
    }

    @Override
    public String updateEmail(String email, long id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id){
                users.get(i).setEmail(email);
            }
        }
        return email;
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public List<User> getAllByName(String name) {
        List<User> byName = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)){
                byName.add(users.get(i));
            }
        }
        return byName;
    }

    @Override
    public List<User> getAllByRole(Role role) {
        List<User> byRole = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getRole().equals(role)){
                byRole.add(users.get(i));
            }
        }
        return byRole;
    }

    @Override
    public User getUserById(long id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id){
                return users.get(i);
            }
        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login)){
                return users.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean contains(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(user)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(long id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(String login) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Role role) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getRole().equals(role)){
                return true;
            }
        }
        return false;
    }
}

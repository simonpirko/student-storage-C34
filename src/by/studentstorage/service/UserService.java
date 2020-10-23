package by.studentstorage.service;

import by.studentstorage.console.ConsoleWriter;
import by.studentstorage.domain.Role;
import by.studentstorage.domain.User;
import by.studentstorage.storage.InMemoryUserStorage;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();
    private ConsoleWriter writer = new ConsoleWriter();

    public boolean save(User user) throws UserNotFoundException {
        if (inMemoryUserStorage.contains(user)) {
            return false;
        } else {
            inMemoryUserStorage.save(user);
        }
        return true;
    }

    public User remove(long id) throws UserNotFoundException {
        if (inMemoryUserStorage.contains(id)) {
            User user = inMemoryUserStorage.getUserById(id);
            inMemoryUserStorage.remove(id);
            return user;
        }
        throw new UserNotFoundException();
    }

    public User remove(String login) throws UserNotFoundException {
        if (inMemoryUserStorage.contains(login)) {
            User user = inMemoryUserStorage.getUserByLogin(login);
            inMemoryUserStorage.remove(login);
            return user;
        }
        throw new UserNotFoundException();
    }

    public String updateName(String name, long id) throws UserNotFoundException {
        if (inMemoryUserStorage.contains(id)) {
            inMemoryUserStorage.updateName(name, id);
            return name;
        }
        throw new UserNotFoundException();
    }

    public String updateSurname(String surname, long id) throws UserNotFoundException {
        if (inMemoryUserStorage.contains(id)) {
            inMemoryUserStorage.updateSurname(surname, id);
            return surname;
        }
        throw new UserNotFoundException();
    }

    public String updatePassword(String pass, long id) throws UserNotFoundException{
        if (inMemoryUserStorage.contains(id)) {
            inMemoryUserStorage.updatePassword(pass, id);
            return "Password changed successfully";
        }
        throw new UserNotFoundException();
    }

    public String updateEmail(String email, long id) throws UserNotFoundException {
        if (inMemoryUserStorage.contains(id)) {
            inMemoryUserStorage.updateEmail(email, id);
            return email;
        }
        throw new UserNotFoundException() ;
    }

    public List<User> getAll(){
//        if (inMemoryUserStorage.getAll().size() != 0){
            return inMemoryUserStorage.getAll();
//        }
//        throw new UserNotFoundException();
    }

    public List<User> getAllByName(String name) throws UserNotFoundException {
        List<User> users = inMemoryUserStorage.getAll();
        List<User> byNames = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name)){
                byNames.add(users.get(i));
            }
        }
        if (byNames.size() != 0){
            return byNames;
        }
        throw new UserNotFoundException();
    }

    public List<User> getAllByRole(Role role) throws UserNotFoundException {
        if (inMemoryUserStorage.contains(role)){
            return inMemoryUserStorage.getAllByRole(role);
        }
        throw new UserNotFoundException();
    }

    public User getUserById(long id) throws UserNotFoundException {
        User user = null;
        if (inMemoryUserStorage.contains(id)){
            user = inMemoryUserStorage.getUserById(id);
        }
        return user;
    }

    public User getUserByLogin(String login)  {
        if (inMemoryUserStorage.contains(login)){
            return inMemoryUserStorage.getUserByLogin(login);
        }
        return null;
    }
}
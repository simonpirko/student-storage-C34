package by.studentstorage.storage;

import by.studentstorage.domain.Role;
import by.studentstorage.domain.User;
import java.util.List;

public interface UserStorage {
    boolean save(User user);

    User remove(long id);
    User remove(String login);

    String updateName(String name, long id);
    String updateSurname(String surname, long id);
    String updatePassword(String pass, long id);
    String updateEmail(String email, long id);

    List<User> getAll();
    List<User> getAllByName(String name);
    List<User> getAllByRole(Role role);
    User getUserById(long id);
    User getUserByLogin(String login);

    boolean contains(User user);
    boolean contains(long id);
    boolean contains(String login);
}

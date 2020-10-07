package by.studentstorage.domain;

public class Session {
    private User currentUser;
    private Role role;

    public Session(User currentUser, Role role) {
        this.currentUser = currentUser;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Session(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}


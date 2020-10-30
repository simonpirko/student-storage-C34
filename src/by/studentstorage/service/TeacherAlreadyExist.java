package by.studentstorage.service;

public class TeacherAlreadyExist extends RuntimeException {
    public TeacherAlreadyExist() {
        super();
    }

    public TeacherAlreadyExist(String message) {
        super(message);
    }

    public TeacherAlreadyExist(String message, Throwable cause) {
        super(message, cause);
    }

    public TeacherAlreadyExist(Throwable cause) {
        super(cause);
    }

    protected TeacherAlreadyExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

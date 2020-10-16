package by.studentstorage.service;

public class StudentNotFoudException extends RuntimeException {
    public StudentNotFoudException() {
        super();
    }

    public StudentNotFoudException(String message) {
        super(message);
    }

    public StudentNotFoudException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoudException(Throwable cause) {
        super(cause);
    }

    protected StudentNotFoudException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

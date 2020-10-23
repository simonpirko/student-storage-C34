package by.studentstorage.service;

public class LessonAlreadyExcist extends  RuntimeException {
    public LessonAlreadyExcist() {
        super();
    }

    public LessonAlreadyExcist(String message) {
        super(message);
    }

    public LessonAlreadyExcist(String message, Throwable cause) {
        super(message, cause);
    }

    public LessonAlreadyExcist(Throwable cause) {
        super(cause);
    }

    protected LessonAlreadyExcist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

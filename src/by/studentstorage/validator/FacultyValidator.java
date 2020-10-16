package by.studentstorage.validator;

public class FacultyValidator {
    public static boolean validFacultyName(String faculty){
        return faculty.length() > 4;
    }
}

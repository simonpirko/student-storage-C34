package by.studentstorage.validator;

public class FacultyValidator {
    public static boolean ValidFacultyName(String faculty){
        return faculty.length() > 4;
    }
}

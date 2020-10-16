package by.studentstorage.action;

import by.studentstorage.console.ConsoleApplication;
import by.studentstorage.console.ConsoleReader;
import by.studentstorage.console.ConsoleWriter;
import by.studentstorage.domain.Student;
import by.studentstorage.service.StudentService;
import by.studentstorage.validator.CourseValidator;
import by.studentstorage.validator.FacultyValidator;

public class StudentAction {
    private StudentService studentService = new StudentService();
    private ConsoleReader consoleReader = new ConsoleReader();
    private ConsoleWriter consoleWriter = new ConsoleWriter();

    public String changeCourse(){
        consoleWriter.writeString("Please enter your course");
        int course = consoleReader.readInt();
        Student student = (Student) ConsoleApplication.session.getCurrentUser();
        if (CourseValidator.validCourse(course)){
            studentService.updateCourse(course, student);
        }else{
            while (!CourseValidator.validCourse(course)){
                consoleWriter.writeString("Invalid course number! Try again");
                course = consoleReader.readInt();
            }
            ConsoleApplication.session.setCurrentUser(student) ;
        }
        return "You have changed your course number to " + course;
    }
    public String changeFaculty(){
        consoleWriter.writeString("Please enter your faculty");
        String faculty = consoleReader.readString();
        Student student = (Student) ConsoleApplication.session.getCurrentUser();
        if (FacultyValidator.validFacultyName(faculty)){
            studentService.updateFaculty(faculty, student);
        }else{
            while (!FacultyValidator.validFacultyName(faculty)){
                consoleWriter.writeString("Invalid faculty! Try again");
                faculty = consoleReader.readString();
            }
            ConsoleApplication.session.setCurrentUser(student) ;
        }
        return "You have changed your faculty to " + faculty;
    }
}

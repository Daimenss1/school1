package ru.hogwartS.school.Service;

import ru.hogwartS.school.Model.Student;

import java.util.Collection;

public interface StudentService {

    Student createStudent(Student student);

    Student readStudent(long idRead);

    Student updateStudent(Student student);

    Student deleteStudent(long idDelete);

    Collection<Student> getStudentByAge(int ageFilter);

    Collection<Student> allStudent();
}
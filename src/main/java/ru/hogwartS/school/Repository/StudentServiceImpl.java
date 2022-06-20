package ru.hogwartS.school.Repository;

import org.springframework.stereotype.Service;
import ru.hogwartS.school.Model.Faculty;
import ru.hogwartS.school.Model.Student;
import ru.hogwartS.school.Service.StudentService;

import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student studentCreate) {
        return studentRepository.save(studentCreate);
    }

    @Override
    public Student readStudent(long idRead) {
        return studentRepository.findById(idRead).orElseThrow();
    }
    @Override
    public Student updateStudent(Student studentUpdate) {
        return studentRepository.save(studentUpdate);
    }
    @Override
    public Student deleteStudent(long idDelete) {
        studentRepository.deleteById(idDelete);
        return null;
    }

    @Override
    public Collection<Student> getStudentByAge(int ageFilter) {
        return studentRepository.findAll();
    }
    @Override
    public Collection<Student> findByAgeBetween(int ageMin, int ageMax) {
        return studentRepository.findAllByAgeBetween(ageMin,ageMax);
    }


    @Override
    public Collection<Student> allStudent() {
        return studentRepository.findAll();
    }


    @Override
    public Collection<Student> findByFacultyId(Long facultyID) {
        return studentRepository.findStudentByFacultyId(facultyID);
    }

    public Faculty findFacultyOfStudent(Long studentId) {
        Student currentStudent = studentRepository.getById(studentId);
        return currentStudent.getFaculty();
    }
}


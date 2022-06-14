package ru.hogwartS.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwartS.school.Model.Student;
import ru.hogwartS.school.Repository.StudentRepository;

import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student studentCreate) {
        return studentRepository.save(studentCreate);
    }

    @Override
    public Student readStudent(long idRead) {
        return studentRepository.findById(idRead).get();
    }

    @Override
    public Student updateStudent(Student studentUpdate) {
        ;
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
    public Collection<Student> allStudent() {
        return studentRepository.findAll();
    }
}

package ru.hogwartS.school.Repository;

import org.springframework.stereotype.Service;
import ru.hogwartS.school.Model.Faculty;
import ru.hogwartS.school.Service.FacultyService;

import java.util.Collection;

@Service
    public class FacultyServiceImpl implements FacultyService {

        private FacultyRepository facultyRepository;

        public FacultyServiceImpl(FacultyRepository facultyRepository) {
            this.facultyRepository = facultyRepository;
        }


        @Override
        public Faculty createFaculty(Faculty faculty) {
            return facultyRepository.save(faculty);
        }

        @Override
        public Faculty readFaculty(long idRead) {
            return facultyRepository.findById(idRead).orElseThrow();
        }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty deleteFaculty(long idDelete) {
        facultyRepository.deleteById(idDelete);
        return null;
    }

    @Override
    public Collection<Faculty> getFacultyByColor(String colorFilter) {
        return facultyRepository.findAll();
    }

    @Override
    public Collection<Faculty> allFaculty() {
        return facultyRepository.findAll();
    }
}


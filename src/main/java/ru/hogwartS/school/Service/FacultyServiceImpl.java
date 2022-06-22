package ru.hogwartS.school.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwartS.school.Model.Faculty;
import ru.hogwartS.school.Repository.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyServiceImpl implements FacultyService{

    Logger logger = LoggerFactory.getLogger(FacultyService.class);

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
        logger.info("Was invoked method for creating faculty");
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty readFaculty(long idRead) {
        logger.info("Was invoked method for finding faculty by id");
        return facultyRepository.findById(idRead).get();
    }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        logger.info("Was invoked method for updating faculty");
        return facultyRepository.save(faculty);
    }

    @Override
    public void deleteFaculty(long idDelete) {
        logger.info("Was invoked method for deleting faculty");
        facultyRepository.deleteById(idDelete);
    }

    @Override
    public Collection<Faculty> getFacultyByColor(String colorFilter) {
        logger.info("Was invoked method for finding faculties by color");
        return facultyRepository.findAllByColor(colorFilter);
    }

    @Override
    public Collection<Faculty> findFacultyByColorAndName(String colorFilter, String nameFilter) {
        logger.info("Was invoked method for finding faculties by name or color (ignoring case)");
        return facultyRepository.findFacultiesByNameIgnoreCaseOrColorIgnoreCase(nameFilter,colorFilter);
    }

    @Override
    public Collection<Faculty> allFaculty() {
        logger.info("Was invoked method for finding all faculties");
        return facultyRepository.findAll();
    }

}
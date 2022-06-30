package ru.hogwartS.school.Service;

import ru.hogwartS.school.Model.Faculty;

import java.util.Collection;

public interface FacultyService {

    Faculty createFaculty(Faculty faculty);

    Faculty readFaculty(long idRead);

    Faculty updateFaculty(Faculty faculty);

    void deleteFaculty(long idDelete);

    Collection<Faculty> getFacultyByColor(String colorFilter);

    Collection<Faculty> findFacultyByColorAndName(String colorFilter, String nameFilter);

    Collection<Faculty> allFaculty();

}
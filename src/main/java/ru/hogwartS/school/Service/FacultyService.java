package ru.hogwartS.school.Service;

import ru.hogwartS.school.Model.Faculty;

import java.util.Collection;

public interface FacultyService {

    Faculty createFaculty(Faculty faculty);

    Faculty readFaculty(long idRead);

    Faculty updateFaculty(Faculty faculty);

    Faculty deleteFaculty(long idDelete);

    Collection<Faculty> getFacultyByColor(String colorFilter);

    Collection<Faculty> allFaculty();

}
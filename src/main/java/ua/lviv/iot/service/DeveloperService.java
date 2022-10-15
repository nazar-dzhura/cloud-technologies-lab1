package ua.lviv.iot.service;

import ua.lviv.iot.model.Developer;

import java.util.List;

public interface DeveloperService {

    Developer createDeveloper(Developer developer);

    List<Developer> getAllDevelopers();

    Developer getDeveloperById(Integer id);

    Developer updateDeveloper(Developer developer);

    Developer deleteDeveloperById(Integer id);
}

package ua.lviv.iot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.Developer;

@Repository
public interface DeveloperDao extends JpaRepository<Developer, Integer> {
}

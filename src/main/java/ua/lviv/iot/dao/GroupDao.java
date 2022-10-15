package ua.lviv.iot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.Group;

@Repository
public interface GroupDao extends JpaRepository<Group, Integer> {
}

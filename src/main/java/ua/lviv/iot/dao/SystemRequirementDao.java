package ua.lviv.iot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.SystemRequirement;

@Repository
public interface SystemRequirementDao extends JpaRepository<SystemRequirement, Integer> {
}

package ua.lviv.iot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.Status;

@Repository
public interface StatusDao extends JpaRepository<Status, Integer> {
}

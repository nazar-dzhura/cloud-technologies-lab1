package ua.lviv.iot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
}

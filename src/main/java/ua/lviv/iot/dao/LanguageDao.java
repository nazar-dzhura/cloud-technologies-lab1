package ua.lviv.iot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.Language;

@Repository
public interface LanguageDao extends JpaRepository<Language, Integer> {
}

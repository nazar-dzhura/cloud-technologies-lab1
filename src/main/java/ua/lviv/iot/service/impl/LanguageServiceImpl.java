package ua.lviv.iot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.LanguageDao;
import ua.lviv.iot.exception.ForeignKeyConstraintException;
import ua.lviv.iot.exception.NoDataFoundException;
import ua.lviv.iot.model.Language;
import ua.lviv.iot.service.LanguageService;

import java.util.List;

@Service
@AllArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageDao languageDao;

    @Override
    public Language createLanguage(Language language) {
        return languageDao.save(language);
    }

    @Override
    public List<Language> getAllLanguages() { return languageDao.findAll(); }

    @Override
    public Language getLanguageById(Integer id) {
        return languageDao.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Entity with id: " + id + " not found"));
    }

    @Override
    public Language updateLanguage(Language language) {
        getLanguageById(language.getId()); // throws exception if entity doesn't exist
        return languageDao.save(language);
    }

    /**
     * Deletes only if there is no foreign key associations
     */
    @Override
    public Language deleteLanguageById(Integer id) {
        Language oldLanguage = getLanguageById(id); // throws runtime exception if not found by id
        try {
            languageDao.deleteById(id);
        } catch (Exception e) {
            throw new ForeignKeyConstraintException("Unable to delete this entity because its id is used in child table");
        }
        return oldLanguage;
    }
}

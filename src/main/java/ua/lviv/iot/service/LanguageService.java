package ua.lviv.iot.service;

import ua.lviv.iot.model.Language;

import java.util.List;

public interface LanguageService {

    Language createLanguage(Language language);

    List<Language> getAllLanguages();

    Language getLanguageById(Integer id);

    Language updateLanguage(Language language);

    Language deleteLanguageById(Integer id);
}

package ua.lviv.iot.mappers;

import ua.lviv.iot.dto.language.LanguageDto;
import ua.lviv.iot.model.Language;


public class LanguageMapper {

    private LanguageMapper() {
    }

    public static LanguageDto mapLanguageToLanguageDto(Language language) {
        return new LanguageDto(
                language.getId(),
                language.getLanguage()
        );
    }
}
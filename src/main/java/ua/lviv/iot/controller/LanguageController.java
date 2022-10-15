package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.dto.language.CreateUpdateLanguageDto;
import ua.lviv.iot.dto.language.LanguageDto;
import ua.lviv.iot.mappers.LanguageMapper;
import ua.lviv.iot.model.Language;
import ua.lviv.iot.service.LanguageService;

import static ua.lviv.iot.mappers.LanguageMapper.mapLanguageToLanguageDto;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@AllArgsConstructor
@RequestMapping("/api/language")
public class LanguageController {

    private final LanguageService languageService;

    @PostMapping
    LanguageDto createLanguage(final @Valid @RequestBody Language language) {
        return mapLanguageToLanguageDto(languageService.createLanguage(language));
    }

    @GetMapping
    List<LanguageDto> getAllLanguages() {
        return languageService.getAllLanguages().stream()
                .map(LanguageMapper::mapLanguageToLanguageDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    LanguageDto getLanguageById(final @PathVariable("id") Integer id) {
        return mapLanguageToLanguageDto(languageService.getLanguageById(id));
    }

    @PutMapping
    LanguageDto updateLanguage(final @Valid @RequestBody Language language) {
        return mapLanguageToLanguageDto(languageService.updateLanguage(language));
    }

    @DeleteMapping("/{id}")
    LanguageDto deleteLanguageById(final @PathVariable("id") Integer id) {
        return mapLanguageToLanguageDto(languageService.deleteLanguageById(id));
    }
}

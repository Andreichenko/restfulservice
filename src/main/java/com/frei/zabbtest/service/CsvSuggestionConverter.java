package com.frei.zabbtest.service;

import com.frei.zabbtest.domain.Suggestion;
import com.frei.zabbtest.dto.CsvSuggestionDto;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 *   Class Converter from Json data format to CSV
 *
 *
 *
 *
 * by Andreichenko
 */


@Log4j2
@Component
public class CsvSuggestionConverter {

    /**
     *
     * @param input добавленные данные в метод конвертора
     * @return    возвращает список данных
     */

    public CsvSuggestionDto toCsvSuggestiondto(@NonNull Suggestion input){
        CsvSuggestionDto dto = new CsvSuggestionDto();
        dto.setId(input.getId());
        dto.setName(input.getName());
        dto.setType(input.getType());
        dto.setLatitude(input.getGeoPositon().getLatitude());
        dto.setLongtitude(input.getGeoPositon().getLongtitude());
        return dto;
    }


}

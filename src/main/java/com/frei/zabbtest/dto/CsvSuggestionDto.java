package com.frei.zabbtest.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class Object DTO for api
 *
 *
 *
 *
 * by Andreichenko
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CsvSuggestionDto {
    @JsonProperty("_id")
    private long id;
    private String name;
    private String type;
    private double longtitude;
    private double latitude;

}

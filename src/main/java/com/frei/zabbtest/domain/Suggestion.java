package com.frei.zabbtest.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 *
 *  class with Objects
 *
 *
 * by Andreichenko
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Suggestion {

    @JsonProperty("_id")
    private long id;
    private String key;
    private String name;
    private String fullName;
    @JsonProperty("_iata_airport_code")
    private String iataAirportCode;
    private String type;
    private String country;
    @JsonProperty("_geo_position")
    private GeoPositon geoPositon;
    private long locationId;
    private boolean inEurope;
    private int countryId;
    private String countryCode;
    private boolean coreCountry;
    private long distance;
    private Map<String, String> names;
    private Map<String, String> alternativeNames;
}

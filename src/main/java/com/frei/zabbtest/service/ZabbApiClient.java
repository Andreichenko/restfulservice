package com.frei.zabbtest.service;


import com.frei.zabbtest.domain.Suggestion;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 *
 *  Component class for Zabb api
 *
 *
 * by Andreichenko
 */

@Log4j2
@Component
public class ZabbApiClient {

    @Value("${application.suggestionUrlTemplate}")
    private String suggestionUrl;

    @Autowired
    private RestTemplate restTemplate;

    public List<Suggestion> findSuggestionByCity(@NonNull String city){
        ResponseEntity<Suggestion[]> response =
                restTemplate.getForEntity(suggestionUrl, Suggestion[].class, ImmutableMap.of("city", city));

        if (response.getStatusCode() != HttpStatus.OK){
            throw new RuntimeException(String.format("Response status code was %s", response.getStatusCode()));
        }

        return ImmutableList.copyOf(response.getBody());
    }

}

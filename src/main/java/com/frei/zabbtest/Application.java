package com.frei.zabbtest;


import com.frei.zabbtest.dto.CsvSuggestionDto;
import com.frei.zabbtest.service.CsvSuggestionConverter;
import com.frei.zabbtest.service.CsvSuggestionWriter;
import com.frei.zabbtest.service.ZabbApiClient;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import static java.util.stream.Collectors.toList;

/**
 *  Main Class Spring Application
 *
 *
 * by Andreichenko
 */

@SpringBootApplication
public class Application implements CommandLineRunner{

    @Autowired
    private CsvSuggestionWriter csvSuggestionWriter;

    @Autowired
    private ZabbApiClient zabbApiClient;

    @Autowired
    private CsvSuggestionConverter csvSuggestionConverter;

    @Bean
    public RestTemplate restTemplate(){

    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).bannerMode(Banner.Mode.OFF).run(args);
    }

    @Override
    public void run(String... strings) throws Exception {
            String cityName = strings[0].trim();
            String fileName = cityName + ".csv"; //todo maybe use StringBuilder???
        //  String fileName = StringBuilder(cityname).append(".csv").toString();  todo here

        csvSuggestionWriter.write(fileName, zabbApiClient.findSuggestionByCity().stream()
                .map(csvSuggestionConverter::toCsvSuggestionDto)
                .collect(collictingAndThen(toList(), ImmutableList::copyOf)));

    }
}

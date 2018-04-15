package com.frei.zabbtest.test.service;

import com.frei.zabbtest.dto.CsvSuggestionDto;
import com.frei.zabbtest.service.CsvSuggestionWriter;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 *
 *   T E S T
 *
 *      Test for Rest-Service
 *      Test Writter for Project
 *
 * by Andreichenko
 */

public class CsvSuggestionWriterTest {
    private CsvSuggestionWriter suit;

    @Before
    public void setUp() throws Exception{
        suit = new CsvSuggestionWriter();
    }

    @Test
    public void testDoWrite() throws Exception{
        // todo Prepare

        List<CsvSuggestionDto> data = ImmutableList.of(
                new CsvSuggestionDto(376217, "Berlin", "location", 52.52437, 13.41053),
                new CsvSuggestionDto(448103, "Berlingo", "location", 45.50298, 10.04366),
                new CsvSuggestionDto(425332, "Berling\"erode", "location", 51.45775, 10.2384)
        );
        StringWriter actualWriter = new StringWriter();

        suit.doWrite(new PrintWriter(actualWriter), data);

        // todo Test
        assertThat(actualWriter.toString(), equalTo(
                "_id,name,type,latitude,longitude\n" +
                        "376217,Berlin,location,52.52437,13.41053\n" +
                        "448103,Berlingo,location,45.50298,10.04366\n" +
                        "425332,\"Berling\"\"erode\",location,51.45775,10.2384\n"
        ));

    }
}

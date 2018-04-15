package com.frei.zabbtest.test.service;

import com.frei.zabbtest.dto.CsvSuggestionDto;
import com.frei.zabbtest.service.CsvSuggestionWriter;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import java.io.StringWriter;
import java.util.List;

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

        List<CsvSuggestionDto> data = ImmutableList.of();
        StringWriter actualWriter = new StringWriter();

        // todo Test


    }
}

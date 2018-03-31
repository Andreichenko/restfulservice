package com.frei.zabbtest.service;


import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.frei.zabbtest.dto.CsvSuggestionDto;
import lombok.Cleanup;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.util.VisibleForTesting;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

/**
 *  Class converter class from Json and write to CSV
 *
 *
 *
 *
 * by Andreichenko
 */

@Log4j2
@Component
public class CsvSuggestionWriter {

    private CsvMapper csvMapper = new CsvMapper();
    private CsvSchema csvSchema = csvMapper.schemaFor(CsvSuggestionConverter.class)
            .withHeader()
            .sortedBy("_id", "name", "type", "latitude", "longtitude");

    public void write(@NonNull String fileName, @NonNull List<CsvSuggestionDto> data){
        try{
            @Cleanup Writer writer = new PrintWriter(new FileWriter(fileName), true);
            doWrite(writer, data);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @VisibleForTesting
    protected void doWrite(@NonNull Writer writer, @NonNull List<CsvSuggestionDto> data) throws IOException {
        csvMapper.writer().with(csvSchema).writeValues(writer).writeAll(data);
    }
}

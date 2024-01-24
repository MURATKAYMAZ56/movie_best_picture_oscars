package com.intake.service.csv;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class AcademyAwardsCsvLoader {

    @Value("${csv-file.awards}")
    private String csvFileName;

    private static final Map<CsvModelId, CsvModel> awards = new HashMap<>(0);

    @PostConstruct
    public void load() {

        CSVParser csvParser = new CSVParserBuilder().withSeparator(',').build();
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(new ClassPathResource(csvFileName).getFile()))
                .withCSVParser(csvParser)
                .withSkipLines(1)
                .build()) {
            List<String[]> data = reader.readAll();
            data.forEach(row -> {

                String year = row[0].substring(0, 4);

                CsvModelId id = new CsvModelId();
                id.setYear(year);
                id.setCategory(row[1]);
                id.setNominee(row[2]);

                CsvModel csvModel = new CsvModel();
                csvModel.setYear(year);
                csvModel.setCategory(row[1]);
                csvModel.setNominee(row[2]);
                csvModel.setInfo(row[3]);
                csvModel.setWon(row[4]);

                awards.put(id, csvModel);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }

    public CsvModel findById(String year, String category, String nominee) {
        CsvModelId id = new CsvModelId();
        id.setYear(year);
        id.setCategory(category);
        id.setNominee(nominee);

        return awards.get(id);
    }
}

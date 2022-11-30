package com.lxisoft.dictionary;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import com.lxisoft.dictionary.entity.Word;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "id", "Name", "Parts_Of_Speech", "Meaning" };

    public static boolean hasCSVFormat(MultipartFile file) {
        if (TYPE.equals(file.getContentType())
                || file.getContentType().equals("application/vnd.ms-excel")) {
            return true;
        }

        return false;
    }

    public static Set<Word> csvToWords(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.TDF.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            Set<Word> wordsList = new HashSet<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Word word = new Word (
                        Long.parseLong(csvRecord.get("id")),
                        csvRecord.get("Name"),
                        csvRecord.get("Parts_Of_Speech"),
                        csvRecord.get("Meaning")
                );

                wordsList.add(word);
            }

            return wordsList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream wordsToCSV(Set<Word> wordsList) {
        final CSVFormat format = CSVFormat.TDF.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Word word : wordsList) {
                List<String> data = Arrays.asList(
                        String.valueOf(word.getId()),
                        word.getName(),
                        word.getPartsOfSpeech(),
                        word.getMeaning());

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}
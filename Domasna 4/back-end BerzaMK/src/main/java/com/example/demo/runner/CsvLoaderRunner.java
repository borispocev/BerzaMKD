package com.example.demo.runner;

import com.example.demo.service.CsvToDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;

//@Component
//public class CsvLoaderRunner implements CommandLineRunner {
//
//    @Autowired
//    private CsvToDatabaseService csvToDatabaseService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        csvToDatabaseService.saveCsvToDatabase(Paths.get("C:\\Users\\boris\\Desktop\\Domasna 3\\data\\all_companies_analysis.csv"));
//    }
//}
@Component
public class CsvLoaderRunner implements CommandLineRunner {

    @Autowired
    private CsvToDatabaseService csvToDatabaseService;

    @Value("${CSV_FILE_PATH}")
    private String csvFilePath;  // Inject the environment variable for the CSV file path

    @Override
    public void run(String... args) throws Exception {
        // Log the CSV file path for debugging purposes
        System.out.println("Loading CSV file from: " + csvFilePath);

        // Load the CSV file using the injected path
        csvToDatabaseService.saveCsvToDatabase(Paths.get(csvFilePath));
    }
}


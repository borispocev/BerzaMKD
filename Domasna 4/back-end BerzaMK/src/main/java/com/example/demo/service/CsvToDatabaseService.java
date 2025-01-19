package com.example.demo.service;

import com.example.demo.model.Analiza;
import com.example.demo.repository.AnalizaRepository;
import jakarta.transaction.Transactional;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

@Service
public class CsvToDatabaseService {

    private final AnalizaRepository analizaRepository;

    public CsvToDatabaseService(AnalizaRepository analizaRepository) {
        this.analizaRepository = analizaRepository;
    }

    @Transactional
    public void saveCsvToDatabase(Path csvPath) throws IOException {
        try (FileReader reader = new FileReader(csvPath.toFile())) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withHeader()
                    .withIgnoreHeaderCase()
                    .withTrim()
                    .parse(reader);

            this.analizaRepository.deleteAll();

            for (CSVRecord record : records) {
                Analiza stockData = new Analiza();
                stockData.setDate(record.get("Date"));
                stockData.setClose(record.get("Close"));
                stockData.setHigh(record.get("High"));
                stockData.setLow(record.get("Low"));
                stockData.setVolume(record.get("Volume"));
                stockData.setSma20(record.get("SMA_20"));
                stockData.setSma50(record.get("SMA_50"));
                stockData.setEma20(record.get("EMA_20"));
                stockData.setEma50(record.get("EMA_50"));
                stockData.setBbmid(record.get("BB_Mid"));
                stockData.setRsi(record.get("RSI"));
                stockData.setObv(record.get("OBV"));
                stockData.setMomentum(record.get("Momentum"));
                stockData.setBuy_signal(record.get("Buy_Signal"));
                stockData.setSell_signal(record.get("Sell_Signal"));
                stockData.setCompany_name(record.get("Company"));

                analizaRepository.save(stockData);
            }
        }
    }
}

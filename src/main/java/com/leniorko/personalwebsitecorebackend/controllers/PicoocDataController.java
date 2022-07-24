package com.leniorko.personalwebsitecorebackend.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.leniorko.personalwebsitecorebackend.entities.PicoocData;
import com.leniorko.personalwebsitecorebackend.repositories.PicoocDataRepository;
import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

@RestController
@RequestMapping("/picooc-data")
public class PicoocDataController {

  @Autowired
  PicoocDataRepository picoocDataRepository;

  Logger logger = LoggerFactory.getLogger(PicoocDataController.class);

  @GetMapping("/get-all")
  public ResponseEntity<List<PicoocData>> getAll() {
    return ResponseEntity.ok(picoocDataRepository.findAll());
  }

  @GetMapping("/get-range")
  public ResponseEntity<List<PicoocData>> getRange(@RequestParam(name = "from", required = false) Timestamp from,
      @RequestParam(name = "to", required = false) Timestamp to) {

    if (from != null && to != null) {
      return ResponseEntity.ok(picoocDataRepository.findByWeightTimeBetween(from, to));
    }

    if (to != null) {
      return ResponseEntity.ok(picoocDataRepository.findByWeightTimeGreaterThanEqual(to));
    }

    return ResponseEntity.badRequest().build();
  }

  @PostMapping("/upload-picooc-tsv")
  public ResponseEntity<String> uploadPicoocTsv(@RequestParam("picooc_file") MultipartFile uploadedFile) {
    // TODO: Write validation and proper error handling
    // TODO: Write some auth logic to prevent unauthicated acces to endpoint

    try {
      InputStream uploadedFileInputStream = uploadedFile.getInputStream();

      TsvParserSettings myTsvParserSettings = new TsvParserSettings();
      // Skip header row from TSV file
      myTsvParserSettings.setNumberOfRowsToSkip(1);
      TsvParser myParser = new TsvParser(myTsvParserSettings);
      myParser.beginParsing(uploadedFileInputStream);

      String[] row;
      while ((row = myParser.parseNext()) != null) {

        if (logger.isInfoEnabled()) {
          logger.info(Arrays.toString(row));
        }

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentRowStringTime = LocalDateTime.parse(row[0], format).format(format);
        Timestamp currentRowTimestamp = Timestamp.valueOf(currentRowStringTime);

        if (picoocDataRepository.findByWeightTime(currentRowTimestamp).isEmpty()) {
          logger.info("Save logic hit");
          // TODO: Figure out way to properly create PicoocData without index shenanigans
          PicoocData picoocData = new PicoocData(currentRowTimestamp,
              Float.parseFloat(row[1].replace(',', '.')),
              Float.parseFloat(row[2].replace(',', '.')),
              Integer.parseInt(row[3]),
              Float.parseFloat(row[4].replace(',', '.')),
              Float.parseFloat(row[5].replace(',', '.')),
              Integer.parseInt(row[6]), Float.parseFloat(row[7].replace(',', '.')),
              Integer.parseInt(row[8]));
          picoocDataRepository.save(picoocData);
        }

      }

    } catch (IOException e) {
      e.printStackTrace();
      return ResponseEntity.internalServerError().body("Can't read file input stream");
    }

    return ResponseEntity.ok("File uploaded successfully");
  }
}

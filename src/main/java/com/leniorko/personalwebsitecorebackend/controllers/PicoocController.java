package com.leniorko.personalwebsitecorebackend.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.persistence.ElementCollection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.leniorko.personalwebsitecorebackend.Entities.PicoocData;
import com.leniorko.personalwebsitecorebackend.repositories.PicoocDataRepository;
import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

@RestController
public class PicoocController {

  @Autowired
  static PicoocDataRepository picoocDataRepository;

  @GetMapping("/get-all")
  public static String getAll() {
    // TODO: Write simple getAll
    // TODO: Replace simple getAll with endpoint with filters
    return "Will return every row from picooc_data table";
  }

  @GetMapping("/get-all-average")
  public static String getAllAverage() {
    // TODO: Write simple getAllAverage
    // TODO: Replace simple getAllAverage with endpoint with filters
    return "Will return every row from picooc_data_average view";
  }

  @PostMapping("/upload-picooc-tsv")
  public static ResponseEntity<?> uploadPicoocTsv(@RequestParam("picooc_file") MultipartFile uploadedFile) {
    // TODO: Write validation and proper error handling
    // TODO: Write login some auth logic to prevent unauthicated acces to endpoint

    try {
      InputStream uploadedFileInputStream = uploadedFile.getInputStream();

      TsvParserSettings myTsvParserSettings = new TsvParserSettings();
      // Skip header row from TSV file
      myTsvParserSettings.setNumberOfRowsToSkip(1);
      TsvParser myParser = new TsvParser(myTsvParserSettings);
      myParser.beginParsing(uploadedFileInputStream);

      String[] row;
      while ((row = myParser.parseNext()) != null) {
        System.out.println(Arrays.toString(row));
        // TODO: Write database save logic
        // Figure out way to properly create PicoocData without index shenanigans
        PicoocData picoocData = new PicoocData(Date.valueOf(LocalDate.parse(row[0])), Float.parseFloat(row[1]),
            Float.parseFloat(row[2]), Integer.parseInt(row[3]), Float.parseFloat(row[4]), Float.parseFloat(row[5]),
            Integer.parseInt(row[6]), Integer.parseInt(row[7]));
        picoocDataRepository.save(picoocData);

      }

    } catch (IOException e) {
      e.printStackTrace();
      return ResponseEntity.internalServerError().body("Can't read file input stream");
    }

    // return "Will return every row from picooc_data_average view";
    return ResponseEntity.ok("File uploaded successfully");
  }
}

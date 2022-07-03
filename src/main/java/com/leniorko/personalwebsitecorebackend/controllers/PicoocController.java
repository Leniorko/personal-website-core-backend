package com.leniorko.personalwebsitecorebackend.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PicoocController {

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
      ;
      BufferedReader reader = new BufferedReader(new InputStreamReader(uploadedFileInputStream));
      while (reader.ready()) {
        String currentLine = reader.readLine();
        System.out.println(currentLine);
        // TODO: Write parsing logic
        // TODO: Write database save logic
      }
    } catch (IOException e) {
      e.printStackTrace();
      return ResponseEntity.internalServerError().body("Can't read file input stream");
    }

    // return "Will return every row from picooc_data_average view";\
    return ResponseEntity.ok("File uploaded successfully");
  }
}

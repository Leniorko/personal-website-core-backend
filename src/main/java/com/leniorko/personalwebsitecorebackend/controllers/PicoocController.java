package com.leniorko.personalwebsitecorebackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
  public static String uploadPicoocTsv() {
    // TODO: Write upload logic
    // TODO: Write parsing logic
    // TODO: Write database save logic
    // TODO: Write validation and proper error handling
    // TODO: Write login some auth logic to prevent unauthicated acces to endpoint
    return "Will return every row from picooc_data_average view";
  }
}

package com.leniorko.personalwebsitecorebackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leniorko.personalwebsitecorebackend.entities.PicoocAverageData;
import com.leniorko.personalwebsitecorebackend.repositories.PicoocAverageDataRepository;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("picooc-data-average")
public class PicoocAverageDataController {

  @Autowired
  PicoocAverageDataRepository picoocAverageDataRepository;

  @GetMapping("/get-all")
  public ResponseEntity<List<PicoocAverageData>> getAllAverage() {
    return ResponseEntity.ok(picoocAverageDataRepository.findAll());
  }

  @GetMapping(value = "/get-by-year")
  public ResponseEntity<List<PicoocAverageData>> getByYear(@RequestParam Integer year) {
    return ResponseEntity.ok(picoocAverageDataRepository.findByYear(year));
  }

}

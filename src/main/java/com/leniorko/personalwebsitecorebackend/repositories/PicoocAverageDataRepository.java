package com.leniorko.personalwebsitecorebackend.repositories;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leniorko.personalwebsitecorebackend.entities.PicoocAverageData;

@Repository
public interface PicoocAverageDataRepository extends CrudRepository<PicoocAverageData, Integer> {
  List<PicoocAverageData> findAll();

  List<PicoocAverageData> findByYear(Integer year);

  List<PicoocAverageData> findByWeekAndYear(Integer week, Integer year);

}

package com.leniorko.personalwebsitecorebackend.repositories;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leniorko.personalwebsitecorebackend.entities.PicoocData;

@Repository
public interface PicoocDataRepository extends CrudRepository<PicoocData, Long> {

  List<PicoocData> findByWeightTime(Timestamp weightTime);
}

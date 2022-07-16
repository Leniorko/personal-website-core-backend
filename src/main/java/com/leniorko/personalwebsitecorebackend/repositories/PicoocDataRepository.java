package com.leniorko.personalwebsitecorebackend.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leniorko.personalwebsitecorebackend.Entities.PicoocData;

@Repository
public interface PicoocDataRepository extends CrudRepository<PicoocData, Long> {

}

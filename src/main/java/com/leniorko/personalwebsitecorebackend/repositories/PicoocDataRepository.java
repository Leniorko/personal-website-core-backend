package com.leniorko.personalwebsitecorebackend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leniorko.personalwebsitecorebackend.entities.PicoocData;

@Repository
public interface PicoocDataRepository extends CrudRepository<PicoocData, Long> {

}

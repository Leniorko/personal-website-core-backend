package com.leniorko.personalwebsitecorebackend.Entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "picooc_data")
public class PicoocData {
  // TODO: Write repo to access this data
  @Id
  private Integer id;
  private Date weight_time;
  private Float weight;
  private Float body_fat;
  private Integer fisceral_fat_index;
  private Float muscles_percent;
  private Float water_percent;
  private Integer metabolic_age;
  private Integer bmr;

}

// TODO: Write same logic for view access
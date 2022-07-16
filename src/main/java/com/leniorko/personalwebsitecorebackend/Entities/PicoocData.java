package com.leniorko.personalwebsitecorebackend.Entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "picooc_data")
@RequiredArgsConstructor
public class PicoocData {
  // TODO: Write repo to access this data
  @Id
  private Integer id;

  @NonNull
  private Date weight_time;

  @NonNull
  private Float weight;

  @NonNull
  private Float body_fat;

  @NonNull
  private Integer fisceral_fat_index;

  @NonNull
  private Float muscles_percent;

  @NonNull
  private Float water_percent;

  @NonNull
  private Integer metabolic_age;

  @NonNull
  private Integer bmr;

}

// TODO: Write same logic for view access
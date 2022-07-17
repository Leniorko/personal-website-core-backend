package com.leniorko.personalwebsitecorebackend.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "picooc_data")
@RequiredArgsConstructor
public class PicoocData {

  public PicoocData() {
    // Method for retreiving data from repo required default constructor. IDK why
    // but it should be here.
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NonNull
  @Column(name = "weight_time")
  private Timestamp weightTime;

  @NonNull
  @Column(name = "weight")
  private Float weight;

  @NonNull
  @Column(name = "body_fat")
  private Float bodyFat;

  @NonNull
  @Column(name = "visceral_fat_index")
  private Integer fisceralFatIndex;

  @NonNull
  @Column(name = "muscles_percent")
  private Float musclesPercent;

  @NonNull
  @Column(name = "water_percent")
  private Float waterPercent;

  @NonNull
  @Column(name = "metabolic_age")
  private Integer metabolicAge;

  @NonNull
  @Column(name = "bone_mass")
  private Float boneMass;

  @NonNull
  @Column(name = "bmr")
  private Integer bmr;

}

// TODO: Write same logic for view access
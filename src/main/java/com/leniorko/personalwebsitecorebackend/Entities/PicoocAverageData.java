package com.leniorko.personalwebsitecorebackend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "picooc_data_average")
@Data
@RequiredArgsConstructor
@Immutable
public class PicoocAverageData {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "week")
  private Integer week;

  @NonNull
  @Column(name = "year")
  private Integer year;

  @NonNull
  @Column(name = "average_weight")
  private Float averageWeight;

  @NonNull
  @Column(name = "average_body_fat")
  private Float averageBodyFat;

  @NonNull
  @Column(name = "minimum_visceral_fat_index")
  private Integer minimumVisceralFatIndex;

  @NonNull
  @Column(name = "average_muscles_percent")
  private Float averageMusclesPercent;

  @NonNull
  @Column(name = "average_water_percent")
  private Float averageWaterPercent;

  @NonNull
  @Column(name = "minimum_metabolic_age")
  private Integer minimumMetabolicAge;

  @NonNull
  @Column(name = "average_bone_mass")
  private Float averageBoneMass;

  @NonNull
  @Column(name = "average_bmr")
  private Integer averageBmr;
}

DROP TABLE IF EXISTS picooc_data;

CREATE TABLE picooc_data(
  id int GENERATED ALWAYS AS IDENTITY,
  weight_time timestamp NOT NULL,
  weight decimal NOT NULL,
  body_fat decimal NOT NULL,
  visceral_fat_index int NOT NULL,
  muscles_percent decimal NOT NULL,
  water_percent decimal NOT NULL,
  metabolic_age int NOT NULL,
  bone_mass decimal NOT NULL,
  bmr int NOT NULL
);

DROP INDEX IF EXISTS idx_weight_time;

CREATE INDEX idx_weight_time ON picooc_data (weight_time);

CREATE VIEW picooc_data_average AS
SELECT
  DATE_PART('week', weight_time) AS week,
  DATE_PART('year', weight_time) AS year,
  ROUND(AVG(weight), 2) AS average_weight,
  ROUND(AVG(body_fat), 2) AS average_body_fat,
  MIN(visceral_fat_index) AS minimum_visceral_fat_index,
  ROUND(AVG(muscles_percent), 2) AS average_muscles_percent,
  ROUND(AVG(water_percent), 2) AS average_water_percent,
  MIN(metabolic_age) AS minimum_metabolic_age,
  ROUND(AVG(bone_mass), 2) AS average_bone_mass,
  ROUND(AVG(bmr), 2) AS average_bmr
FROM
  picooc_data
GROUP BY
  DATE_PART('week', weight_time),
  DATE_PART('year', weight_time)
ORDER BY
  DATE_PART('year', weight_time) DESC,
  DATE_PART('week', weight_time) DESC;
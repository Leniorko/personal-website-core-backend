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
  bmr int NOT NULL
);

DROP INDEX IF EXISTS idx_weight_time;

CREATE INDEX idx_weight_time ON picooc_data (weight_time);
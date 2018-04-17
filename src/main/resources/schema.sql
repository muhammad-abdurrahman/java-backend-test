CREATE TABLE coordinate (
  id INT NOT NULL AUTO_INCREMENT,
  x INT NOT NULL,
  y INT NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE input (
  id INT NOT NULL AUTO_INCREMENT,
  room_size INT NOT NULL,
  instructions VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  INDEX id_coordinate_idx (room_size ASC),
  CONSTRAINT id_coordinate
    FOREIGN KEY (room_size)
    REFERENCES coordinate (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE input_patches (
  id INT NOT NULL AUTO_INCREMENT,
  id_input INT NOT NULL,
  id_coordinate INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_input_idx (id_input ASC),
  INDEX fk_patch_coordinate_idx (id_coordinate ASC),
  CONSTRAINT fk_input
    FOREIGN KEY (id_input)
    REFERENCES input (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_patch_coordinate
    FOREIGN KEY (id_coordinate)
    REFERENCES coordinate (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE output (
  id INT NOT NULL AUTO_INCREMENT,
  coords INT NOT NULL,
  patches INT NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  INDEX fk_coords_idx (coords ASC),
  CONSTRAINT fk_coords
    FOREIGN KEY (coords)
    REFERENCES coordinate (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE spring_clean (
  id INT NOT NULL AUTO_INCREMENT,
  id_input INT NOT NULL,
  id_output INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_in_idx (id_input ASC),
  INDEX fk_out_idx (id_output ASC),
  CONSTRAINT fk_in
    FOREIGN KEY (id_input)
    REFERENCES input (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_out
    FOREIGN KEY (id_output)
    REFERENCES output (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
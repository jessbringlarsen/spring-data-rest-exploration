CREATE TABLE IF NOT EXISTS club (
  id BIGINT AUTO_INCREMENT,
  created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  version INT DEFAULT 1,
  name VARCHAR(255) NOT NULL,
  UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS player (
	id BIGINT AUTO_INCREMENT,
	created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	version INT DEFAULT 1,
	name VARCHAR(255) NOT NULL,
  birthdate DATE,
  UNIQUE (name, birthdate)
);

CREATE TABLE IF NOT EXISTS club_membership (
	id BIGINT AUTO_INCREMENT,
	created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	version INT DEFAULT 1,
	player_id INT NOT NULL,
	club_id INT NOT NULL,
	member_from DATE NOT NULL,
	member_to DATE,
  FOREIGN KEY (club_id) REFERENCES club (id),
  FOREIGN KEY (player_id) REFERENCES player (id),
  UNIQUE (club_id, player_id)
);

CREATE TABLE IF NOT EXISTS match_table (
	id BIGINT AUTO_INCREMENT,
	created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	version INT DEFAULT 1,
	when_column TIMESTAMP,
	player1_id INT NOT NULL,
	player2_id INT NOT NULL,
	result VARCHAR(255),
  FOREIGN KEY (player1_id) REFERENCES player (id),
  FOREIGN KEY (player2_id) REFERENCES player (id),
  UNIQUE (player1_id, player2_id, when_column)
);
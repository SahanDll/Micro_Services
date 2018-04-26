CREATE SCHEMA IF NOT EXISTS SOCIAL;

CREATE TABLE IF NOT EXISTS SOCIAL.facebook(
	id int NOT NULL,
	userName varchar(255) NULL,
	status varchar(255) NULL,
	links varchar(255) NULL,
	port int NULL,
  PRIMARY KEY (id)
);


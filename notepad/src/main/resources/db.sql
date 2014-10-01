
-- mysql 
CREATE SCHEMA NOTEPAD;

USE NOTEPAD;

DROP TABLE IF EXISTS NOTES ;

create table notes(
	NOTE_ID int(6),
	CONTENT TEXT,
	created_date DATETIME,
	updated_date DATETIME
);
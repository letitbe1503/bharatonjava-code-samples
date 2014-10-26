create schema notes;

use notes;

create table NOTES(
	NOTE_ID INT PRIMARY KEY AUTO_INCREMENT,
	TITLE TEXT(255),
	NOTE_TEXT TEXT(65535)
);

INSERT INTO NOTES(TITLE, NOTE_TEXT) VALUES("a sample title","this is acutal note content. It actually looks good!");

INSERT INTO NOTES(TITLE, NOTE_TEXT) VALUES("Bharat Sharma address","B-504 Silver Tower, Thakur complex");

INSERT INTO NOTES(TITLE, NOTE_TEXT) VALUES("Agreement details","Some secret about agreement");
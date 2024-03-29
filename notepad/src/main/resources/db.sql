
-- mysql 
CREATE SCHEMA NOTEPAD;

USE NOTEPAD;

DROP TABLE IF EXISTS NOTES ;

create table notes(
	NOTE_ID int(6) primary key auto_increment,
	CONTENT TEXT,
	DELETED INT(1),
	created_date DATETIME,
	updated_date DATETIME
);

insert into notes (note_id, content) values (1,'A Sample Note');

insert into notes (note_id, content) values (2,'Close open jiras');

insert into notes (note_id, content) values (3,'Check all pending mails');

insert into notes (content) values ('b-504 silver tower, Thakur Village, Kandivali East, Mumbai');

insert into notes (content, created_date, updated_date) values ('Palmer House, Downtown, Chicago', curdate(), curdate());

insert into notes (content, created_date, updated_date) values ('This is a very long note, probably will span across multiple lines on the user interface. To test how it looks on the UI.', curdate(), curdate());

insert into notes(content, created_date, updated_date) values ("test timestamp value", curtime(), curtime());

commit;


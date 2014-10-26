
USE HOSPITAL;

DROP TABLE IF EXISTS PATIENTS ;

CREATE TABLE PATIENTS (
	PATIENT_ID  INTEGER, 
	FIRST_NAME VARCHAR(100), 
	MIDDLE_NAME VARCHAR(100), 
	LAST_NAME VARCHAR(100),
	AGE INTEGER(2),
	PRIMARY KEY (PATIENT_ID)
);


DROP TABLE IF EXISTS PATHO_TESTS;

CREATE TABLE PATHO_TESTS(
	TEST_ID INTEGER(11),
	TEST_NAME VARCHAR(200),
	DESCRIPTION VARCHAR(200),
	PRIMARY KEY (TEST_ID)
);

DROP TABLE IF EXISTS PATHO_LABS;

CREATE TABLE PATHO_LABS(
	PATHO_LAB_ID INTEGER(11),
	PATHO_LAB_NAME VARCHAR(200),
	ADDRESS VARCHAR(200),
	PRIMARY KEY (PATHO_LAB_ID)
);

DROP TABLE IF EXISTS PATIENT_TESTS;

CREATE TABLE PATIENT_TESTS(
	PATIENT_TEST_ID INTEGER(11),
	PATHO_TEST_ID INTEGER(11),
	COMMENTS VARCHAR(200),
	TEST_DATE DATE,
	PATHO_LAB_ID INTEGER(11),
	PRIMARY KEY (PATIENT_TEST_ID)
);

ALTER TABLE PATIENT_TESTS ADD CONSTRAINT FK_TESTS_NAME FOREIGN KEY(PATHO_TEST_ID) REFERENCES PATHO_TESTS(TEST_ID);

-- ALTER TABLE PATIENT_TESTS DROP FOREIGN KEY FK_TESTS_NAME; 

INSERT INTO PATHO_LABS(PATHO_LAB_ID,PATHO_LAB_NAME,ADDRESS) VALUES(1,'DR. LAL PATHOLOGY', 'MALAD WEST');
INSERT INTO PATHO_LABS(PATHO_LAB_ID,PATHO_LAB_NAME,ADDRESS) VALUES(2,'SRL DIAGNOSTICS', 'THAKUR COMPLEX, KANDIVALI EAST');

INSERT INTO PATHO_TESTS(TEST_ID,TEST_NAME,DESCRIPTION) VALUES(1,'BLOOD TEST','COMMON BLOOD TEST');
INSERT INTO PATHO_TESTS(TEST_ID,TEST_NAME,DESCRIPTION) VALUES(2,'URINE TEST','URINE ROUTINE TEST');
INSERT INTO PATHO_TESTS(TEST_ID,TEST_NAME,DESCRIPTION) VALUES(3,'CBC TEST','CBC COUNT IN BLOOD');
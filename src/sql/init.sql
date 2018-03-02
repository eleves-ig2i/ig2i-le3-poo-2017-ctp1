DROP table Aliment;
DROP table PATIENT;
DROP table PRESCRIPTION;

CREATE table Aliment (
	id int,
	nom varchar(500),
	satisfaction int,
	calories int,
	calcium int,
	vitamineC int,
	fer int
);

CREATE table PATIENT (
	nPatient int,
	nom varchar(500), 
	prenom varchar(500),
	caloriesMax int,
	calciumMin int,
	vitaminesCMin int,
	ferMin int
);

CREATE table PRESCRIPTION (
	nPrescription int,
	quantite int,
	nAliment int,
	nPatient int
);

INSERT INTO PRESCRIPTION
VALUES (1, 12, 15, 1);

INSERT INTO PATIENT
VALUES (1, 'Wow', 'John', 2500, 10, 152, 255);
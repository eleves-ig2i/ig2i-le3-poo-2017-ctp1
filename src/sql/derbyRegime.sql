DROP TABLE prescription;
DROP TABLE aliment;
DROP TABLE patient;

CREATE TABLE patient (
    nPatient INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    caloriesMax INT NOT NULL,
    calciumMin INT NOT NULL,
    vitaminesCMin INT NOT NULL,
    ferMin INT NOT NULL,
    CONSTRAINT uk_patient UNIQUE(nom, prenom)
);

CREATE TABLE aliment (
    nAliment INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nom VARCHAR(30) UNIQUE NOT NULL,
    satisfaction INT NOT NULL,
    calories INT NOT NULL,
    calcium INT NOT NULL,
    vitaminesC INT NOT NULL,
    fer INT NOT NULL
);

CREATE TABLE prescription (
    nPrescription INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    quantite INT NOT NULL,
    nAliment INT NOT NULL,
    nPatient INT NOT NULL,
    CONSTRAINT fk_prescription_aliment FOREIGN KEY (nAliment) REFERENCES aliment(nAliment),
    CONSTRAINT fk_prescription_patient FOREIGN KEY (nPatient) REFERENCES patient(nPatient),
    CONSTRAINT uk_prescription UNIQUE(nAliment, nPatient)
);


INSERT INTO patient(nom, prenom, caloriesMax, calciumMin, vitaminesCMin, ferMin)
    VALUES('Hitemieux', 'Elmer', 2000, 1600, 250, 12000);
INSERT INTO patient(nom, prenom, caloriesMax, calciumMin, vitaminesCMin, ferMin)
    VALUES('Haybon', 'Sylvain', 1800, 1200, 150, 10000);
INSERT INTO patient(nom, prenom, caloriesMax, calciumMin, vitaminesCMin, ferMin)
    VALUES('Peuplu', 'Jean', 2100, 600, 250, 15000);
INSERT INTO patient(nom, prenom, caloriesMax, calciumMin, vitaminesCMin, ferMin)
    VALUES('Ancieux', 'Cecile', 1500, 900, 110, 8000);
INSERT INTO patient(nom, prenom, caloriesMax, calciumMin, vitaminesCMin, ferMin)
    VALUES('Naymart', 'Jean', 2500, 1000, 140, 6500);

INSERT INTO aliment(nom, satisfaction, calories, calcium, vitaminesC, fer)
    VALUES('Ananas', 12, 50, 13, 48, 300);
INSERT INTO aliment(nom, satisfaction, calories, calcium, vitaminesC, fer)
    VALUES('Boeuf', 20, 250, 18, 0, 2600);
INSERT INTO aliment(nom, satisfaction, calories, calcium, vitaminesC, fer)
    VALUES('Chocolat', 45, 600, 56, 0, 8000);
INSERT INTO aliment(nom, satisfaction, calories, calcium, vitaminesC, fer)
    VALUES('Dinde', 11, 120, 14, 0, 1000);
INSERT INTO aliment(nom, satisfaction, calories, calcium, vitaminesC, fer)
    VALUES('Epinard', 3, 25, 99, 28, 2700);
INSERT INTO aliment(nom, satisfaction, calories, calcium, vitaminesC, fer)
    VALUES('Feta', 8, 260, 490, 0, 700);
INSERT INTO aliment(nom, satisfaction, calories, calcium, vitaminesC, fer)
    VALUES('Gruyere', 16, 400, 1000, 0, 300);
INSERT INTO aliment(nom, satisfaction, calories, calcium, vitaminesC, fer)
    VALUES('Haricot', 7, 30, 37, 16, 100);

INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(9, 
        (SELECT nAliment FROM aliment WHERE nom = 'Ananas'),
        (SELECT nPatient FROM patient WHERE nom = 'Hitemieux' AND prenom = 'Elmer'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(0, 
        (SELECT nAliment FROM aliment WHERE nom = 'Boeuf'),
        (SELECT nPatient FROM patient WHERE nom = 'Hitemieux' AND prenom = 'Elmer'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(0, 
        (SELECT nAliment FROM aliment WHERE nom = 'Chocolat'),
        (SELECT nPatient FROM patient WHERE nom = 'Hitemieux' AND prenom = 'Elmer'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(6, 
        (SELECT nAliment FROM aliment WHERE nom = 'Dinde'),
        (SELECT nPatient FROM patient WHERE nom = 'Hitemieux' AND prenom = 'Elmer'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(7, 
        (SELECT nAliment FROM aliment WHERE nom = 'Epinard'),
        (SELECT nPatient FROM patient WHERE nom = 'Hitemieux' AND prenom = 'Elmer'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(1, 
        (SELECT nAliment FROM aliment WHERE nom = 'Feta'),
        (SELECT nPatient FROM patient WHERE nom = 'Hitemieux' AND prenom = 'Elmer'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(0, 
        (SELECT nAliment FROM aliment WHERE nom = 'Gruyere'),
        (SELECT nPatient FROM patient WHERE nom = 'Hitemieux' AND prenom = 'Elmer'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(6, 
        (SELECT nAliment FROM aliment WHERE nom = 'Haricot'),
        (SELECT nPatient FROM patient WHERE nom = 'Hitemieux' AND prenom = 'Elmer'));

INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(2, 
        (SELECT nAliment FROM aliment WHERE nom = 'Ananas'),
        (SELECT nPatient FROM patient WHERE nom = 'Haybon' AND prenom = 'Sylvain'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(1, 
        (SELECT nAliment FROM aliment WHERE nom = 'Boeuf'),
        (SELECT nPatient FROM patient WHERE nom = 'Haybon' AND prenom = 'Sylvain'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(1, 
        (SELECT nAliment FROM aliment WHERE nom = 'Chocolat'),
        (SELECT nPatient FROM patient WHERE nom = 'Haybon' AND prenom = 'Sylvain'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(3, 
        (SELECT nAliment FROM aliment WHERE nom = 'Dinde'),
        (SELECT nPatient FROM patient WHERE nom = 'Haybon' AND prenom = 'Sylvain'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(7, 
        (SELECT nAliment FROM aliment WHERE nom = 'Epinard'),
        (SELECT nPatient FROM patient WHERE nom = 'Haybon' AND prenom = 'Sylvain'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(0, 
        (SELECT nAliment FROM aliment WHERE nom = 'Feta'),
        (SELECT nPatient FROM patient WHERE nom = 'Haybon' AND prenom = 'Sylvain'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(0, 
        (SELECT nAliment FROM aliment WHERE nom = 'Gruyere'),
        (SELECT nPatient FROM patient WHERE nom = 'Haybon' AND prenom = 'Sylvain'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(10, 
        (SELECT nAliment FROM aliment WHERE nom = 'Haricot'),
        (SELECT nPatient FROM patient WHERE nom = 'Haybon' AND prenom = 'Sylvain'));
		
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(3, 
        (SELECT nAliment FROM aliment WHERE nom = 'Ananas'),
        (SELECT nPatient FROM patient WHERE nom = 'Peuplu' AND prenom = 'Jean'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(0, 
        (SELECT nAliment FROM aliment WHERE nom = 'Boeuf'),
        (SELECT nPatient FROM patient WHERE nom = 'Peuplu' AND prenom = 'Jean'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(0, 
        (SELECT nAliment FROM aliment WHERE nom = 'Chocolat'),
        (SELECT nPatient FROM patient WHERE nom = 'Peuplu' AND prenom = 'Jean'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(4, 
        (SELECT nAliment FROM aliment WHERE nom = 'Dinde'),
        (SELECT nPatient FROM patient WHERE nom = 'Peuplu' AND prenom = 'Jean'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(4, 
        (SELECT nAliment FROM aliment WHERE nom = 'Epinard'),
        (SELECT nPatient FROM patient WHERE nom = 'Peuplu' AND prenom = 'Jean'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(0, 
        (SELECT nAliment FROM aliment WHERE nom = 'Feta'),
        (SELECT nPatient FROM patient WHERE nom = 'Peuplu' AND prenom = 'Jean'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(0, 
        (SELECT nAliment FROM aliment WHERE nom = 'Gruyere'),
        (SELECT nPatient FROM patient WHERE nom = 'Peuplu' AND prenom = 'Jean'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(3, 
        (SELECT nAliment FROM aliment WHERE nom = 'Haricot'),
        (SELECT nPatient FROM patient WHERE nom = 'Peuplu' AND prenom = 'Jean'));
		
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(5, 
        (SELECT nAliment FROM aliment WHERE nom = 'Ananas'),
        (SELECT nPatient FROM patient WHERE nom = 'Ancieux' AND prenom = 'Cecile'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(1, 
        (SELECT nAliment FROM aliment WHERE nom = 'Boeuf'),
        (SELECT nPatient FROM patient WHERE nom = 'Ancieux' AND prenom = 'Cecile'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(0, 
        (SELECT nAliment FROM aliment WHERE nom = 'Chocolat'),
        (SELECT nPatient FROM patient WHERE nom = 'Ancieux' AND prenom = 'Cecile'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(2, 
        (SELECT nAliment FROM aliment WHERE nom = 'Dinde'),
        (SELECT nPatient FROM patient WHERE nom = 'Ancieux' AND prenom = 'Cecile'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(4, 
        (SELECT nAliment FROM aliment WHERE nom = 'Epinard'),
        (SELECT nPatient FROM patient WHERE nom = 'Ancieux' AND prenom = 'Cecile'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(1, 
        (SELECT nAliment FROM aliment WHERE nom = 'Feta'),
        (SELECT nPatient FROM patient WHERE nom = 'Ancieux' AND prenom = 'Cecile'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(0, 
        (SELECT nAliment FROM aliment WHERE nom = 'Gruyere'),
        (SELECT nPatient FROM patient WHERE nom = 'Ancieux' AND prenom = 'Cecile'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(10, 
        (SELECT nAliment FROM aliment WHERE nom = 'Haricot'),
        (SELECT nPatient FROM patient WHERE nom = 'Ancieux' AND prenom = 'Cecile'));
		
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(2, 
        (SELECT nAliment FROM aliment WHERE nom = 'Ananas'),
        (SELECT nPatient FROM patient WHERE nom = 'Naymart' AND prenom = 'Jean'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(1, 
        (SELECT nAliment FROM aliment WHERE nom = 'Boeuf'),
        (SELECT nPatient FROM patient WHERE nom = 'Naymart' AND prenom = 'Jean'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(0, 
        (SELECT nAliment FROM aliment WHERE nom = 'Chocolat'),
        (SELECT nPatient FROM patient WHERE nom = 'Naymart' AND prenom = 'Jean'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(3, 
        (SELECT nAliment FROM aliment WHERE nom = 'Dinde'),
        (SELECT nPatient FROM patient WHERE nom = 'Naymart' AND prenom = 'Jean'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(6, 
        (SELECT nAliment FROM aliment WHERE nom = 'Epinard'),
        (SELECT nPatient FROM patient WHERE nom = 'Naymart' AND prenom = 'Jean'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(0, 
        (SELECT nAliment FROM aliment WHERE nom = 'Feta'),
        (SELECT nPatient FROM patient WHERE nom = 'Naymart' AND prenom = 'Jean'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(0, 
        (SELECT nAliment FROM aliment WHERE nom = 'Gruyere'),
        (SELECT nPatient FROM patient WHERE nom = 'Naymart' AND prenom = 'Jean'));
INSERT INTO prescription(quantite, nAliment, nPatient)
    VALUES(9, 
        (SELECT nAliment FROM aliment WHERE nom = 'Haricot'),
        (SELECT nPatient FROM patient WHERE nom = 'Naymart' AND prenom = 'Jean'));
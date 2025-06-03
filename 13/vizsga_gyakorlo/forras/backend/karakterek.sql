
CREATE TABLE karakterek (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nev VARCHAR(255),
    szint INT,
    ero INT,
    ugyesseg INT,
    faj_id INT
);

INSERT INTO karakterek (id, nev, szint, ero, ugyesseg, faj_id) VALUES (1, 'Arthas', 4, 9, 6, 1);
INSERT INTO karakterek (id, nev, szint, ero, ugyesseg, faj_id) VALUES (2, 'Lindir', 5, 7, 10, 2);
INSERT INTO karakterek (id, nev, szint, ero, ugyesseg, faj_id) VALUES (3, 'Gromm', 3, 10, 4, 3);
INSERT INTO karakterek (id, nev, szint, ero, ugyesseg, faj_id) VALUES (4, 'Borin', 2, 6, 5, 4);
INSERT INTO karakterek (id, nev, szint, ero, ugyesseg, faj_id) VALUES (5, 'Elina', 6, 5, 9, 2);
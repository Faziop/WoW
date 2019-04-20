-- Tablas

CREATE TABLE Faccion(
	identificador INT,
	nombre TEXT,
    CONSTRAINT pkFaccion PRIMARY KEY(identificador),
	CONSTRAINT ch1Faccion CHECK(identificador > 0 AND identificador < 3)
);

CREATE TABLE Continente(
	identificador INT,
	nombre TEXT,
    CONSTRAINT pkContinente PRIMARY KEY(identificador),
	CONSTRAINT ch1Continente CHECK(identificador > 0 AND identificador < 4)
);

CREATE TABLE Clase(
    identificador INT,
    nombre TEXT,
    CONSTRAINT pkClase PRIMARY KEY(identificador),
    CONSTRAINT ch1Clase CHECK(identificador > 0 AND identificador < 11)
);

CREATE TABLE Atributo(
	identificador INT,
	nombre TEXT,
    CONSTRAINT pkAtributo PRIMARY KEY(identificador),
	CONSTRAINT ch1Atributo CHECK(identificador > 0 AND identificador < 6)
);

CREATE TABLE Sitio(
	identificador INT,
	nombre TEXT,
	tipo TEXT,
    CONSTRAINT pkSitio PRIMARY KEY(identificador)
);

CREATE TABLE Region(
	identificador INT,
	nombre TEXT,
	ciudad_capital INT,
	continente INT,
    CONSTRAINT pkRegion PRIMARY KEY(identificador),
    CONSTRAINT fk1Region FOREIGN KEY(ciudad_capital) REFERENCES Sitio(identificador),
    CONSTRAINT fk2Region FOREIGN KEY(continente) REFERENCES Continente(identificador)
);

-- No se puede hacer realizar la operacion ADD CONSTRAINT en SQLite
ALTER TABLE Sitio ADD COLUMN region INT REFERENCES Region(identificador);

CREATE TABLE Raza(
	identificador INT,
	nombre TEXT,
	region INT,
    CONSTRAINT pkRaza PRIMARY KEY(identificador),
    CONSTRAINT fk1Raza FOREIGN KEY(region) REFERENCES Region(identificador),
	CONSTRAINT ch1Raza CHECK(identificador > 0 AND identificador < 14)
);

CREATE TABLE Jugador(
    nombre TEXT,
    genero TEXT,
    color_de_piel TEXT,
    nivel INT,
    raza INT,
    clase INT,
    faccion INT,
    ubicacion INT,
    conectado boolean,
    CONSTRAINT pkJugador PRIMARY KEY(nombre),
    CONSTRAINT fk1Jugador FOREIGN KEY(raza, clase) REFERENCES RazaClase(raza, clase),
    CONSTRAINT fk2Jugador FOREIGN KEY(raza, faccion) REFERENCES RazaFaccion(raza, faccion),
    CONSTRAINT fk3Jugador FOREIGN KEY(ubicacion) REFERENCES Sitio(identificador),
    CONSTRAINT ch1Jugador CHECK(genero = 'Masculino' OR genero = 'Femenino'),
    CONSTRAINT ch2Jugador CHECK(color_de_piel = 'Blanco' OR color_de_piel = 'Negro' OR color_de_piel = 'Moreno'),
    CONSTRAINT ch3Jugador CHECK(conectado = true OR conectado = false),
    CONSTRAINT un1Jugador UNIQUE(nombre)
);

CREATE TABLE Objeto(
    identificador INT,
    nombre TEXT,
    tipo TEXT,
    nivel_requerido INT,
    equipado boolean,
    jugador TEXT,
    CONSTRAINT pkObjeto PRIMARY KEY(identificador),
    CONSTRAINT fk1Objeto FOREIGN KEY(jugador) REFERENCES Jugador(nombre)
);

CREATE TABLE Encantamiento(
    identificador INT,
    nombre TEXT,
    CONSTRAINT pkEncantamiento PRIMARY KEY(identificador)
);

-- Tablas JOIN

CREATE TABLE RazaFaccion(
	raza INT,
	faccion INT,
    CONSTRAINT pkRazaFaccion PRIMARY KEY(raza, faccion),
    CONSTRAINT fk1RazaFaccion FOREIGN KEY(raza) REFERENCES Raza(identificador),
    CONSTRAINT fk2RazaFaccion FOREIGN KEY(faccion) REFERENCES Faccion(identificador),
    CONSTRAINT ch1RazaFaccion CHECK(
        (faccion = 1 AND raza IN (1,2,3,4,5,6,13)) OR
        (faccion = 2 AND raza IN (7,8,9,10,11,12,13))
    )
);

CREATE TABLE RazaClase(
	raza INT,
	clase INT,
    CONSTRAINT pkRazaClase PRIMARY KEY(raza,clase),
    CONSTRAINT fk1RazaClase FOREIGN KEY(raza) REFERENCES Raza(identificador),
	CONSTRAINT fk2RazaClase FOREIGN KEY(clase) REFERENCES Clase(identificador),
	CONSTRAINT ch1RazaClase CHECK(
		(NOT (raza IN (1,11) AND clase IN (6,10))) AND
		(NOT (raza = 2 AND clase = 10)) AND
		(NOT (raza = 3 AND clase IN (2,6,8))) AND
		(NOT (raza IN (4,8) AND clase IN (2,6,10))) AND
		(NOT (raza = 5 AND clase IN (4,8,10))) AND
		(NOT (raza = 6 AND clase IN (2,6,9))) AND
		(NOT (raza = 7 AND clase IN (2,5,10))) AND
		(NOT (raza = 9 AND clase IN (3,7,8))) AND
		(NOT (raza = 10 AND clase = 2)) AND
		(NOT (raza = 12 AND clase IN (2,9,10))) AND
		(NOT (raza = 13 AND clase IN (2,8,10)))
	)
);

CREATE TABLE ClaseAtributo(
    valor_inicial INT DEFAULT 0,
    atributo INT,
    clase INT,
    CONSTRAINT pkClaseAtributo PRIMARY KEY(atributo, clase),
    CONSTRAINT fk1ClaseAtributo FOREIGN KEY(atributo) REFERENCES Atributo(identificador),
    CONSTRAINT fk2ClaseAtributo FOREIGN KEY(clase) REFERENCES Clase(identificador),
	CONSTRAINT ch1ClaseAtributo CHECK(
		(NOT (clase IN (5,7,9) AND atributo = 4)) AND
		(NOT (clase IN (3,4) AND atributo IN(1, 3)))
	)
);

CREATE TABLE AtributoJugador(
    valor INT,
    atributo INT,
    clase INT,
    jugador TEXT,
    CONSTRAINT pkAtributoJugador PRIMARY KEY(atributo, clase, jugador),
    CONSTRAINT fk1AtributoJugador FOREIGN KEY(atributo, clase) REFERENCES ClaseAtributo(atributo, clase),
    CONSTRAINT fk2AtributoJugador FOREIGN KEY(jugador) REFERENCES jugador(nombre)	
	--CONSTRAINT ch1AtributoJugador CHECK()
);

CREATE TABLE EncantamientoJugador(
    valor INT,
    encantamiento INT,
    jugador TEXT,
    CONSTRAINT pkEncantamientoJugador PRIMARY KEY(encantamiento, jugador),
    CONSTRAINT fk1EncantamientoJugador FOREIGN KEY(encantamiento) REFERENCES Encantamiento(identificador),
    CONSTRAINT fk2EncantamientoJugador FOREIGN KEY(jugador) REFERENCES jugador(nombre)	
	--CONSTRAINT ch1EncantamientoJugador CHECK()
);

CREATE TABLE AtributoObjeto(
    valor_modificador INT,
    atributo INT,
    clase INT,
    jugador TEXT,
	objeto INT,
    CONSTRAINT fk1AtributoObjeto FOREIGN KEY(atributo, clase, jugador) REFERENCES AtributoJugador(atributo, clase, jugador),
    CONSTRAINT fk2AtributoObjeto FOREIGN KEY(objeto) REFERENCES Objeto(identificador)
);

CREATE TABLE EncantamientoObjeto(
    valor_modificador INT,
    encantamiento INT,
    jugador TEXT, 
    objeto INT,
    CONSTRAINT fk1EncantamientoObjeto FOREIGN KEY(encantamiento, jugador) REFERENCES EncantamientoJugador(encantamiento, jugador),
    CONSTRAINT fk2EncantamientoObjeto FOREIGN KEY(objeto) REFERENCES Objeto(identificador)
);

-- Datos pre-establecidos

INSERT INTO Faccion(identificador,nombre) VALUES(1,'Alianza');
INSERT INTO Faccion(identificador,nombre) VALUES(2,'Horda');

INSERT INTO Continente(identificador,nombre) VALUES(1,'Azerot');
INSERT INTO Continente(identificador,nombre) VALUES(2,'Kalindor');
INSERT INTO Continente(identificador,nombre) VALUES(3,'Pandarian');

INSERT INTO Clase(identificador,nombre) VALUES(1,'Guerrero');
INSERT INTO Clase(identificador,nombre) VALUES(2,'Paladin');
INSERT INTO Clase(identificador,nombre) VALUES(3,'Cazador');
INSERT INTO Clase(identificador,nombre) VALUES(4,'Ladron');
INSERT INTO Clase(identificador,nombre) VALUES(5,'Sacerdote');
INSERT INTO Clase(identificador,nombre) VALUES(6,'Chaman');
INSERT INTO Clase(identificador,nombre) VALUES(7,'Mago');
INSERT INTO Clase(identificador,nombre) VALUES(8,'Brujo');
INSERT INTO Clase(identificador,nombre) VALUES(9,'Monge');
INSERT INTO Clase(identificador,nombre) VALUES(10,'Druida');

INSERT INTO Atributo(identificador,nombre) VALUES(1,'Intelecto');
INSERT INTO Atributo(identificador,nombre) VALUES(2,'Estamina');
INSERT INTO Atributo(identificador,nombre) VALUES(3,'Mana');
INSERT INTO Atributo(identificador,nombre) VALUES(4,'Agilidad');
INSERT INTO Atributo(identificador,nombre) VALUES(5,'Armamento');

-- FALTA AGREGAR MAS SITIOS, CON SUS RESPECTIVAS VILLAS Y ALDEAS

---Estos sitios son para poder realizar el teletransporte basándolo sólo en continentes
INSERT INTO Sitio(identificador,nombre,tipo, region) VALUES(1,'Azerot', 'Continente', NULL);
INSERT INTO Sitio(identificador,nombre,tipo, region) VALUES(2,'Kalindor', 'Continente', NULL);
INSERT INTO Sitio(identificador,nombre,tipo, region) VALUES(3,'Pandarian', 'Continente', NULL);
--

INSERT INTO Sitio(identificador,nombre,tipo,region) VALUES(4,'Vertormenta', 'Villa', NULL); 

INSERT INTO Region(identificador,nombre,ciudad_capital,continente) VALUES(1,'Region Azerot 1', 1, 1);
UPDATE Sitio SET region = 1 WHERE identificador = 1;

INSERT INTO Raza(identificador,nombre,region) VALUES(1,'Humano',1);
INSERT INTO Raza(identificador,nombre,region) VALUES(2,'Enano',1);
INSERT INTO Raza(identificador,nombre,region) VALUES(3,'Elfo de la noche',1);
INSERT INTO Raza(identificador,nombre,region) VALUES(4,'Nono',1);
INSERT INTO Raza(identificador,nombre,region) VALUES(5,'Dranei',1);
INSERT INTO Raza(identificador,nombre,region) VALUES(6,'Hombre lobo',1);
INSERT INTO Raza(identificador,nombre,region) VALUES(7,'Orco',1);
INSERT INTO Raza(identificador,nombre,region) VALUES(8,'No muerto',1);
INSERT INTO Raza(identificador,nombre,region) VALUES(9,'Tauren',1);
INSERT INTO Raza(identificador,nombre,region) VALUES(10,'Trol',1);
INSERT INTO Raza(identificador,nombre,region) VALUES(11,'Elfo de sangre',1);
INSERT INTO Raza(identificador,nombre,region) VALUES(12,'Goblin',1);
INSERT INTO Raza(identificador,nombre,region) VALUES(13,'Panda',1);

INSERT INTO Encantamiento(identificador,nombre) VALUES(1,'Golpe critico');
INSERT INTO Encantamiento(identificador,nombre) VALUES(2,'Hipnosis');
INSERT INTO Encantamiento(identificador,nombre) VALUES(3,'Suerte');
INSERT INTO Encantamiento(identificador,nombre) VALUES(4,'Veneno');

INSERT INTO RazaFaccion(raza,faccion) VALUES(1,1);
INSERT INTO RazaFaccion(raza,faccion) VALUES(2,1);
INSERT INTO RazaFaccion(raza,faccion) VALUES(3,1);
INSERT INTO RazaFaccion(raza,faccion) VALUES(4,1);
INSERT INTO RazaFaccion(raza,faccion) VALUES(5,1);
INSERT INTO RazaFaccion(raza,faccion) VALUES(6,1);
INSERT INTO RazaFaccion(raza,faccion) VALUES(7,2);
INSERT INTO RazaFaccion(raza,faccion) VALUES(8,2);
INSERT INTO RazaFaccion(raza,faccion) VALUES(9,2);
INSERT INTO RazaFaccion(raza,faccion) VALUES(10,2);
INSERT INTO RazaFaccion(raza,faccion) VALUES(11,2);
INSERT INTO RazaFaccion(raza,faccion) VALUES(12,2);
INSERT INTO RazaFaccion(raza,faccion) VALUES(13,1);
INSERT INTO RazaFaccion(raza,faccion) VALUES(13,2);

INSERT INTO RazaClase(raza,clase) VALUES(1,1);
INSERT INTO RazaClase(raza,clase) VALUES(1,2);
INSERT INTO RazaClase(raza,clase) VALUES(1,3);
INSERT INTO RazaClase(raza,clase) VALUES(1,4);
INSERT INTO RazaClase(raza,clase) VALUES(1,5);
INSERT INTO RazaClase(raza,clase) VALUES(1,7);
INSERT INTO RazaClase(raza,clase) VALUES(1,8);
INSERT INTO RazaClase(raza,clase) VALUES(1,9);

INSERT INTO RazaClase(raza,clase) VALUES(2,1);
INSERT INTO RazaClase(raza,clase) VALUES(2,2);
INSERT INTO RazaClase(raza,clase) VALUES(2,3);
INSERT INTO RazaClase(raza,clase) VALUES(2,4);
INSERT INTO RazaClase(raza,clase) VALUES(2,5);
INSERT INTO RazaClase(raza,clase) VALUES(2,6);
INSERT INTO RazaClase(raza,clase) VALUES(2,7);
INSERT INTO RazaClase(raza,clase) VALUES(2,8);
INSERT INTO RazaClase(raza,clase) VALUES(2,9);

INSERT INTO RazaClase(raza,clase) VALUES(3,1);
INSERT INTO RazaClase(raza,clase) VALUES(3,3);
INSERT INTO RazaClase(raza,clase) VALUES(3,4);
INSERT INTO RazaClase(raza,clase) VALUES(3,5);
INSERT INTO RazaClase(raza,clase) VALUES(3,7);
INSERT INTO RazaClase(raza,clase) VALUES(3,9);
INSERT INTO RazaClase(raza,clase) VALUES(3,10);

INSERT INTO RazaClase(raza,clase) VALUES(4,1);
INSERT INTO RazaClase(raza,clase) VALUES(4,3);
INSERT INTO RazaClase(raza,clase) VALUES(4,4);
INSERT INTO RazaClase(raza,clase) VALUES(4,5);
INSERT INTO RazaClase(raza,clase) VALUES(4,7);
INSERT INTO RazaClase(raza,clase) VALUES(4,8);
INSERT INTO RazaClase(raza,clase) VALUES(4,9);

INSERT INTO RazaClase(raza,clase) VALUES(5,1);
INSERT INTO RazaClase(raza,clase) VALUES(5,2);
INSERT INTO RazaClase(raza,clase) VALUES(5,3);
INSERT INTO RazaClase(raza,clase) VALUES(5,5);
INSERT INTO RazaClase(raza,clase) VALUES(5,6);
INSERT INTO RazaClase(raza,clase) VALUES(5,7);
INSERT INTO RazaClase(raza,clase) VALUES(5,9);

INSERT INTO RazaClase(raza,clase) VALUES(6,1);
INSERT INTO RazaClase(raza,clase) VALUES(6,3);
INSERT INTO RazaClase(raza,clase) VALUES(6,4);
INSERT INTO RazaClase(raza,clase) VALUES(6,5);
INSERT INTO RazaClase(raza,clase) VALUES(6,7);
INSERT INTO RazaClase(raza,clase) VALUES(6,8);
INSERT INTO RazaClase(raza,clase) VALUES(6,10);

INSERT INTO RazaClase(raza,clase) VALUES(7,1);
INSERT INTO RazaClase(raza,clase) VALUES(7,3);
INSERT INTO RazaClase(raza,clase) VALUES(7,4);
INSERT INTO RazaClase(raza,clase) VALUES(7,6);
INSERT INTO RazaClase(raza,clase) VALUES(7,7);
INSERT INTO RazaClase(raza,clase) VALUES(7,8);
INSERT INTO RazaClase(raza,clase) VALUES(7,9);

INSERT INTO RazaClase(raza,clase) VALUES(8,1);
INSERT INTO RazaClase(raza,clase) VALUES(8,3);
INSERT INTO RazaClase(raza,clase) VALUES(8,4);
INSERT INTO RazaClase(raza,clase) VALUES(8,5);
INSERT INTO RazaClase(raza,clase) VALUES(8,7);
INSERT INTO RazaClase(raza,clase) VALUES(8,8);
INSERT INTO RazaClase(raza,clase) VALUES(8,9);

INSERT INTO RazaClase(raza,clase) VALUES(9,1);
INSERT INTO RazaClase(raza,clase) VALUES(9,2);
INSERT INTO RazaClase(raza,clase) VALUES(9,4);
INSERT INTO RazaClase(raza,clase) VALUES(9,5);
INSERT INTO RazaClase(raza,clase) VALUES(9,6);
INSERT INTO RazaClase(raza,clase) VALUES(9,9);
INSERT INTO RazaClase(raza,clase) VALUES(9,10);

INSERT INTO RazaClase(raza,clase) VALUES(10,1);
INSERT INTO RazaClase(raza,clase) VALUES(10,3);
INSERT INTO RazaClase(raza,clase) VALUES(10,4);
INSERT INTO RazaClase(raza,clase) VALUES(10,5);
INSERT INTO RazaClase(raza,clase) VALUES(10,6);
INSERT INTO RazaClase(raza,clase) VALUES(10,7);
INSERT INTO RazaClase(raza,clase) VALUES(10,8);
INSERT INTO RazaClase(raza,clase) VALUES(10,9);
INSERT INTO RazaClase(raza,clase) VALUES(10,10);

INSERT INTO RazaClase(raza,clase) VALUES(11,1);
INSERT INTO RazaClase(raza,clase) VALUES(11,2);
INSERT INTO RazaClase(raza,clase) VALUES(11,3);
INSERT INTO RazaClase(raza,clase) VALUES(11,4);
INSERT INTO RazaClase(raza,clase) VALUES(11,5);
INSERT INTO RazaClase(raza,clase) VALUES(11,7);
INSERT INTO RazaClase(raza,clase) VALUES(11,8);
INSERT INTO RazaClase(raza,clase) VALUES(11,9);

INSERT INTO RazaClase(raza,clase) VALUES(12,1);
INSERT INTO RazaClase(raza,clase) VALUES(12,3);
INSERT INTO RazaClase(raza,clase) VALUES(12,4);
INSERT INTO RazaClase(raza,clase) VALUES(12,5);
INSERT INTO RazaClase(raza,clase) VALUES(12,6);
INSERT INTO RazaClase(raza,clase) VALUES(12,7);
INSERT INTO RazaClase(raza,clase) VALUES(12,8);

INSERT INTO RazaClase(raza,clase) VALUES(13,1);
INSERT INTO RazaClase(raza,clase) VALUES(13,3);
INSERT INTO RazaClase(raza,clase) VALUES(13,4);
INSERT INTO RazaClase(raza,clase) VALUES(13,5);
INSERT INTO RazaClase(raza,clase) VALUES(13,6);
INSERT INTO RazaClase(raza,clase) VALUES(13,7);
INSERT INTO RazaClase(raza,clase) VALUES(13,9);

INSERT INTO ClaseAtributo(atributo, clase) VALUES(1, 1);
INSERT INTO ClaseAtributo(valor_inicial, atributo, clase) VALUES(12, 2, 1);
INSERT INTO ClaseAtributo(atributo, clase) VALUES(3, 1);
INSERT INTO ClaseAtributo(valor_inicial, atributo, clase) VALUES(6, 4, 1);
INSERT INTO ClaseAtributo(atributo, clase) VALUES(5, 1);

INSERT INTO ClaseAtributo(atributo, clase) VALUES(1, 2);
INSERT INTO ClaseAtributo(valor_inicial, atributo, clase) VALUES(8, 2, 2);
INSERT INTO ClaseAtributo(atributo, clase) VALUES(3, 2);
INSERT INTO ClaseAtributo(valor_inicial, atributo, clase) VALUES(8, 4, 2);
INSERT INTO ClaseAtributo(atributo, clase) VALUES(5, 2);

INSERT INTO ClaseAtributo(valor_inicial, atributo, clase) VALUES(6, 2, 3);
INSERT INTO ClaseAtributo(atributo, clase) VALUES(4, 3);
INSERT INTO ClaseAtributo(atributo, clase) VALUES(5, 3);

INSERT INTO ClaseAtributo(atributo, clase) VALUES(2, 4);
INSERT INTO ClaseAtributo(atributo, clase) VALUES(4, 4);
INSERT INTO ClaseAtributo(atributo, clase) VALUES(5, 4);

INSERT INTO ClaseAtributo(valor_inicial, atributo, clase) VALUES(12, 1, 5);
INSERT INTO ClaseAtributo(atributo, clase) VALUES(2, 5);
INSERT INTO ClaseAtributo(valor_inicial, atributo, clase) VALUES(6, 3, 5);
INSERT INTO ClaseAtributo(atributo, clase) VALUES(5, 5);

INSERT INTO ClaseAtributo(atributo, clase) VALUES(1, 6);
INSERT INTO ClaseAtributo(valor_inicial, atributo, clase) VALUES(4, 2, 6);
INSERT INTO ClaseAtributo(valor_inicial, atributo, clase) VALUES(4, 3, 6);
INSERT INTO ClaseAtributo(atributo, clase) VALUES(4, 6);
INSERT INTO ClaseAtributo(atributo, clase) VALUES(5, 6);

INSERT INTO ClaseAtributo(valor_inicial, atributo, clase) VALUES(6, 1, 7);
INSERT INTO ClaseAtributo(atributo, clase) VALUES(2, 7);
INSERT INTO ClaseAtributo(valor_inicial, atributo, clase) VALUES(10, 3, 7);
INSERT INTO ClaseAtributo(atributo, clase) VALUES(5, 7);

INSERT INTO ClaseAtributo(valor_inicial, atributo, clase) VALUES(8, 1, 8);
INSERT INTO ClaseAtributo(atributo, clase) VALUES(2, 8);
INSERT INTO ClaseAtributo(valor_inicial, atributo, clase) VALUES(8, 3, 8);
INSERT INTO ClaseAtributo(valor_inicial, atributo, clase) VALUES(2, 4, 8);
INSERT INTO ClaseAtributo(atributo, clase) VALUES(5, 8);

INSERT INTO ClaseAtributo(valor_inicial, atributo, clase) VALUES(10, 1, 9);
INSERT INTO ClaseAtributo(atributo, clase) VALUES(2, 9);
INSERT INTO ClaseAtributo(valor_inicial, atributo, clase) VALUES(6, 3, 9);
INSERT INTO ClaseAtributo(atributo, clase) VALUES(5, 9);

INSERT INTO ClaseAtributo(valor_inicial, atributo, clase) VALUES(10, 1, 10);
INSERT INTO ClaseAtributo(valor_inicial, atributo, clase) VALUES(2, 2, 10);
INSERT INTO ClaseAtributo(valor_inicial, atributo, clase) VALUES(6, 3, 10);
INSERT INTO ClaseAtributo(atributo, clase) VALUES(4, 10);
INSERT INTO ClaseAtributo(atributo, clase) VALUES(5, 10);

INSERT INTO Jugador(nombre, nivel, raza, clase, faccion, ubicacion, conectado) VALUES('Erick', 0, 5, 1, 1, 1, true);
INSERT INTO Jugador(nombre, nivel, raza, clase, faccion, ubicacion, conectado) VALUES('Fazio', 0, 2, 2, 1, 1, true);
INSERT INTO Jugador(nombre, nivel, raza, clase, faccion, ubicacion, conectado) VALUES('Alonso', 0, 3, 3, 1, 1, true);
INSERT INTO Jugador(nombre, nivel, raza, clase, faccion, ubicacion, conectado) VALUES('Gonzalo', 0, 4, 4, 1, 1, false);

INSERT INTO Objeto(identificador, nombre, tipo, nivel_requerido, equipado, jugador) VALUES (1, 'Espada X', 'Arma', 5, false, 'Erick');
INSERT INTO Objeto(identificador, nombre, tipo, nivel_requerido, equipado, jugador) VALUES (2, 'Casco Z', 'Casco', 7, false, 'Gonzalo');

INSERT INTO AtributoJugador(atributo, clase, jugador, valor) VALUES(1, 1, 'Erick', 5);
INSERT INTO EncantamientoJugador(encantamiento, jugador, valor) VALUES(1, 'Erick', 0);

INSERT INTO AtributoObjeto(valor_modificador, atributo, clase, jugador, objeto) VALUES(-4, 1, 1, 'Erick', 1);

INSERT INTO EncantamientoObjeto(valor_modificador, encantamiento, jugador, objeto) VALUES(6, 1, 'Erick', 1);

-- Aqui cuando se inserta el jugador se insertan los atributos predefinidos en ClaseAtributo con el valor inicial correspondiente
INSERT INTO Jugador(nombre, nivel, raza, clase, faccion, ubicacion, conectado) VALUES ('Cosi', 0, 3, 4, 1, 1, 0);

INSERT INTO AtributoJugador(atributo, clase, jugador, valor) VALUES(2, 1, 'Cosi', 0); -- (0) SELECT ClaseAtributo.valor_inicial FROM Clase, ClaseAtributo, Atributo WHERE Clase.identificador = ClaseAtributo.clase AND ClaseAtributo.atributo = Atributo.identificador AND Clase.identificador = 4 AND Atributo.identificador = 2;
INSERT INTO AtributoJugador(atributo, clase, jugador, valor) VALUES(4, 1, 'Cosi', 0);
INSERT INTO AtributoJugador(atributo, clase, jugador, valor) VALUES(5, 1, 'Cosi', 0);



INSERT INTO Objeto(identificador, nombre, tipo, nivel_requerido, equipado, jugador) VALUES (14, 'Espada Cosi', 'Arma', 0, false, 'Cosi');
INSERT INTO AtributoObjeto(valor_modificador, atributo, clase, jugador, objeto) VALUES(3, 2, 1, 'Cosi', 14);

INSERT INTO Objeto(identificador, nombre, tipo, nivel_requerido, equipado, jugador) VALUES (15, 'Casco Cosi', 'Casco', 0, false, 'Cosi');

-- IF UPDATE A EQUIPADO EN OBJETO => SE SUBE VALOR EN ATRIBUTO JUGADOR (b). SI DESEQUIPADO => SE BAJA EL VALOR (c)

-- (b)
UPDATE Objeto
SET equipado = 1
WHERE Objeto.identificador = 14;

UPDATE AtributoJugador
SET valor = valor + (SELECT AtributoObjeto.valor_modificador FROM AtributoObjeto, AtributoJugador WHERE AtributoObjeto.clase = AtributoJugador.clase AND AtributoObjeto.atributo = AtributoJugador.atributo AND AtributoObjeto.jugador = AtributoJugador.jugador AND AtributoObjeto.clase = 1 AND AtributoObjeto.atributo = 2 AND AtributoObjeto.jugador = 'Cosi')
WHERE atributo = 2 AND clase= 1 AND jugador = 'Cosi';

-- (c)
UPDATE Objeto
SET equipado = 0
WHERE Objeto.identificador = 14;

UPDATE AtributoJugador
SET valor = valor - (SELECT AtributoObjeto.valor_modificador FROM AtributoObjeto, AtributoJugador WHERE AtributoObjeto.clase = AtributoJugador.clase AND AtributoObjeto.atributo = AtributoJugador.atributo AND AtributoObjeto.jugador = AtributoJugador.jugador AND AtributoObjeto.clase = 1 AND AtributoObjeto.atributo = 2 AND AtributoObjeto.jugador = 'Cosi')
WHERE atributo = 2 AND clase= 1 AND jugador = 'Cosi';
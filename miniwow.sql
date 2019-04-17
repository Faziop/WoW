create table Faccion(
	id int,
	nombre text,
    constraint pkFaccion primary key(id),
	constraint ch1Faccion check(id > 0 and id < 3)
);

create table Continente(
	id int,
	nombre text,
    constraint pkContinente primary key(id),
	constraint ch1Continente check(id > 0 and id < 4)
);

create table Clase(
    id int,
    nombre text,
    constraint pkClase primary key(id),
    constraint ch1Clase check(id > 0 and id < 11)
);

create table Atributo(
	id int,
	nombre text,
    constraint pkAtributo primary key(id),
	constraint ch1Atributo check(id > 0 and id < 6)
);

create table Region(
	id int,
	nombre text,
	ciudad_capital text,
	continente int,
    constraint pkRegion primary key(id),
    constraint fk1Region foreign key(continente) references Continente(id)
);

create table Raza(
	id int,
	nombre text,
	region int,
    constraint pkRaza primary key(id),
    constraint fk1Raza foreign key(region) references Region(id),
	constraint ch1Raza check(id > 0 and id < 14)
);

create table RazaFaccion(
	raza int,
	faccion int,
    constraint pkRazaFaccion primary key(raza, faccion),
    constraint fk1RazaFaccion foreign key(raza) references Raza(id),
    constraint fk2RazaFaccion foreign key(faccion) references Faccion(id),
    constraint ch1RazaFaccion check(
        (faccion = 1 and raza in (1,2,3,4,5,6,13))	or
        (faccion = 2 and raza in (7,8,9,10,11,12,13))
    )
);

create table RazaClase(
	raza int,
	clase int,
    constraint pkRazaClase primary key(raza,clase),
    constraint fk1RazaClase foreign key(raza) references Raza(id),
	constraint fk2RazaClase foreign key(clase) references Clase(id),
	constraint ch1RazaClase check(
		(raza = 1 and clase in (1,2,3,4,5,7,8,9)) or
		(raza = 2 and clase in (1,2,3,4,5,6,7,8,9)) or
		(raza = 3 and clase in (1,3,4,5,7,9,10)) or
		(raza = 4 and clase in (1,3,4,5,7,8,9))	or
		(raza = 5 and clase in (1,2,3,5,6,7,9))	or
		(raza = 6 and clase in (1,3,4,5,7,8,10)) or
		(raza = 7 and clase in (1,3,4,6,7,8,9))	or
		(raza = 8 and clase in (1,3,4,5,7,8,9))	or
		(raza = 9 and clase in (1,2,4,5,6,9,10))or
		(raza = 10 and clase in (1,3,4,5,6,7,8,9,10)) or
		(raza = 11 and clase in (1,2,3,4,5,7,8,9)) or
		(raza = 12 and clase in (1,3,4,5,6,7,8)) or
		(raza = 13 and clase in (1,3,4,5,6,7,9))
	)
);

create table Sitio(
	id int,
	nombre text,
	tipo text,
	region int,
    constraint pkSitio primary key(id),
    constraint fk1Sitio foreign key(region) references Region(id)
);

create table Jugador(
    nombre text,
    genero text,
    color_de_piel text,
    nivel int,
    raza int,
    clase int,
    faccion int,
    ubicacion int,
    constraint pkJugador primary key(nombre),
    constraint fk1Jugador foreign key(raza, clase) references RazaClase(raza, clase),
    constraint fk2Jugador foreign key(raza, faccion) references RazaFaccion(raza, faccion),
    constraint fk3Jugador foreign key(ubicacion) references Sitio(id),
    constraint ch1Jugador check(genero = 'Masculino' or genero = 'Femenino'),
    constraint ch2Jugador check(color_de_piel = 'Blanco' or color_de_piel = 'Negro' or color_de_piel = 'Moreno'),
    constraint un1Jugador unique(nombre)
);

create table AtributoClase(
    atributo int,
    clase int,
    constraint pkAtributoClase primary key(atributo, clase),
    constraint fk1AtributoClase foreign key(atributo) references Atributo(id),
    constraint fk2AtributoClase foreign key(clase) references Clase(id)
    --constraint ch1AtributoClase check()
);

create table AtributoJugador(
    atributo int,
    clase int,
    jugador text,
    valor int,
    constraint pkAtributoJugador primary key(atributo, clase, jugador),
    constraint fk1AtributoJugador foreign key(atributo, clase) references AtributoClase(atributo, clase),
    constraint fk2AtributoJugador foreign key(jugador) references jugador(nombre)	
	--constraint ch1AtributoJugador check()
);


create table Objeto(
    id int,
    nombre text,
    tipo text,
    nivel_requerido int,
    equipado text,
    jugador text,
    constraint pkObjeto primary key(id),
    constraint fk1Objeto foreign key(jugador) references Jugador(nombre)
);

create table AtributoObjeto(
    valor_modificador int,
    atributo int,
    clase int,
    jugador text,
	objeto int,
    constraint fk1AtributoObjeto foreign key(atributo, clase, jugador) references AtributoJugador(atributo, clase, jugador),
    constraint fk2AtributoObjeto foreign key(objeto) references Objeto(id)
);

insert into faccion(id,nombre) values (1,'Alianza');
insert into faccion(id,nombre) values (2,'Horda');

insert into continente(id,nombre) values(1,'Azerot');
insert into continente(id,nombre) values(2,'Kalindor');
insert into continente(id,nombre) values(3,'Pandarian');

insert into clase(id,nombre) values (1,'Guerreros');
insert into clase(id,nombre) values (2,'Paladines');
insert into clase(id,nombre) values (3,'Cazadores');
insert into clase(id,nombre) values (4,'Ladrones');
insert into clase(id,nombre) values (5,'Sacerdotes');
insert into clase(id,nombre) values (6,'Chamanes');
insert into clase(id,nombre) values (7,'Magos');
insert into clase(id,nombre) values (8,'Brujos');
insert into clase(id,nombre) values (9,'Monges');
insert into clase(id,nombre) values (10,'Druidas');

insert into atributo(id,nombre) values(1,'Intelecto');
insert into atributo(id,nombre) values(2,'Estamina');
insert into atributo(id,nombre) values(3,'Nana');
insert into atributo(id,nombre) values(4,'Agilidad');
insert into atributo(id,nombre) values(5,'Armamento');

insert into region(id) values (1);
insert into Sitio(id,nombre,tipo,region) values(1,'Ruttheran', 'Aldea', 1); 

insert into raza(id,nombre,region) values(1,'Humanos',1);
insert into raza(id,nombre,region) values(2,'Enanos',1);
insert into raza(id,nombre,region) values(3,'Elfos de la noche',1);
insert into raza(id,nombre,region) values(4,'Nonos',1);
insert into raza(id,nombre,region) values(5,'Draneis',1);
insert into raza(id,nombre,region) values(6,'Hombre lobo',1);
insert into raza(id,nombre,region) values(7,'Orco',1);
insert into raza(id,nombre,region) values(8,'No muerto',1);
insert into raza(id,nombre,region) values(9,'Tauren',1);
insert into raza(id,nombre,region) values(10,'Trol',1);
insert into raza(id,nombre,region) values(11,'Elfos de sangre',1);
insert into raza(id,nombre,region) values(12,'Goblins',1);
insert into raza(id,nombre,region) values(13,'Pandas',1);

insert into RazaFaccion(raza,faccion) values(1,1);
insert into RazaFaccion(raza,faccion) values(2,1);
insert into RazaFaccion(raza,faccion) values(3,1);
insert into RazaFaccion(raza,faccion) values(4,1);
insert into RazaFaccion(raza,faccion) values(5,1);
insert into RazaFaccion(raza,faccion) values(6,1);
insert into RazaFaccion(raza,faccion) values(7,2);
insert into RazaFaccion(raza,faccion) values(8,2);
insert into RazaFaccion(raza,faccion) values(9,2);
insert into RazaFaccion(raza,faccion) values(10,2);
insert into RazaFaccion(raza,faccion) values(11,2);
insert into RazaFaccion(raza,faccion) values(12,2);
insert into RazaFaccion(raza,faccion) values(13,1);
insert into RazaFaccion(raza,faccion) values(13,2);


		--(raza = 1 and clase in (1,2,3,4,5,7,8,9))	or --8
insert into RazaClase(raza,clase) values(1,1);
insert into RazaClase(raza,clase) values(1,2);
insert into RazaClase(raza,clase) values(1,3);
insert into RazaClase(raza,clase) values(1,4);
insert into RazaClase(raza,clase) values(1,5);
insert into RazaClase(raza,clase) values(1,7);
insert into RazaClase(raza,clase) values(1,8);
insert into RazaClase(raza,clase) values(1,9);

		--(raza = 2 and clase in (1,2,3,4,5,6,7,8,9))	or --9
insert into RazaClase(raza,clase) values(2,1);
insert into RazaClase(raza,clase) values(2,2);
insert into RazaClase(raza,clase) values(2,3);
insert into RazaClase(raza,clase) values(2,4);
insert into RazaClase(raza,clase) values(2,5);
insert into RazaClase(raza,clase) values(2,6);
insert into RazaClase(raza,clase) values(2,7);
insert into RazaClase(raza,clase) values(2,8);
insert into RazaClase(raza,clase) values(2,9);

		--(raza = 3 and clase in (1,3,4,5,7,9,10))	or --7
insert into RazaClase(raza,clase) values(3,1);
insert into RazaClase(raza,clase) values(3,3);
insert into RazaClase(raza,clase) values(3,4);
insert into RazaClase(raza,clase) values(3,5);
insert into RazaClase(raza,clase) values(3,7);
insert into RazaClase(raza,clase) values(3,9);
insert into RazaClase(raza,clase) values(3,10);

		--(raza = 4 and clase in (1,3,4,5,7,8,9))	or --7
insert into RazaClase(raza,clase) values(4,1);
insert into RazaClase(raza,clase) values(4,3);
insert into RazaClase(raza,clase) values(4,4);
insert into RazaClase(raza,clase) values(4,5);
insert into RazaClase(raza,clase) values(4,7);
insert into RazaClase(raza,clase) values(4,8);
insert into RazaClase(raza,clase) values(4,9);

		--(raza = 5 and clase in (1,2,3,5,6,7,9))	or --7
insert into RazaClase(raza,clase) values(5,1);
insert into RazaClase(raza,clase) values(5,2);
insert into RazaClase(raza,clase) values(5,3);
insert into RazaClase(raza,clase) values(5,5);
insert into RazaClase(raza,clase) values(5,6);
insert into RazaClase(raza,clase) values(5,7);
insert into RazaClase(raza,clase) values(5,9);

		--(raza = 6 and clase in (1,3,4,5,7,8,10))or --7
insert into RazaClase(raza,clase) values(6,1);
insert into RazaClase(raza,clase) values(6,3);
insert into RazaClase(raza,clase) values(6,4);
insert into RazaClase(raza,clase) values(6,5);
insert into RazaClase(raza,clase) values(6,7);
insert into RazaClase(raza,clase) values(6,8);
insert into RazaClase(raza,clase) values(6,10);

		--(raza = 7 and clase in (1,3,4,6,7,8,9))	or --7
insert into RazaClase(raza,clase) values(7,1);
insert into RazaClase(raza,clase) values(7,3);
insert into RazaClase(raza,clase) values(7,4);
insert into RazaClase(raza,clase) values(7,6);
insert into RazaClase(raza,clase) values(7,7);
insert into RazaClase(raza,clase) values(7,8);
insert into RazaClase(raza,clase) values(7,9);

		--(raza = 8 and clase in (1,3,4,5,7,8,9))	or --7
insert into RazaClase(raza,clase) values(8,1);
insert into RazaClase(raza,clase) values(8,3);
insert into RazaClase(raza,clase) values(8,4);
insert into RazaClase(raza,clase) values(8,5);
insert into RazaClase(raza,clase) values(8,7);
insert into RazaClase(raza,clase) values(8,8);
insert into RazaClase(raza,clase) values(8,9);

		--(raza = 9 and clase in (1,2,4,5,6,9,10))or --7
insert into RazaClase(raza,clase) values(9,1);
insert into RazaClase(raza,clase) values(9,2);
insert into RazaClase(raza,clase) values(9,4);
insert into RazaClase(raza,clase) values(9,5);
insert into RazaClase(raza,clase) values(9,6);
insert into RazaClase(raza,clase) values(9,9);
insert into RazaClase(raza,clase) values(9,10);

		--(raza = 10 and clase in (1,3,4,5,6,7,8,9,10))or--9
insert into RazaClase(raza,clase) values(10,1);
insert into RazaClase(raza,clase) values(10,3);
insert into RazaClase(raza,clase) values(10,4);
insert into RazaClase(raza,clase) values(10,5);
insert into RazaClase(raza,clase) values(10,6);
insert into RazaClase(raza,clase) values(10,7);
insert into RazaClase(raza,clase) values(10,8);
insert into RazaClase(raza,clase) values(10,9);
insert into RazaClase(raza,clase) values(10,10);

		--(raza = 11 and clase in (1,2,3,4,5,7,8,9))or--8
insert into RazaClase(raza,clase) values(11,1);
insert into RazaClase(raza,clase) values(11,2);
insert into RazaClase(raza,clase) values(11,3);
insert into RazaClase(raza,clase) values(11,4);
insert into RazaClase(raza,clase) values(11,5);
insert into RazaClase(raza,clase) values(11,7);
insert into RazaClase(raza,clase) values(11,8);
insert into RazaClase(raza,clase) values(11,9);

		--(raza = 12 and clase in (1,3,4,5,6,7,8))	or--7
insert into RazaClase(raza,clase) values(12,1);
insert into RazaClase(raza,clase) values(12,3);
insert into RazaClase(raza,clase) values(12,4);
insert into RazaClase(raza,clase) values(12,5);
insert into RazaClase(raza,clase) values(12,6);
insert into RazaClase(raza,clase) values(12,7);
insert into RazaClase(raza,clase) values(12,8);

		--(raza = 13 and clase in (1,3,4,5,6,7,9))	or--7
insert into RazaClase(raza,clase) values(13,1);
insert into RazaClase(raza,clase) values(13,3);
insert into RazaClase(raza,clase) values(13,4);
insert into RazaClase(raza,clase) values(13,5);
insert into RazaClase(raza,clase) values(13,6);
insert into RazaClase(raza,clase) values(13,7);
insert into RazaClase(raza,clase) values(13,9);


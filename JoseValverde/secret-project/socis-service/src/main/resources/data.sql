INSERT INTO biblioteca.usuari VALUES 
	('user1', '$2a$10$ThbA1vBeY8SAszTNBuR4iOoDkPOqbkapGtonHw4x.c0sBe90B2lPG'),
	('user2', '$2a$10$iv1B7KAmPUXnAypKQW2DgOg3YHpg3SSvX0IIRuiF7KnO1V4C5m25u'),
	('user3', '$2a$10$16rLBy83p9AoJ2tQ8rWHw.4heNtSq0kOoVNE43fJiz3gPDjpKSckO');

INSERT INTO biblioteca.tema (codi,tema) VALUES 
	 (1000,'SQL'),
	 (1001,'Agua'),
	 (1002,'Spring'),
	 (1003,'Java');
	 
INSERT INTO biblioteca.llibre (codi,titol,editorial,idioma,autor,num_eds, codi_tema) VALUES
	 (1000,'introduccion a los sistemas de Bases de Datos','Addison-Wesley','Castella','Date',5, 1000),
	 (1001,'A guide to the SQL standard','Addison-Wesley','Angles','Date',3, 1001),
	 (1002,'Un nou llibre sobre SQL','Prentice-Hall','Catal�','Martin',7, 1002),
	 (1003,'Un altre llibre sobre SQL','Prentice-Hall','Catal�','Codd',NULL, 1003);
	 
INSERT INTO biblioteca.exemplar (num_exemplar,codi_llibre,any_edicio,num_edicio) VALUES
	 (1000,1000,1993,5),
	 (1001,1000,1993,5),
	 (1002,1002,NULL,2),
	 (1003,1002,NULL,2),
	 (1004,1003,NULL,3);
	 
INSERT INTO biblioteca.soci (codi, nom,cognom,dni,adreca,codi_postal,ciutat,provincia,telefon,data_alta) VALUES
	 (1000, 'Ernest','Valveny','11111111','elpont','25600','Balaguer','Lleida','111 11 11','1993-01-01'),
	 (1001, 'Enric','Marti','22222222','elriu','25600','Balaguer','Lleida','222 22 22','1990-01-01'),
	 (1002, 'David','Lloret','33333333','lacarretera','25600','Balaguer','Lleida',NULL,'1995-01-01');
	 
	 
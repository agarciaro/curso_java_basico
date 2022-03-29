INSERT INTO biblioteca.tema (tema) VALUES
	 ('SQL'),
	 ('Agua'),
	 ('Spring'),
	 ('Java');
	 
INSERT INTO biblioteca.llibre (titol,editorial,idioma,autor,num_eds, codi_tema) VALUES
	 ('introduccion a los sistemas de Bases de Datos','Addison-Wesley','Castella','Date',5, 1),
	 ('A guide to the SQL standard','Addison-Wesley','Angles','Date',3, 1),
	 ('Un nou llibre sobre SQL','Prentice-Hall','Catal�','Martin',7, 4),
	 ('Un altre llibre sobre SQL','Prentice-Hall','Catal�','Codd',NULL, 2);
	 
INSERT INTO biblioteca.exemplar (codi_llibre,any_edicio,num_edicio) VALUES
	 (1,1993,5),
	 (1,1993,5),
	 (2,NULL,2),
	 (2,NULL,2),
	 (3,NULL,3);
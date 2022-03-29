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
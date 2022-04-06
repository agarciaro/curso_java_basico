INSERT INTO videoclub1.actor VALUES 
	(1000, 'espanyola', 'actor1', 'masculino'),
	(1001,, 'inglesa', 'actor2', 'masculino'),
	(1002,, 'francesa', 'actor3', 'femenino');
	
INSERT INTO videoclub1.pelicula VALUES 
	(2000, '1993-01-01', 'guatemalteca', 'ghimly', 'Jesucristo cazavampiros'),
	(2001, '1990-01-01', 'jamaiquina', 'ghimly', 'El viaje de chihiro'),
	(2002, '1995-01-01', 'mongola', 'ghimly', 'La ultima de Matrix');

INSERT INTO videoclub1.actor_pelicula (id_actor, id_pelicula) VALUES 
	(id_actor, id_pelicula, 'PRINCIPAL'),
	(id_actor, id_pelicula, 'SECUNDARIO'),
	(id_actor, id_pelicula, 'SECUNDARIO');

INSERT INTO videoclub1.director VALUES 
	 (3000,'alemana', 'Noah'),
	 (3001,'australiana', 'Miguel'),
	 (3002,'oscense', 'Francesc');
	 
INSERT INTO videoclub1.pelicula_director (id_pelicula, id_director) VALUES
	(id_pelicula, id_director),
	(id_pelicula, id_director),
	(id_pelicula, id_director);
	 
INSERT INTO videoclub1.ejemplar (id_pelicula) VALUES
	 (4000, 'perfecto', id_pelicula),
	 (4001, 'golpe', id_pelicula),
	 (4002, 'perfecto', id_pelicula);
	 
INSERT INTO videoclub1.socio VALUES
	 (5000, 'Calle de la piruleta','11111111','Froilan','666666666','Pequenyo Nicolas'),
	 (5001, 'Plaza de la piruleta','22222222','Pequenyo Nicolas','777777777','Jorge Javier'),
	 (5002, 'Avenida de la piruleta','33333333','Jorge Javier','666777333', 'Froilan');

INSERT INTO videoclub1.alquiler (id_ejemplar, id_socio) VALUES
	 (id_ejemplar, id_socio, '2022-02-01', '2022-01-01'),
	 (id_ejemplar, id_socio, '2022-02-10', '2022-01-10'),
	 (id_ejemplar, id_socio, '2022-02-20', '2022-01-20');
	 
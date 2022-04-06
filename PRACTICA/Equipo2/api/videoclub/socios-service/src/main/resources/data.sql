INSERT INTO Videoclub2.actor (id,nombre,nacionalidad,sexo) VALUES 
(1,'actor1', 'ESP','Macho'),
(2,'actora2', 'ESP','Hembra');

 INSERT INTO Videoclub2.socio (num_socio, direccion, nombre, telefono,avalado_por) VALUES 
(4,'vlc','juan','5',4),
(5,'vlc','alberto','7',4),
(6,'vlc','pepe','8',4);

INSERT INTO  Videoclub2.pelicula  (id,titulo,nacionalidad,productora,fecha,url) VALUES
(1,'Star Wars','ESP','Walt Disney','1995-01-29','https://youtu.be/beAH5vea99k');

INSERT INTO Videoclub2.pelicula_actores (pelicula_id,actor_id,rol) VALUES
(1,1,'PRINCIPAL');

INSERT INTO Videoclub2.pelicula_directores (pelicula_id,director_id) VALUES
(1,1);

INSERT INTO Videoclub2.ejemplar (num_ejemplar,estado_con,pelicula_id) VALUES 
(8,'Bien bonito',1);

INSERT INTO Videoclub2.director (id,nombre,nacionalidad) VALUES 
(1,'Pepito', 'ESP'),
(2,'Juanito', 'ARG'),
(3,'Albertito', 'NIG');

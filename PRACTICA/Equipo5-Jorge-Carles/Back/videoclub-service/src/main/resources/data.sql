INSERT INTO actor (id,nombre, nacionalidad, sexo, url_imagen) VALUES 
(1,'Ryan Gosling', 'Canada', 'Masculino', 'https://www.themoviedb.org/t/p/w1280/lyUyVARQKhGxaxy0FbPJCQRpiaW.jpg'),
(2,'Ryan Gosling2', 'Canada', 'Femenino', 'https://www.themoviedb.org/t/p/w1280/lyUyVARQKhGxaxy0FbPJCQRpiaW.jpg'),
(3,'Ryan Gosling3', 'Canada', 'Masculino', 'https://www.themoviedb.org/t/p/w1280/lyUyVARQKhGxaxy0FbPJCQRpiaW.jpg'),
(4,'Ryan Gosling4', 'Canada', 'Masculino', 'https://www.themoviedb.org/t/p/w1280/lyUyVARQKhGxaxy0FbPJCQRpiaW.jpg');

INSERT INTO pelicula (id,titulo, fecha, productora, url_video, url_poster, url_fondo, sinopsis) VALUES
(1,'Drive', '2011-12-28','MGM', null, 'https://www.themoviedb.org/t/p/w1280/cVWSBuCb7rzcHCRtXRlcH4XLHdX.jpg', 'https://www.themoviedb.org/t/p/w1066_and_h600_bestv2/uslmOwQpdRRUwr6AmBP6JdzeHjS.jpg', 'Durante el día, Driver trabaja en un taller y es conductor especialista de cine, pero, algunas noches de forma esporádica, trabaja como chófer para delincuentes. Shannon, su mentor y jefe, que conoce bien su talento al volante, le busca directores de cine y televisión o criminales que necesiten al mejor conductor para sus fugas, llevándose la correspondiente comisión. Pero el mundo de Driver cambia el día en que conoce a Irene, una guapa vecina que tiene un hijo pequeño y a su marido en la cárcel.'),
(2,'Drive2', '2011-01-01','MGM', null, 'https://www.themoviedb.org/t/p/w1280/cVWSBuCb7rzcHCRtXRlcH4XLHdX.jpg', 'https://www.themoviedb.org/t/p/w1066_and_h600_bestv2/uslmOwQpdRRUwr6AmBP6JdzeHjS.jpg', ''),
(3,'Drive3', '2011-01-01','MGM', null, 'https://www.themoviedb.org/t/p/w1280/cVWSBuCb7rzcHCRtXRlcH4XLHdX.jpg', 'https://www.themoviedb.org/t/p/w1066_and_h600_bestv2/uslmOwQpdRRUwr6AmBP6JdzeHjS.jpg', '');

INSERT INTO director (id,nombre, nacionalidad, url_imagen) VALUES
(1,'Nicolas Winding Refn', 'Denmark', 'https://www.themoviedb.org/t/p/w1280/sHH8M1iAVO5qtuyqNOiD6AKu8Id.jpg'),
(2,'Nicolas Winding Refn2', 'Denmark', 'https://www.themoviedb.org/t/p/w1280/sHH8M1iAVO5qtuyqNOiD6AKu8Id.jpg'),
(3,'Nicolas Winding Refn3', 'Denmark', 'https://www.themoviedb.org/t/p/w1280/sHH8M1iAVO5qtuyqNOiD6AKu8Id.jpg');


INSERT INTO socio (num_socio, dni, nombre, telefono, direccion) VALUES
(1001, '1111A', 'socio1', '6543214', 'dirección1'),
(1002, '2222A', 'socio2', '1234231', 'dirección2'),
(1003, '3333A', 'socio3', '1234321', 'dirección3');

INSERT INTO invitacion VALUES
(1001, 'CODIGO1'),
(1002, 'CODIGO2'), 
(1003, 'CODIGO3');

INSERT INTO rol (id,nombre, descripcion) VALUES
(1,'SOCIO', 'Rol de socio'),
(2,'ADMIN', 'Rol de admin');
		

	

	
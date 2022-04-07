INSERT INTO videoclub3.director VALUES
('1001','España','Pedro Almodovar'),
('1002','Corea','Bong Joon-ho'),
('1003','Estados Unidos','Steven Spielberg'),
('1004','Estados Unidos','Quentin Tarantino'),
('1005','Nueva Zelanda','Peter Jackson');

INSERT INTO videoclub3.pelicula VALUES
('1001','2000-01-01', 'Espana','Almodovar productions','Manuela recibe un duro golpe y decide huir del presente refugiándose en el pasado. Viaja hasta Barcelona, de donde salió embarazada hace dieciocho años. Va en busca de Esteban, el padre de su hijo, quien nunca supo que Manuela había sido madre.','Todo sobre mi madre',null,'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRQ-JpM4u-s1uu1_fE6Worg8SAl1YzkTUNv-i2u4GHxTE_9nKDn'),
('1002','2006-06-27', 'Corea','Showbox Entertainment','Cuenta la historia de una joven mujer, Melanie, que es capturada después de que la raza humana ha sido sustituida por extraterrestres parásitos, llamados "Souls o Almas". Después de que Melanie es impregnada con un alma','The Host',null,'https://es.web.img3.acsta.net/c_310_420/medias/nmedia/18/69/55/64/20056256.jpg'),
('1003','1982-01-21', 'Estados Unidos','Universal Pictures','E.T. narra la amistad entre Elliott, un chico solitario de diez años, y un visitante de otro planeta que pierde su nave espacial. Elliott lleva a E.T. a su casa, donde vive con su madre, su hermana y el hermano mayor','E.T',null,'https://pics.filmaffinity.com/e_t_the_extra_terrestrial-391240254-large.jpg'),
('1004','2019-10-25', 'Corea','Barunson E&A','Tanto Gi Taek como su familia están sin trabajo. Cuando su hijo mayor, Gi Woo, empieza a recibir clases particulares en la adinerada casa de Park, las dos familias, que tienen mucho en común pese a pertenecer a dos mundos totalmente distintos','Parásitos',null,'https://es.web.img3.acsta.net/c_310_420/pictures/19/09/17/17/13/3740579.jpg'),
('1005','2001-06-30', 'Nueva Zelanda','Howard Shore, Suzana Peric','En la Segunda Edad de la Tierra Media, los señores de los Elfos, los Enanos y los Hombres reciben anillos de poder. Sin saberlo, el Señor Oscuro Sauron forja el anillo Único en el Monte del Destino.','El Señor de los Anillos: la Comunidad del Anillo',null,'https://pics.filmaffinity.com/El_se_or_de_los_anillos_La_comunidad_del_anillo-744631610-large.jpg'),
('1006','1994-01-20', 'Nueva Zelanda','Fontana Productions','En 1950, en la ciudad de Christchurch, Nueva Zelanda, Pauline Parker (Melanie Lynskey) una muchacha de 14 años, procedente de una familia de pocos recursos, traba amistad con una joven británica de 15 años.','Criaturas celestiales',null,'https://m.media-amazon.com/images/I/71hqg7o56lL._SL1146_.jpg'),
('1007','2003-01-20', 'Estados Unidos','Miramax','Una mujer embarazada, identificada como la Novia, es masacrada y tiroteada en la cabeza, en el ensayo de su boda en una pequeña iglesia al sur de Texas, por sus antiguos camaradas del Escuadrón Asesino Víbora Letal','Kill Bill',null,'https://cartelera.elpais.com/assets/uploads/2019/07/26030116/C_00931.jpg'),
('1008','1994-05-12', 'Estados Unidos','Jersey Films','Pulp Fiction está narrada en un orden no cronológico y cuenta tres historias entrelazadas. La primera de ellas sigue al asesino a sueldo Vincent Vega mientras se ocupa de cuidar de Mia Wallace.','Pulp Fiction',null,'https://i.ebayimg.com/images/g/GZ0AAOSwLYdftxY~/s-l1600.jpg'),
('1009','2019-02-28', 'Estados Unidos','Columbia Pictures','En febrero de 1969, el actor de Hollywood, Rick Dalton, protagonista de la serie de televisión western Bounty Law, teme que, al no ser ya tan joven, su carrera haya terminado.','Once Upon a Time in Hollywood',null,'https://m.media-amazon.com/images/I/815BZqTNrsL._AC_SY679_.jpg'),
('1010','1991-07-14', 'España','Canal+','Rebeca, una locutora de noticias de televisión, está en el aeropuerto de Madrid esperando ansiosamente el regreso de su madre a quien no ha visto desde que era una niña. Su madre, Becky del Páramo, una famosa cantante de antorchas.','Tacones lejanos',null,'https://m.media-amazon.com/images/I/51772dbdMXL._SY445_.jpg'),
('1011','2006-01-11', 'España','El Deseo S.A.','Según las propias palabras de Almodóvar, la película nos habla de «tres generaciones de mujeres [que] sobreviven al viento solano, al fuego, a la locura, a la superstición e incluso a la muerte a base de bondad.','Volver',null,'https://m.media-amazon.com/images/I/512G89YTSUL._SY445_.jpg');



INSERT INTO videoclub3.pelicula_director VALUES 
('1001', '1001'),
('1002', '1002'),
('1003', '1003'),
('1004','1002');


INSERT INTO videoclub3.actor VALUES
('1001','España','Cecilia Roth','Femenino'),
('1002','España','Candela Peña','Femenino'),
('1003','España','Fernando Fernán Gómez','Masculino');


INSERT INTO videoclub3.actor_pelicula VALUES
('1001', '1001', 'PRINCIPAL'),
('1002', '1001', 'SECUNDARIO'),
('1003', '1001', 'SECUNDARIO');
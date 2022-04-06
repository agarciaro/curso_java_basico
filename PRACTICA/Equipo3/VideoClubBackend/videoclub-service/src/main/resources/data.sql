INSERT INTO videoclub3.director VALUES
('1001','Pedro Almodovar','España'),
('1002','Bong Joon-ho','Corea'),
('1003','Steven Spielberg','Estados Unidos'),
('1004','Quentin Tarantino','Estados Unidos'),
('1005','Peter Jackson','Nueva Zelanda');

INSERT INTO videoclub3.pelicula VALUES
('1001','2000-01-01', 'Espana','Almodovar productions','Manuela recibe un duro golpe y decide huir del presente refugiándose en el pasado. Viaja hasta Barcelona, de donde salió embarazada hace dieciocho años. Va en busca de Esteban, el padre de su hijo, quien nunca supo que Manuela había sido madre.','Todo sobre mi madre',null,null),
('1002','2006-06-27', 'Corea','Showbox Entertainment','Cuenta la historia de una joven mujer, Melanie, que es capturada después de que la raza humana ha sido sustituida por extraterrestres parásitos, llamados "Souls o Almas". Después de que Melanie es impregnada con un alma','The Host',null,null),
('1003','1982-01-21', 'Estados Unidos','Universal Pictures','E.T. narra la amistad entre Elliott, un chico solitario de diez años, y un visitante de otro planeta que pierde su nave espacial. Elliott lleva a E.T. a su casa, donde vive con su madre, su hermana y el hermano mayor','E.T',null,null),
('1004','2019-10-25', 'Corea','	Barunson E&A','Tanto Gi Taek como su familia están sin trabajo. Cuando su hijo mayor, Gi Woo, empieza a recibir clases particulares en la adinerada casa de Park, las dos familias, que tienen mucho en común pese a pertenecer a dos mundos totalmente distintos','Parásitos',null,null),
('1005','2001-06-30', 'Nueva Zelanda','Howard Shore, Suzana Peric','En la Segunda Edad de la Tierra Media, los señores de los Elfos, los Enanos y los Hombres reciben anillos de poder. Sin saberlo, el Señor Oscuro Sauron forja el anillo Único en el Monte del Destino.','El Señor de los Anillos: la Comunidad del Anillo',null,null),
('1006','1994-01-20', 'Nueva Zelanda','Fontana Productions','En 1950, en la ciudad de Christchurch, Nueva Zelanda, Pauline Parker (Melanie Lynskey) una muchacha de 14 años, procedente de una familia de pocos recursos, traba amistad con una joven británica de 15 años.','Criaturas celestiales',null,null),
('1007','1994-01-20', 'Estados Unidos','Miramax','Una mujer embarazada, identificada como la Novia, es masacrada y tiroteada en la cabeza, en el ensayo de su boda en una pequeña iglesia al sur de Texas, por sus antiguos camaradas del Escuadrón Asesino Víbora Letal','Kill Bill',null,null);


INSERT INTO videoclub3.pelicula_director VALUES 
('1001', '1001'),
('1002', '1002'),
('1003', '1003'),
('1004','1002');
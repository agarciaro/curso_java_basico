INSERT INTO videoclubA.director VALUES
('1001','Pedro Almodovar', 'España'),
('1002','Bong Joon-ho', 'Corea'),
('1003','Steven Spielberg', 'Estados Unidos');

INSERT INTO videoclubA.pelicula VALUES
('1001','2000-01-01', 'Espana','Almodovar productions','Todo sobre mi madre',  null),
('1002','2006-06-27', 'Corea','Showbox Entertainment','The Host',  null),
('1003','1982-01-21', 'Estados Unidos','Universal Pictures','E.T',  null);

INSERT INTO videoclubA.pelicula_director VALUES 
('1001', '1001'),
('1002', '1002'),
('1003', '1003');
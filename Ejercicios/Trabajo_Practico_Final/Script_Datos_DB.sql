use mundial;

-- Partidos Ronda #1
 INSERT INTO partido (idPartido, Equipo1, GolesEquipo1, GolesEquipo2, Equipo2, Ronda)
 VALUES 
		('1','Argentina','1','2','Arabia Saudita','1'),
		('2','Polonia','0','0','Mexico','1'),
        ('3','Argentina','2','0','Mexico','1'),
        ('4','Arabia Saudita','0','2','Polonia','1'),
        
        ('5','Portugal','3','0','Ghana','2'),
		('6','Uruguay','2','0','Corea del Sur','2'),
        ('7','Corea del Sur','1','1','Ghana','2'),
        ('8','Portugal','1','4','Uruguay','2'),
        
		('9','Qatar','0','2','Ecuador','3'),
		('10','Senegal','0','3','Paises Bajos','3'),
        ('11','Paises Bajos','2','2','Ecuador','3'),
        ('12','Senegal','3','1','Qatar','3'),
        
		('13','Inglaterra','2','1','Iran','4'),
		('14','Estados Unidos','1','1','Gales','4'),
        ('15','Gales','1','0','Iran','4'),
        ('16','Inglaterra','2','2','Estados Unidos','4');     
     
      

INSERT INTO pronosticos (idPronosticos, Nombre, GanaEquipo1, Empate ,GanaEquipo2, idPartido)
VALUES 
		('1', 'Mariana', 'x','','','1'),
        ('2', 'Mariana', '','x','','2'),
		('3', 'Mariana', 'x','','','3'),
		('4', 'Mariana', '','','x','4'),
        
		('5', 'Pedro', 'x','','','1'),
        ('6', 'Pedro', '','','x','2'),
		('7', 'Pedro', 'x','','','3'),
		('8', 'Pedro', '','x','','4'),
        
		('9', 'Juan', 'x','','','1'),
        ('10', 'Juan', '','x','','2'),
		('11', 'Juan', 'x','','','3'),
		('12', 'Juan', 'x','','','4'),
        
		('13', 'Mariana', 'x','','','5'),
        ('14', 'Mariana', 'x','','','6'),
		('15', 'Mariana', 'x','','','7'),
		('16', 'Mariana', '','x','','8'),
        
		('17', 'Pedro', 'x','','','5'),
        ('18', 'Pedro', '','x','','6'),
		('19', 'Pedro', '','','x','7'),
		('20', 'Pedro', 'x','','','8'),
        
		('21', 'Juan', '','x','','5'),
        ('22', 'Juan', 'x','','','6'),
		('23', 'Juan', '','x','','7'),
		('24', 'Juan', '','x','','8'),
        
		('25', 'Mariana', '','x','','9'),
        ('26', 'Mariana', '','x','','10'),
		('27', 'Mariana', '','','x','11'),
		('28', 'Mariana', 'x','','','12'),
        
		('29', 'Pedro', '','','x','9'),
        ('30', 'Pedro', '','','x','10'),
		('31', 'Pedro', 'x','','','11'),
		('32', 'Pedro', '','x','','12'),
        
		('33', 'Juan', 'x','','','9'),
        ('34', 'Juan', '','x','','10'),
		('35', 'Juan', '','x','','11'),
		('36', 'Juan', '','','x','12'),
        
		('37', 'Mariana', '','','x','13'),
        ('38', 'Mariana', 'x','','','14'),
		('39', 'Mariana', '','x','','15'),
		('40', 'Mariana', 'x','','','16'),
        
		('41', 'Pedro', 'x','','','13'),
        ('42', 'Pedro', '','x','','14'),
		('43', 'Pedro', '','','x','15'),
		('44', 'Pedro', '','','x','16'),
        
		('45', 'Juan', 'x','','','13'),
        ('46', 'Juan', 'x','','','14'),
		('47', 'Juan', 'x','','','15'),
		('48', 'Juan', 'x','','','16')
        ;
    


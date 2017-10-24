CREATE TABLE reservation(
	id	 	int AUTO_INCREMENT,
	name  	varchar(20),
	status  boolean,
	primary  key(id)
); 
INSERT INTO reservation(name, status) values('salle1', true);
INSERT INTO reservation(name, status) values('salle2', true);
INSERT INTO reservation(name, status) values('salle3', false);
INSERT INTO reservation(name, status) values('ordi1', true);
INSERT INTO reservation(name, status) values('ordi2', false);
INSERT INTO reservation(name, status) values('ordi3', true);
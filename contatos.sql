create database agendaLP3;

use agendaLP3;
drop table if exists pf;
create table pf(
	id int primary key,
    tipoContato varchar(20) default 'Fisica',
    nome varchar(60),
    sobrenome varchar(60),
    endereco varchar(60),
    telefone varchar(15) unique,
    email varchar(60),
    doc1 varchar(30),
    doc2 varchar(30)
);
drop table if exists pj;
create table pj(
	id int primary key,
    tipoContato varchar(20) default 'Juridica',
    nome varchar(60),
    sobrenome varchar(60),
    endereco varchar(60),
    telefone varchar(15) unique,
    email varchar(60),
    doc1 varchar(30),
    doc2 varchar(30)
);

drop table if exists pm;
create table pm(
	id int primary key,
    tipoContato varchar(20) default 'Marciana',
    nome varchar(60),
    sobrenome varchar(4),
    endereco varchar(60),
    telefone varchar(15) unique,
    email varchar(60),
    doc1 varchar(1),
    doc2 varchar(30)
);

drop table if exists distribuidorID;
create table distribuidorID(
	id int primary key auto_increment,
    nada varchar(60)
);

CREATE VIEW verTodos as select * from pf union select * from pj union select * from pm;

select * from verTodos order by id;
select * from distribuidorID;

drop trigger if exists idDinamicoPM;
DELIMITER !!
	
	create trigger idDinamicoPM after insert on pm for each row
    begin      
        insert into distribuidorID (nada) value ("m");       
	end !!
DELIMITER ;

drop trigger if exists idDinamicoPF;
DELIMITER !!
	
	create trigger idDinamicoPF after insert on pf for each row
    begin      
        insert into distribuidorID (nada) value ("f");       
	end !!
DELIMITER ;

drop trigger if exists idDinamicoPJ;
DELIMITER !!
	
	create trigger idDinamicoPJ after insert on pj for each row
    begin      
        insert into distribuidorID (nada) value ("j");       
	end !!
DELIMITER ;

DELIMITER !!
	CREATE PROCEDURE mudarId_PF()
	BEGIN
		declare ultimoId int;
        
		select count(distribuidorID.id) into ultimoId 
			from distribuidorID where distribuidorID.id > 0;
            
		update pf set pf.id = ultimoId where pf.id = 0;
    END !!
DELIMITER ;

DELIMITER !!
	CREATE PROCEDURE mudarId_PJ()
	BEGIN
		declare ultimoId int;
        
		select count(distribuidorID.id) into ultimoId 
			from distribuidorID where distribuidorID.id > 0;
            
		update pj set pj.id = ultimoId where pj.id = 0;
    END !!
DELIMITER ;

DELIMITER !!
	CREATE PROCEDURE mudarId_PM()
	BEGIN
		declare ultimoId int;
        
		select count(distribuidorID.id) into ultimoId 
			from distribuidorID where distribuidorID.id > 0;
            
		update pm set pm.id = ultimoId where pm.id = 0;
    END !!
DELIMITER ;


insert into pj (id, nome, sobrenome, endereco, telefone, email, doc1, doc2) 
	value (0,'arroz','arroz','arroz','arroze','arroz','arroz','arroz');
call mudarId_PJ;



CREATE VIEW buscaNome as select * from pf  union select * from pj union select * from pm where nome like '%b%';

select * from buscanome where nome like '%A%';



select * from buscaNome where nome = 'b';




--drop database agendaLP3;
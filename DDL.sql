/*create schema produtora;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on produtora.* to user@'localhost';*/

use produtora;

create table usr_usuario (
    usr_id bigint unsigned not null auto_increment,
    usr_nome varchar(20) not null,
    usr_senha varchar(50) not null,
    primary key (usr_id),
    unique key uni_usuario_nome (usr_nome)
);

create table aut_autorizacao (
    aut_id bigint unsigned not null auto_increment,
    aut_nome varchar(20) not null,
    primary key (aut_id),
    unique key uni_aut_nome (aut_nome)
);

create table uau_usuario_autorizacao (
    usr_id bigint unsigned not null,
    aut_id bigint unsigned not null,
    primary key (usr_id, aut_id),
    foreign key aut_usuario_fk (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade,
    foreign key aut_autorizacao_fk (aut_id) references aut_autorizacao (aut_id) on delete restrict on update cascade
);

create table pes_pessoa(
	pes_id bigint unsigned primary key auto_increment,
    pes_nome varchar(50),
    pes_cpf bigint,
    tipo varchar(1),
    atr_fama varchar(50),
    dub_especialidade varchar(50),
    constraint pes_cpf_uk unique (pes_cpf)
);

create table fmg_filmagem (
	fmg_id bigint unsigned primary key auto_increment,
    fmg_nome varchar(50) not null,
    fmg_ano bigint not null,
    fmg_duracao float not null,
    diretor bigint unsigned,
    constraint fmg_pes_fk foreign key (diretor)
		references pes_pessoa(pes_id)
);

create table nov_novela (
	fmg_id bigint unsigned,
    nov_capitulo bigint not null,
    nov_desc_cap varchar(100) not null,
    constraint nov_fmg_fk foreign key (fmg_id)
		references fmg_filmagem(fmg_id)
);

create table flm_filme (
	fmg_id bigint unsigned,
    flm_descricao varchar(100) not null,
    constraint flm_fmg_fk foreign key (fmg_id)
		references fmg_filmagem(fmg_id)
);

create table atu_atuacao (
	pes_id bigint unsigned,
    fmg_id bigint unsigned,
    constraint atu_pk primary key(pes_id, fmg_id),
    constraint atu_fmg_fk foreign key (fmg_id)
		references fmg_filmagem(fmg_id),
	constraint atu_pes_fk foreign key (pes_id)
		references pes_pessoa(pes_id)
);

    insert into usr_usuario (usr_nome, usr_senha) values ("admin", '123');
    insert into aut_autorizacao (aut_nome) values ('ROLE_ADMIN');
    insert into uau_usuario_autorizacao values(1, 1);

    INSERT INTO pes_pessoa (pes_nome,pes_cpf,tipo) VALUES ("Luke Winters","92427130099","T"), 
                                                          ("Hop Bowman","29949872899","T");
    
    INSERT INTO pes_pessoa (pes_nome,pes_cpf,tipo,atr_fama) VALUES ("Owen Simpson","16725546299","A","Musica"),         
                                                                   ("Cairo Head","45516724899","A","Musica"), 
                                                                   ("Tyler Briggs","38314493399","D","Luta"), 
                                                                   ("Clark Knox","47725317999","D","Dança");
    
    INSERT INTO fmg_filmagem (fmg_nome,fmg_ano,fmg_duracao,diretor) VALUES ("Casa Sombria", 1998,4,1),
                                                                           ("Uma noite na floresta", 2012,4,2);
    
    INSERT INTO nov_novela (fmg_id,nov_capitulo,nov_desc_cap) VALUES (1,11,"Lorem ipsum");

    INSERT INTO flm_filme (fmg_id,flm_descricao) VALUES (2,"Lorem ipsum velit justo nec ante.");

    INSERT INTO atu_atuacao(pes_id, fmg_id) VALUES (1, 1),
                                                   (4, 1), 
                                                   (5, 1),
                                                   (1, 2),
                                                   (2, 2), 
                                                   (3, 2),
                                                   (6, 2);

                                                   
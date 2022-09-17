create table pianeta(
id_pianeta int not null,
nome varchar2(50) not null,
sistema varchar2(50) not null,
galassia varchar2(50) not null,
diametro number(11,4),
gravita number(11,4),
massa number(11,4),
volume number(11,4),
temp_min int,
temp_max int,
satelliti int,
constraint p_idpianeta primary key (id_pianeta)
);


----sequenze 
create sequence pianeta_seq;
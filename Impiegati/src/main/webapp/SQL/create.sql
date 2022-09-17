create table impiegato(
id_impiegato int not null,
nome varchar2(50) not null,
cognome varchar2(50) not null,
constraint p_idimpiegato primary key (id_impiegato)
);


----sequenze 
create sequence impiegato_seq;
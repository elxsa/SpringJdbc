drop table if exists persoane;
create table persoane (id integer not null primary key, nume varchar(40) not null,varsta int);
insert into persoane (id,nume,varsta) values (1,'Ana',20);
insert into persoane (id,nume,varsta) values (2,'Oana',21);
insert into persoane (id,nume,varsta) values (3,'Ionel',22);
insert into persoane (id,nume,varsta) values (4,'Dorel',23);
create database GDR;
use GDR;
Create table ingredients (nr int,ningr int,nom char(50),qte float,unite char(10),PRIMARY KEY(nr,ningr)); 
create table categories(nc int,sale bool,nomcat char(50),primary key(nc));
create table ref(nref int,nom char(100),primary key (nref));
create table recettes(nr int,nom char(100),nref int,nc int,instructions text,primary key(nr));

ALTER TABLE recettes ALTER COLUMN nref SET DEFAULT 0;
ALTER TABLE recettes ALTER COLUMN nc SET DEFAULT 0;

alter table ingredients add constraint FOREIGN KEY (nr) references recettes (nr) on delete cascade;
alter table recettes add constraint FOREIGN KEY (nc) references categories (nc) on delete set null;
alter table recettes add constraint FOREIGN KEY (nref) references ref (nref) on delete set null;
alter table categories add constraint check (sale =0 or sale =1);
Create table preparations(nr int, np int,dateprep date, note int, commentaire text,PRIMARY KEY(nr,np));
alter table preparations add constraint FOREIGN KEY (nr) references recettes (nr) on delete cascade;

create user 'javalink'@'localhost' identified by 'javalink';
grant all privileges on GDR.* to 'javalink'@'localhost';

insert into categories values (0,0,"sans_categorie");
insert into ref values (0,"sans_source");

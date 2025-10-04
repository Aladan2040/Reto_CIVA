-- Database: buses_db

-- DROP DATABASE IF EXISTS buses_db;

CREATE DATABASE buses_db
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Peru.1252'
    LC_CTYPE = 'Spanish_Peru.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

--Tabla de marcas
create table marca(
	id SERIAL primary key,
	nombre varchar(100) not null
);

--Tabla de buses
create table buses(
	id SERIAL primary key,
	numero_bus varchar(50) not null,
	placa varchar(20) not null,
	fecha_creacion timestamp default current_timestamp,
	caracteristicas text,
	marca_id int not null,
	estado boolean default true,
	foreign key(marca_id) references marca(id)
);

--Insertar marcas
insert into marca(nombre) values('Volvo'),('Scania'),('Fiat');

--Insertar buses
insert into buses(numero_bus, placa,caracteristicas, marca_id, estado)
values
('101','BUE-101','50 asientos, aire acondicionado', 1, true),
('102','LOL-666','40 asientos, sin aire acondicionado',2, true),
('103','JIJ-123','30 asientos, con wifi',3,true);

--Visualizar inserts

select * from marca;
select * from buses;

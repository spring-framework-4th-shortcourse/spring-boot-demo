create table tbuser(
	id serial primary key,
	name varchar(100),
	gender varchar(10),
	image varchar(200)
);

create table tbrole(
	id serial primary key,
	role varchar(20)
);

create table tbuser_role(
	user_id int4 references tbuser(id) on delete cascade,
	role_id int4 references tbrole(id) on delete cascade
);


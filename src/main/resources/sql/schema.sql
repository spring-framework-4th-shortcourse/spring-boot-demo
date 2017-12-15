create table tbuser(
	id SERIAL PRIMARY KEY,
	name varchar(100),
	gender varchar(10),
	image varchar(200)
);

create table tbrole(
	id SERIAL PRIMARY KEY,
	role varchar(20)
);

create table tbuser_role(
	user_id INT4 REFERENCES tbuser(id) ON DELETE CASCADE ,
	role_id INT4 REFERENCES tbrole(id) ON DELETE CASCADE
);
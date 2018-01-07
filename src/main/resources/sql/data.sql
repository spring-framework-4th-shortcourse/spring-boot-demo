insert into tbuser(id, name, gender, image) values(1, 'Haylee Kemmer', 'F', 'http://lorempixel.com/100/100/animals/');
insert into tbuser(id, name, gender, image) values(2, 'Isabella Weber II', 'F', 'http://lorempixel.com/100/100/nightlife/');
insert into tbuser(id, name, gender, image) values(3, 'River Beahan', 'F', 'http://lorempixel.com/100/100/people/');
insert into tbuser(id, name, gender, image) values(4, 'Bernadette Koelpin', 'F', 'http://lorempixel.com/100/100/city/');
insert into tbuser(id, name, gender, image) values(5, 'Donnie Aufderhar MD', 'F', 'http://lorempixel.com/100/100/nightlife/');
insert into tbuser(id, name, gender, image) values(6, 'Mr. Sarina Abernathy', 'F', 'http://lorempixel.com/100/100/cats/');
insert into tbuser(id, name, gender, image) values(7, 'Carli Collier', 'M', 'http://lorempixel.com/100/100/city/');
insert into tbuser(id, name, gender, image) values(8, 'Jam Micheal', 'M', 'http://lorempixel.com/100/100/city/');
insert into tbuser(id, name, gender, image) values(9, 'Rafael Lova', 'F', 'http://lorempixel.com/100/100/city/');
insert into tbuser(id, name, gender, image) values(10, 'Kitraka Nare', 'M', 'http://lorempixel.com/100/100/city/');
insert into tbuser(id, name, gender, image) values(11, 'Sofiya Cafe', 'F', 'http://lorempixel.com/100/100/city/');

--ROLE
insert into tbrole(id, role) values(8, 'USER');
insert into tbrole(id, role) values(9, 'DBA');
insert into tbrole(id, role) values(10, 'ADMIN');

--USER's ROLE
insert into tbuser_role(user_id, role_id) values(1, 8);
insert into tbuser_role(user_id, role_id) values(1, 9);
insert into tbuser_role(user_id, role_id) values(2, 8);
insert into tbuser_role(user_id, role_id) values(3, 10);
insert into tbuser_role(user_id, role_id) values(4, 9);
insert into tbuser_role(user_id, role_id) values(5, 8);
insert into tbuser_role(user_id, role_id) values(6, 10);
insert into tbuser_role(user_id, role_id) values(7, 9);
insert into tbuser_role(user_id, role_id) values(8, 9);
insert into tbuser_role(user_id, role_id) values(9, 8);
insert into tbuser_role(user_id, role_id) values(10, 9);
insert into tbuser_role(user_id, role_id) values(11, 10);

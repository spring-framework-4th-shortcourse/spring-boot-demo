-- USER
insert into tbuser(id, name, gender, image) values(1, 'Isabella Weber II', 'F', 'http://lorempixel.com/100/100/nightlife/');
insert into tbuser(id, name, gender, image) values(2, 'River Beahan', 'F', 'http://lorempixel.com/100/100/people/');
insert into tbuser(id, name, gender, image) values(3, 'Bernadette Koelpin', 'F', 'http://lorempixel.com/100/100/city/');
insert into tbuser(id, name, gender, image) values(4, 'Donnie Aufderhar MD', 'F', 'http://lorempixel.com/100/100/nightlife/');
insert into tbuser(id, name, gender, image) values(5, 'Mr. Sarina Abernathy', 'F', 'http://lorempixel.com/100/100/cats/');
insert into tbuser(id, name, gender, image) values(6, 'Carli Collier', 'M', 'http://lorempixel.com/100/100/city/');
insert into tbuser(id, name, gender, image) values(7, 'Eduardo Homenick', 'M', 'http://lorempixel.com/100/100/cats/');
insert into tbuser(id, name, gender, image) values(8, 'Rachael Kris', 'M', 'http://lorempixel.com/100/100/animals/');
insert into tbuser(id, name, gender, image) values(9, 'Mr. Cleo Rogahn', 'M', 'http://lorempixel.com/100/100/technics/');
insert into tbuser(id, name, gender, image) values(10, 'Sam Konopelski', 'M', 'http://lorempixel.com/100/100/cats/');

-- ROLE
insert into tbrole(id, role) values(11, 'USER');
insert into tbrole(id, role) values(12, 'ADMIN');

-- USER'S ROLE
insert into tbuser_role(user_id, role_id) values(1, 12);
insert into tbuser_role(user_id, role_id) values(2, 11);
insert into tbuser_role(user_id, role_id) values(3, 11);
insert into tbuser_role(user_id, role_id) values(4, 11);
insert into tbuser_role(user_id, role_id) values(5, 11);
insert into tbuser_role(user_id, role_id) values(6, 11);
insert into tbuser_role(user_id, role_id) values(7, 11);
insert into tbuser_role(user_id, role_id) values(8, 11);
insert into tbuser_role(user_id, role_id) values(9, 11);
insert into tbuser_role(user_id, role_id) values(10, 12);






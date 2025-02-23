CREATE TABLE categories (
   id SERIAL PRIMARY KEY,
   name TEXT UNIQUE NOT NULL
);

create table todo_roles (
	id serial primary key not null,
    name varchar(2000)
);

create table todo_user
(
    id serial primary key,
	name varchar not null,
	login varchar unique not null,
	password varchar not null,
	role_id int not null references todo_roles (id)
);

create table tasks (
   id serial primary key,
   name character(60),
   description TEXT,
   created TIMESTAMP,
   completion timestamp NOT NULL DEFAULT CURRENT_DATE,
   done BOOLEAN default false,
   user_id int not null references todo_user (id),
   category_id int references categories(id)
);

CREATE TABLE participates (
   id serial PRIMARY KEY,
   task_id int not null REFERENCES tasks (id),
   category_id int not null REFERENCES categories (id),
   UNIQUE (task_id, category_id)
);

insert into categories(name) values ('Категория_1');
insert into categories(name) values ('Категория_2');
insert into categories(name) values ('Категория_3');
insert into categories(name) values ('Категория_4');

insert into todo_roles(name) values ('admin');
insert into todo_roles(name) values ('user');


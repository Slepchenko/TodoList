CREATE TABLE categories (
   id SERIAL PRIMARY KEY,
   name TEXT UNIQUE NOT NULL
);

CREATE TABLE todo_roles (
	id SERIAL PRIMARY KEY,
    name VARCHAR (2000)
);

CREATE TABLE todo_user
(
    id SERIAL PRIMARY KEY,
	name VARCHAR NOT NULL,
	login VARCHAR UNIQUE NOT NULL,
	password VARCHAR NOT NULL,
	role_id INT NOT NULL REFERENCES todo_roles (id)
);

CREATE TABLE tasks (
   id SERIAL PRIMARY KEY,
   name VARCHAR,
   description TEXT,
   created TIMESTAMP,
   completion TIMESTAMP NOT NULL DEFAULT CURRENT_DATE,
   done BOOLEAN DEFAULT FALSE,
   user_id INT NOT NULL REFERENCES todo_user (id),
   category_id INT REFERENCES categories(id)
);

CREATE TABLE participates (
   id SERIAL PRIMARY KEY,
   task_id INT NOT NULL REFERENCES tasks (id),
   category_id INT NOT NULL REFERENCES categories (id),
   UNIQUE (task_id, category_id)
);

INSERT INTO categories(name) VALUES ('Категория_1');
INSERT INTO categories(name) VALUES ('Категория_2');
INSERT INTO categories(name) VALUES ('Категория_3');
INSERT INTO categories(name) VALUES ('Категория_4');

INSERT INTO todo_roles(name) VALUES ('admin');
INSERT INTO todo_roles(name) VALUES ('user');


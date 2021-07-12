DROP TABLE IF EXISTS Client;
DROP TABLE IF EXISTS GL_CLIENT;
DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS Car;
DROP TABLE IF EXISTS Engine;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS tag;
DROP TABLE IF EXISTS blog;
DROP TABLE IF EXISTS blog_tag;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS person;
DROP SEQUENCE IF EXISTS client_sequence;
DROP SEQUENCE IF EXISTS engine_sequence;
DROP SEQUENCE IF EXISTS car_sequence;
DROP SEQUENCE IF EXISTS post_sequence;
DROP SEQUENCE IF EXISTS comment_sequence;
DROP SEQUENCE IF EXISTS blog_sequence;
DROP SEQUENCE IF EXISTS tag_sequence;
DROP SEQUENCE IF EXISTS person_sequence;
DROP SEQUENCE IF EXISTS address_sequence;

create table GL_CLIENT
(
    id INT not null,
    first_name varchar(255),
    surname varchar(255),
    gender varchar(255),
    enrollment_date timestamp ,
    active varchar(1) ,
    primary key (id)
);

CREATE SEQUENCE client_sequence INCREMENT 10 START 100;

create table Customer
(
    id INT not null,
    primary key (id)
);

CREATE SEQUENCE engine_sequence INCREMENT BY 10 START WITH 100;
create table engine
(
    engine_id INT not null,
    name varchar(255),
    primary key (engine_id)
);

CREATE SEQUENCE car_sequence INCREMENT BY 10 START WITH 100;

create table Car
(
    car_id INT not null,
    name varchar(255),
    car_engine_id INT not null,
    primary key (car_id),
    CONSTRAINT fk_engine_id FOREIGN KEY (car_engine_id) REFERENCES engine (engine_id)
);

CREATE SEQUENCE post_sequence INCREMENT BY 10 START WITH 100;

create table Post
(
    id INT not null,
    title varchar(255),
    primary key (id)
);

CREATE SEQUENCE comment_sequence INCREMENT BY 10 START WITH 100;

create table comment
(
    id INT not null,
    post_id int,
    primary key (id),
    CONSTRAINT fk_post_id FOREIGN KEY (post_id) REFERENCES Post (id)
);


CREATE SEQUENCE blog_sequence INCREMENT BY 10 START WITH 100;

create table Blog
(
    id INT not null,
    title varchar(255),
    primary key (id)
);


CREATE SEQUENCE tag_sequence INCREMENT BY 10 START WITH 100;

create table Tag
(
    id INT not null,
    name varchar(255),
    primary key (id)
);

create table blog_tag
(
    blog_id INT not null,
    tag_id INT not null
);

insert into tag (id, name) values (1, 'word');
insert into tag (id, name) values (2, 'programing');
insert into tag (id, name) values (3, 'java');
insert into tag (id, name) values (4, 'jpa');
insert into tag (id, name) values (5, 'dev');


insert into Blog (id, title) values (1, 'Earth');
insert into Blog (id, title) values (2, 'Hibernate');


insert into blog_tag (blog_id, tag_id) values (1, 1);
insert into blog_tag (blog_id, tag_id) values (2, 2);
insert into blog_tag (blog_id, tag_id) values (2, 3);
insert into blog_tag (blog_id, tag_id) values (2, 4);
insert into blog_tag (blog_id, tag_id) values (2, 5);



CREATE SEQUENCE address_sequence INCREMENT BY 10 START WITH 100;

create table address
(
    id INT not null,
    value varchar(255),
    person_id int,
    primary key (id),
    CONSTRAINT fk_person_id FOREIGN KEY (person_id) REFERENCES address (id)
);

CREATE SEQUENCE person_sequence INCREMENT BY 10 START WITH 100;

create table person
(
    id INT not null,
    name varchar(255),
    primary key (id)
);

insert into person (id, name) values (1, 'Tom Smith');

insert into address (id, value, person_id) values (1, 'Kraków ul. Fabryczna', 1);
insert into address (id, value, person_id) values (2, 'Kraków ul. Mostowa', 1);

insert into person (id, name) values (2, 'Jan Smith');

insert into address (id, value, person_id) values (3, 'Kraków ul. Fabryczna 3', 2);


insert into person (id, name) values (3, 'Alek Nowak');

insert into address (id, value, person_id) values (4, 'Warsaw ul. New 3', 3);



create table degree
(
    degree_id int auto_increment
        primary key,
    name      varchar(20) not null,
    constraint name
        unique (name)
);

create table lector
(
    lector_id int auto_increment
        primary key,
    firstname varchar(30) not null,
    lastname  varchar(40) not null,
    age       smallint    not null,
    degree    int,
    constraint lector_to_degree
        foreign key (degree) references degree (degree_id)
);

create table department
(
    department_id int auto_increment
        primary key,
    name          varchar(55) not null,
    lectors       int,
    constraint department_to_lectors
        foreign key (lectors) references lector (lector_id)
);

create table university
(
    university_id int auto_increment
        primary key,
    name          varchar(45) not null,
    departments   int,
    constraint name
        unique (name),
    constraint university_to_departments
        foreign key (departments) references department (department_id)
);
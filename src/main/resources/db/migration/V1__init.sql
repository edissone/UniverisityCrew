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
    salary    decimal(8, 2),
    degree    int,
    constraint lector_to_degree
        foreign key (degree) references degree (degree_id)
);

create table department
(
    department_id int auto_increment
        primary key,
    name          varchar(55) not null,
    head          int not null,
    lectors       int,
    constraint department_to_lectors
        foreign key (lectors) references lector (lector_id),
    constraint head_of_department
        foreign key (head) references lector (lector_id)
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
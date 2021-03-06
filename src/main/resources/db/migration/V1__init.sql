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
    head          int,
    constraint head_of_department
        foreign key (head) references lector (lector_id)
);

create table department_to_lector
(
    department_id int not null,
    lector_id     int not null,
    primary key (department_id, lector_id),
    constraint lector_dl_key
        foreign key (lector_id) references lector (lector_id),
    constraint department_dl_key
        foreign key (department_id) references department (department_id)
);

create table university
(
    university_id int auto_increment
        primary key,
    name          varchar(45) not null,
    constraint name
        unique (name)
);

create table university_to_department
(
    university_id int not null,
    department_id int not null,
    primary key (university_id, department_id),
    constraint university_ud_key
        foreign key (university_id) references university (university_id),
    constraint department_ud_key
        foreign key (department_id) references department (department_id)
);
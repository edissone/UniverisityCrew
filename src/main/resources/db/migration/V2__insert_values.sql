insert into degree(degree_id, name)
values (1, 'Assistant'),
       (2, 'Associate professor'),
       (3, 'Professor');

insert into lector(lector_id, firstname, lastname, age, salary, degree)
values (1, 'John', 'Atomic', 27, 14000.0, 1),
       (2, 'Jane', 'Atomic', 25, 12000.0, 2),
       (3, 'Jess', 'Atomic', 22, 11000.0, 2),
       (4, 'Miste', 'Mist', 57, 25000.0, 3),

       (5, 'John', 'Ford', 27, 14000.0, 1),
       (6, 'Jane', 'Ford', 25, 12000.0, 2),
       (7, 'Clar', 'Mist', 60, 27000.0, 3),

       (8, 'John', 'Clay', 27, 18000.0, 1),
       (9, 'Jane', 'Clay', 25, 22000.0, 2),
       (10, 'Harry', 'Potter', 45, 31000.0, 3);

insert into university(university_id, name)
values (1, 'University of IT'),
       (2, 'University of Science');

insert into department(department_id, name, head, university)
values (1, 'Department A', 4, 1),
       (2, 'Department B', 7, 1),
       (3, 'Department C', 10, 2);

insert into department_to_lector (department_id, lector_id)
values (1, 1), (1,2), (1, 3), (1,4), (2, 5), (2, 6), (2, 7), (3, 8), (3, 9), (3, 10);
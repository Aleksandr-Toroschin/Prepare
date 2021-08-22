create table students (
    id bigserial primary key,
    name varchar(250),
    age integer
);

insert into students (name, age)
values
('Петя', 16),
('Коля', 20),
('Вася', 22);
create table if not exists student
(
    id integer not null,
    name varchar(255) not null,
    passport_number varchar(255) not null,
    primary key(id)
);
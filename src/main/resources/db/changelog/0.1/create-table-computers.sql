--liquibase formatted sql

--changeset me:create-table-computers
create table computers
(
    id          uuid primary key,
    form_factor varchar(20) not null
        check (form_factor in ('DESKTOP', 'NETTOP', 'MONOBLOCK')),
    constraint fk_computers_product foreign key (id) references products (id) on delete cascade
);
--liquibase formatted sql

--changeset me:create-table-products
create table products
(
    id            uuid primary key        default gen_random_uuid(),
    serial_number varchar(100)   not null unique,
    manufacturer  varchar(100)   not null,
    price         numeric(10, 2) not null check (price >= 0),
    quantity      int            not null default 0 check (quantity >= 0)
);
--liquibase formatted sql

--changeset me:create-table-laptops
create table laptops
(
    id          uuid primary key,
    laptop_size varchar(10)
        check (laptop_size in ('INCH_13', 'INCH_14', 'INCH_15', 'INCH_17')),
    constraint fk_laptops_product foreign key (id) references products (id) on delete cascade
);
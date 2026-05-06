--liquibase formatted sql

--changeset me:create-table-monitors
create table monitors
(
    id       uuid primary key,
    diagonal numeric(4, 1),
    constraint fk_monitors_product foreign key (id) references products (id) on delete cascade
);
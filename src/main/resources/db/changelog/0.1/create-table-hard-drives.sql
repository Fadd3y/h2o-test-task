--liquibase formatted sql

--changeset me:create-table-hard-drives
create table hard_drives
(
    id          uuid primary key,
    capacity_gb int not null check (capacity_gb > 0),
    constraint fk_monitors_product foreign key (id) references products (id) on delete cascade
);
drop table if exists grocery_list_items;
drop table if exists grocery_lists;

create table grocery_lists (
        id bigint auto_increment primary key,
        name varchar(255) not null
);

create table grocery_list_items (
        id bigint auto_increment primary key,
        grocery_list_id bigint not null,
        name varchar(255) not null,
        quantity int,
        completed boolean,
        completed_by varchar(255),
        foreign key (grocery_list_id) references grocery_lists(id) on delete cascade
);
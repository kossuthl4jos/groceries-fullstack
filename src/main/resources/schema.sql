create table if not exists grocery_lists (
        id varchar(36) primary key,
        name varchar(255) not null,
        created_at timestamp not null default current_timestamp,
        updated_at timestamp not null default current_timestamp
);

create table if not exists grocery_list_items (
        id varchar(36) primary key,
        grocery_list_id varchar(36) not null,
        name varchar(255) not null,
        quantity int,
        completed boolean,
        completed_by varchar(255),
        created_at timestamp not null default current_timestamp,
        updated_at timestamp not null default current_timestamp,
        foreign key (grocery_list_id) references grocery_lists(id) on delete cascade
);
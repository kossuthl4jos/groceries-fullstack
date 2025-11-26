create table if not exists grocery_lists (
        id varchar(36) primary key,
        name varchar(255) not null,
        grocery_list_items json not null,
        created_at timestamp not null default current_timestamp,
        updated_at timestamp not null default current_timestamp
);
create table if not exists grocery_list_items (
        id varchar(36) primary key,
        name varchar(255) not null,
        quantity int,
        completed boolean,
        completed_by varChar(355),
        created_at timestamp not null default current_timestamp,
        updated_at timestamp not null default current_timestamp
)
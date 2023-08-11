create table author
(
    author_global_id bigint unsigned not null
        primary key,
    name             varchar(32)     not null,
    avatar           varchar(512)    null,
    profile          varchar(512)    null,
    constraint author_uk_author_global_id
        unique (author_global_id),
    constraint author_uk_name
        unique (name)
);


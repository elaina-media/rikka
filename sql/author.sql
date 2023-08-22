create table `0_sample_author`
(
    author_global_id bigint unsigned auto_increment
        primary key,
    name             varchar(50)  not null,
    avatar           varchar(256) null,
    profile          varchar(256) null,
    constraint author_global_id
        unique (author_global_id),
    constraint name
        unique (name)
);


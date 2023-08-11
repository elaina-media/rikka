create table uploader
(
    uploader_global_id bigint unsigned not null
        primary key,
    name             varchar(32)     not null,
    avatar           varchar(512)    null,
    profile          varchar(512)    null,
    constraint uploader_uk_uploader_global_id
        unique (uploader_global_id),
    constraint uploader_uk_name
        unique (name)
);
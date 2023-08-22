create table `0_sample_uploader`
(
    uploader_global_id bigint unsigned auto_increment
        primary key,
    name               varchar(24)  not null,
    avatar             varchar(256) null,
    profile            varchar(256) null,
    constraint name
        unique (name),
    constraint uploader_global_id
        unique (uploader_global_id)
);


create table `0_sample_collection`
(
    collection_global_id  bigint unsigned auto_increment
        primary key,
    title                 varchar(50)       not null,
    description           varchar(3000)     null,
    cover_url             varchar(256)      not null,
    first_media_global_id bigint unsigned   not null,
    first_media_type      varchar(15)       not null,
    uploader_global_id    bigint unsigned   not null,
    bookmark_count        int     default 0 not null,
    like_count            int     default 0 not null,
    view_count            int     default 0 not null,
    grading               tinyint default 0 not null,
    tags                  varchar(300)      null,
    create_time           datetime          not null,
    update_time           datetime          not null,
    constraint collection_global_id
        unique (collection_global_id)
);


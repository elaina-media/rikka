create table `0_sample_artwork`
(
    artwork_global_id        bigint unsigned      not null
        primary key,
    title                    varchar(50)          not null,
    description              varchar(3000)        null,
    cover_url                varchar(256)         not null,
    uploader_global_id       bigint unsigned      not null,
    uploader_name            varchar(32)          not null,
    author_global_id         bigint unsigned      null,
    author_name              varchar(32)          not null,
    pages_count              int        default 1 not null,
    image_global_id          bigint unsigned      not null,
    bookmark_count           int        default 0 null,
    like_count               int        default 0 null,
    view_count               int        default 0 null,
    grading                  tinyint    default 0 not null,
    tags                     varchar(256)         null,
    create_time              datetime             not null,
    update_time              datetime             not null,
    is_collected             tinyint(1) default 0 not null,
    collection_global_id     bigint unsigned      null,
    collection_order         int                  null,
    next_media_global_id     bigint unsigned      null,
    next_media_type          varchar(15)          null,
    next_media_title         varchar(50)          null,
    previous_media_global_id bigint unsigned      null,
    previous_media_type      varchar(15)          null,
    previous_media_title     varchar(50)          null,
    constraint artwork_global_id
        unique (artwork_global_id)
);
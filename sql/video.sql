create table `0_sample_video`
(
    video_global_id          bigint unsigned      not null
        primary key,
    title                    varchar(50)          not null,
    description              varchar(3000)        null,
    url_small                varchar(256)         not null,
    uploader_global_id       bigint unsigned      not null,
    author_global_id         bigint unsigned      not null,
    url                      varchar(256)         null,
    format                   varchar(20)          not null,
    wide                     int                  not null,
    height                   int                  not null,
    fps                      smallint             not null,
    bit_rate                 int                  not null,
    bookmark_count           int        default 0 not null,
    like_count               int        default 0 not null,
    view_count               int        default 0 not null,
    grading                  tinyint              not null,
    tags                     varchar(256)         null,
    create_time              datetime             not null,
    update_time              datetime             not null,
    is_collected             tinyint(1) default 0 not null,
    collection_global_id     bigint unsigned      null,
    collection_order         int                  null,
    next_media_global_id     bigint unsigned      null,
    next_media_type          varchar(20)          null,
    next_media_title         varchar(50)          null,
    previous_media_global_id bigint unsigned      null,
    previous_media_type      varchar(20)          null,
    previous_media_title     varchar(50)          null,
    constraint title
        unique (title),
    constraint video_global_id
        unique (video_global_id)
);


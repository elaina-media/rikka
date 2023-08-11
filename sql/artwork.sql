create table artwork
(
    artwork_global_id        bigint unsigned                         not null
        primary key,
    title                    varchar(32)                             not null,
    description              varchar(3000)                           null,
    cover_url                varchar(512)                            null,
    uploader_global_id       bigint unsigned                         not null,
    uploader_name            varchar(32)                             not null,
    author_global_id         bigint unsigned                         not null,
    author_name              varchar(32)                             not null,
    pages_count              int                                     null,
    image_global_id          bigint unsigned                         not null,
    bookmark_count           int        default 0                    not null,
    like_count               int        default 0                    not null,
    grading                  enum ('ALL_AGES', 'R15', 'R18', 'R18G') not null,
    tags                     varchar(350)                            null,
    create_time              datetime                                not null,
    update_time              datetime                                not null,
    is_collected             tinyint(1) default 0                    not null,
    collection_global_id     bigint unsigned                         null,
    collection_order         int                                     null,
    next_media_global_id     bigint unsigned                         null,
    next_media_type          enum ('Artwork', 'Video')               null,
    next_media_title         varchar(32)                             null,
    previous_media_global_id bigint unsigned                         null,
    previous_media_title     int                                     null,
    previous_media_type      enum ('Artwork', 'Video')               null,
    constraint artwork_uk_image_global_id
        unique (image_global_id),
    constraint artwork_uk_next_media_global_id
        unique (next_media_global_id),
    constraint artwork_uk_previous_media_global_id
        unique (previous_media_global_id)
);


create table `0_sample_artwork_image`
(
    image_global_id      bigint unsigned not null
        primary key,
    artwork_global_id    bigint unsigned not null,
    next_image_global_id bigint unsigned null,
    url                  varchar(256)    not null,
    constraint image_global_id
        unique (image_global_id),
    constraint next_image_global_id
        unique (next_image_global_id),
    constraint url
        unique (url)
);
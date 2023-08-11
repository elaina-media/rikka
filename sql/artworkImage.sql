create table artwork_image
(
    image_global_id      bigint unsigned not null
        primary key,
    artwork_global_id    bigint unsigned not null,
    next_image_global_id bigint unsigned null,
    url                  varchar(512)    not null,
    constraint artwork_image_uk_image_global_id
        unique (image_global_id),
    constraint artwork_image_uk_next_image_global_id
        unique (next_image_global_id),
    constraint artwork_image_uk_url
        unique (url)
);


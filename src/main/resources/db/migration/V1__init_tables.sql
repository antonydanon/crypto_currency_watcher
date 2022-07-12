drop table if exists cryptocurrency cascade;
drop table if exists watcher cascade;
drop table if exists watchers_cryptocurrencies cascade;

create table cryptocurrency (
                             id bigserial not null,
                             price_usd float4,
                             symbol varchar(255),
                             primary key (id));

create table watcher (
                      id bigserial not null,
                      price_at_registration float4,
                      username varchar(255),
                      primary key (id));

create table watchers_cryptocurrencies (
                                        watcher_id int8 not null,
                                        cryptocurrency_id int8 not null,
                                        primary key (watcher_id, cryptocurrency_id));

alter table watchers_cryptocurrencies add constraint
    FK939n1cowa3x74fqqcnqowv8aw foreign key (cryptocurrency_id) references cryptocurrency;
alter table watchers_cryptocurrencies add constraint
    FKlbeuygxy39ly8bs4i74pw50rp foreign key (watcher_id) references watcher;
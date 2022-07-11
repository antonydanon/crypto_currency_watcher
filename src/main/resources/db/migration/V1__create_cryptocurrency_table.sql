drop table if exists cryptocurrency cascade;

create table cryptocurrency (
                                id bigserial not null,
                                price_usd float4,
                                symbol varchar(255),
                                primary key (id)
                            );
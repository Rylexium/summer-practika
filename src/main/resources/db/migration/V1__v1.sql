create sequence if not exists rate_entity_model_seq start 1 increment 1;
create table if not exists rate_entity_model
(
    id             bigint,
    currency_from  varchar,
    currency_to    varchar,
    exchange_value numeric(10, 4)
);
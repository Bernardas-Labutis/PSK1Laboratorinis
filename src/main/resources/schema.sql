drop table if exists gunshopgun;
drop table if exists gunshop;
drop table if exists gun;

create table gunshop(
    id identity,
    name varchar(255),
    licencetype varchar(255)
);

create table gun(
    id identity,
    name varchar(255),
    actiontype varchar(255)
);

create table gunshopgun(
    id identity,
    gunshop_id int,
    gun_id int,
    foreign key (gunshop_id) references gunshop(id),
    foreign key (gun_id) references gun(id)
);

insert into gunshop(name) values('parduotuve');
insert into gun(name) values ('ginklas');

insert into gunshopgun(gunshop_id, gun_id) values (1, 1);

select * from PUBLIC.GUN
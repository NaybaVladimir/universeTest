create table ruler
(
    name varchar(255) not null
        constraint ruler_pkey
            primary key,
    age  integer      not null
);

alter table ruler
    owner to postgres;

INSERT INTO public.ruler (name, age) VALUES ('Екатерина', 142);
INSERT INTO public.ruler (name, age) VALUES ('Владимир', 1223);
INSERT INTO public.ruler (name, age) VALUES ('Михаил', 357);
INSERT INTO public.ruler (name, age) VALUES ('Земля', 124812);
INSERT INTO public.ruler (name, age) VALUES ('Андрей', 12);
INSERT INTO public.ruler (name, age) VALUES ('Сергей', 145);
INSERT INTO public.ruler (name, age) VALUES ('Олеся', 142);
INSERT INTO public.ruler (name, age) VALUES ('Софья', 145);
INSERT INTO public.ruler (name, age) VALUES ('Юрий', 2891);
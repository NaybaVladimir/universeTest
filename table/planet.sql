create table planet
(
    name       varchar(255) not null
        constraint planet_pkey
            primary key,
    ruler_name varchar(255)
        constraint fkijuo7lw6k0lrl70p5nuk3wigm
            references ruler
);

alter table planet
    owner to postgres;

INSERT INTO public.planet (name, ruler_name) VALUES ('Земля', 'Владимир');
INSERT INTO public.planet (name, ruler_name) VALUES ('Венера', 'Владимир');
INSERT INTO public.planet (name, ruler_name) VALUES ('Сатурн', 'Екатерина');
INSERT INTO public.planet (name, ruler_name) VALUES ('Меркурий', 'Михаил');
INSERT INTO public.planet (name, ruler_name) VALUES ('Марс', 'Земля');
INSERT INTO public.planet (name, ruler_name) VALUES ('Уран', 'Андрей');
INSERT INTO public.planet (name, ruler_name) VALUES ('Плутон', 'Андрей');
INSERT INTO public.planet (name, ruler_name) VALUES ('Kepler-186 f', null);
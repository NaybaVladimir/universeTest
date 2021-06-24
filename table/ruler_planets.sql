create table ruler_planets
(
    ruler_name   varchar(255) not null
        constraint fkn3os7phu3i7bn31u7ew57c50h
            references ruler,
    planets_name varchar(255) not null
        constraint uk_ocihtnqj7gafl0qchlh7h9iaq
            unique
        constraint fk9fwj22caomp9mvi2bh80j84a7
            references planet
);

alter table ruler_planets
    owner to postgres;

INSERT INTO public.ruler_planets (ruler_name, planets_name) VALUES ('Екатерина', 'Сатурн');
INSERT INTO public.ruler_planets (ruler_name, planets_name) VALUES ('Владимир', 'Земля');
INSERT INTO public.ruler_planets (ruler_name, planets_name) VALUES ('Владимир', 'Венера');
INSERT INTO public.ruler_planets (ruler_name, planets_name) VALUES ('Михаил', 'Меркурий');
INSERT INTO public.ruler_planets (ruler_name, planets_name) VALUES ('Земля', 'Марс');
INSERT INTO public.ruler_planets (ruler_name, planets_name) VALUES ('Андрей', 'Уран');
INSERT INTO public.ruler_planets (ruler_name, planets_name) VALUES ('Андрей', 'Плутон');
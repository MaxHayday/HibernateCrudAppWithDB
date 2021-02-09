INSERT INTO public.regions ( name)
VALUES ( 'UKR');
INSERT INTO public.regions (id, name)
VALUES (2, 'IRL');
INSERT INTO public.users (id, name, surname, role, region_id)
VALUES (1, 'Max', 'Hayday', 'USER', 1);
INSERT INTO public.users (id, name, surname, role, region_id)
VALUES (2, 'Ola', 'Hayday', 'USER', 2);
INSERT INTO public.posts (id, content, created, updated, user_id)
VALUES (1, 'Post 1 of Max', '2021-01-03 8:43:10', '2021-01-03 8:43:10', 1);
INSERT INTO public.posts (id, content, created, updated, user_id)
VALUES (2, 'Post 1 of Ola', '2021-01-03 8:43:10', '2021-01-03 8:43:10', 2);


INSERT INTO  public.users (name, surname, role, region_id)
VALUES ('Max', 'Hayday', 'USER', 1);
INSERT INTO  public.users (name, surname, role, region_id)
VALUES ('Ola', 'Hayday', 'USER', 2);
INSERT INTO  public.posts (content, created, updated, user_id)
VALUES ('Post 1 of Max', '2021-01-03 8:43:10', '2021-01-03 8:43:10', 1);
INSERT INTO  public.posts (content, created, updated, user_id)
VALUES ('Post 1 of Ola', '2021-01-03 8:43:10', '2021-01-03 8:43:10', 2);
INSERT INTO  public.regions (name)
VALUES ('UKR');
INSERT INTO  public.regions (name)
VALUES ('IRL');
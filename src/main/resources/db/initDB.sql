CREATE TABLE public.users
(
    id        BIGINT PRIMARY KEY DEFAULT nextval(0),
    name      VARCHAR(255)     NOT NULL ,
    surname   VARCHAR(255)     NOT NULL,
    role      VARCHAR(45)      NOT NULL,
    region_id BIGINT           NULL,
    FOREIGN KEY (region_id) REFERENCES regions (id) ON DELETE CASCADE
);
CREATE TABLE public.posts
(
    id      bigint primary key default nextval(0),
    content VARCHAR(255)                                   NOT NULL,
    created TIMESTAMP DEFAULT now()                        NOT NULL,
    updated TIMESTAMP                                      NOT NULL,
    user_id BIGINT                                         NULL ,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE public.regions
(
    id   BIGINT PRIMARY KEY DEFAULT nextval(0),
    name VARCHAR(45) NOT NULL
);




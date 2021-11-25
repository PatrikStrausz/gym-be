CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email    VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);

ALTER TABLE users
    ADD Constraint unq_username UNIQUE (username);
ALTER TABLE users
    ADD Constraint unq_email UNIQUE (email);



CREATE TABLE role
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100)
);

INSERT INTO role (id, name)
VALUES (1, 'ADMIN');
INSERT INTO role (id, name)
VALUES (2, 'USER');



CREATE TABLE user_details
(
    id          SERIAL PRIMARY KEY,
    firstname   VARCHAR(100) NOT NULL,
    lastname    VARCHAR(100) NOT NULL,
    height      integer      NOT NULL,
    weight      integer      NOT NULL,
    age         integer      NOT NULL,
    goal        VARCHAR(100) NOT NULL,
    user_id     integer      NOT NULL,
    training_id integer,
    diet_id     integer

);


CREATE TABLE diet
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100)
);


CREATE TABLE food_diet
(
    id      SERIAL PRIMARY KEY,
    food_id integer,
    diet_id integer

);


CREATE TABLE training
(
    id   integer PRIMARY KEY,
    name VARCHAR(100)
);


CREATE TABLE training_exercise
(
    id          SERIAL PRIMARY KEY,
    exercise_id integer,
    training_id integer
);

CREATE TABLE exercise
(
    id                 integer PRIMARY KEY,
    name               VARCHAR(100),
    exercise_type      VARCHAR(100),
    equipment_required VARCHAR(100),
    mechanics          VARCHAR(100),
    forcetype          VARCHAR(100),
    experience_level   VARCHAR(100),
    overview           TEXT,
    instructions       TEXT,
    tips               TEXT,
    image              TEXT,
    video              TEXT
);


CREATE TABLE food
(
    fdc_id           bigint PRIMARY KEY,
    data_type        VARCHAR(100),
    description      VARCHAR(100),
    food_category_id VARCHAR(100),
    publication_date VARCHAR(100)
);



CREATE TABLE exercise_muscle
(
    id          integer PRIMARY KEY,
    muscle_id   integer NOT NULL,
    exercise_id integer NOT NULL,
    is_main     boolean NOT NULL

);


CREATE TABLE food_nutrient
(
    id               integer PRIMARY KEY,
    fdc_id           integer NOT NULL,
    nutrient_id      integer NOT NULL,
    amount           double precision,
    data_points      VARCHAR(100),
    derivation_id    VARCHAR(100),
    min              VARCHAR(100),
    max              VARCHAR(100),
    median           VARCHAR(100),
    footnote         VARCHAR(100),
    min_year_acqured VARCHAR(100)

);



CREATE TABLE muscle
(

    id          integer PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    image_small TEXT         NOT NULL,
    image_big   TEXT         NOT NULL
);

CREATE TABLE nutrient
(
    id           integer PRIMARY KEY,
    name         VARCHAR(100),
    unit_name    VARCHAR(100),
    nutrient_nbr VARCHAR(100),
    rank         VARCHAR(100)
);

CREATE TABLE user_role
(
    id      SERIAL PRIMARY KEY,
    user_id integer,
    role_id integer
);



ALTER TABLE user_role
    ADD CONSTRAINT ur_fk_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE;
ALTER TABLE user_role
    ADD CONSTRAINT ur_fk_role FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE CASCADE;


ALTER TABLE user_details
    ADD CONSTRAINT ud_fk_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE;
ALTER TABLE user_details
    ADD CONSTRAINT ud_fk_training FOREIGN KEY (training_id) REFERENCES training (id) ON DELETE CASCADE;
ALTER TABLE user_details
    ADD CONSTRAINT ud_fk_diet FOREIGN KEY (diet_id) REFERENCES diet (id) ON DELETE CASCADE;


ALTER TABLE food_diet
    ADD CONSTRAINT fd_fk_food FOREIGN KEY (food_id) REFERENCES food (fdc_id) ON DELETE CASCADE;
ALTER TABLE food_diet
    ADD CONSTRAINT fd_fk_diet FOREIGN KEY (diet_id) REFERENCES diet (id) ON DELETE CASCADE;

ALTER TABLE training_exercise
    ADD CONSTRAINT te_fk_exercise FOREIGN KEY (exercise_id) REFERENCES exercise (id) ON DELETE CASCADE;
ALTER TABLE training_exercise
    ADD CONSTRAINT te_tk_training FOREIGN KEY (training_id) REFERENCES training (id) ON DELETE CASCADE;


ALTER TABLE exercise_muscle
    ADD CONSTRAINT em_fk_muscle FOREIGN KEY (muscle_id) REFERENCES muscle (id) ON DELETE CASCADE;
ALTER TABLE exercise_muscle
    ADD CONSTRAINT em_exercise FOREIGN KEY (exercise_id) REFERENCES exercise (id) ON DELETE CASCADE;

ALTER TABLE food_nutrient
    ADD CONSTRAINT fn_fk_nutrient FOREIGN KEY (nutrient_id) REFERENCES nutrient (id) ON DELETE CASCADE;

CREATE SEQUENCE user_sequence
    START 1
    INCREMENT 1
    MINVALUE 1
    OWNED BY users.id;
CREATE SEQUENCE user_details_sequence
    START 1
    INCREMENT 1
    MINVALUE 1
    OWNED BY user_details.id;
CREATE SEQUENCE food_diet_sequence
    START 1
    INCREMENT 1
    MINVALUE 1
    OWNED BY food_diet.id;
CREATE SEQUENCE user_role_sequence
    START 1
    INCREMENT 1
    MINVALUE 1
    OWNED BY user_role.id;
CREATE SEQUENCE diet_sequence
    START 1
    INCREMENT 1
    MINVALUE 1
    OWNED BY diet.id;
CREATE SEQUENCE training_exercise_sequence
    START 1
    INCREMENT 1
    MINVALUE 1
    OWNED BY training_exercise.id;







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
    id                  integer PRIMARY KEY,
    name                VARCHAR(100),
    target_muscle_group VARCHAR(100),
    exercise_type       VARCHAR(100),
    equipment_required  VARCHAR(100),
    mechanics           VARCHAR(100),
    forcetype           VARCHAR(100),
    experience_level    VARCHAR(100),
    secondary_muscles   VARCHAR(100),
    overview            TEXT,
    instructions        TEXT,
    tips                TEXT,
    video               TEXT,
    image               TEXT
);


CREATE TABLE food
(
    id                    bigint PRIMARY KEY,
    name                  VARCHAR(100),
    energy_value          integer,
    protein               double precision,
    carbohydrates         double precision,
    sugars                double precision,
    fats                  double precision,
    saturated_fatty_acids double precision,
    trans_fatty_acids     double precision,
    monounsaturated       double precision,
    semi_saturated        double precision,
    cholesterol           double precision,
    fiber                 double precision,
    salt                  double precision,
    water                 double precision,
    calcium               double precision,
    phe                   double precision,
    details               TEXT


);



CREATE TABLE exercise_muscle
(
    id          integer PRIMARY KEY,
    muscle_id   integer NOT NULL,
    exercise_id integer NOT NULL

);



CREATE TABLE muscle
(

    id          integer PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    image_small TEXT         NOT NULL,
    image_big   TEXT         NOT NULL
);



CREATE TABLE user_role
(
    id      SERIAL PRIMARY KEY,
    user_id integer,
    role_id integer
);


CREATE TABLE vitamin
(
    id                 integer PRIMARY KEY,
    name               VARCHAR(100),
    benefits           TEXT,
    recommended_amount TEXT,
    upper_limit        TEXT,
    food_sources       TEXT
);


CREATE TABLE mineral
(
    id                 integer PRIMARY KEY,
    name               VARCHAR(100),
    benefits           TEXT,
    recommended_amount TEXT,
    upper_limit        TEXT,
    food_sources       TEXT
);

CREATE TABLE preservative
(
    id              integer PRIMARY KEY,
    name            VARCHAR(100),
    dangerous_level integer
);

CREATE table food_vitamin
(
    id         SERIAL PRIMARY KEY,
    food_id    integer,
    vitamin_id integer
);

CREATE table food_mineral
(
    id         SERIAL PRIMARY KEY,
    food_id    integer,
    mineral_id integer
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
    ADD CONSTRAINT fd_fk_food FOREIGN KEY (food_id) REFERENCES food (id) ON DELETE CASCADE;
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

ALTER TABLE food_vitamin
    ADD CONSTRAINT fv_fk_food FOREIGN KEY (food_id) REFERENCES food (id) ON DELETE CASCADE;
ALTER TABLE food_vitamin
    ADD CONSTRAINT fv_fk_vitamin FOREIGN KEY (vitamin_id) REFERENCES vitamin (id) ON DELETE CASCADE;

ALTER TABLE food_mineral
    ADD CONSTRAINT fm_fk_food FOREIGN KEY (food_id) REFERENCES food (id) ON DELETE CASCADE;
ALTER TABLE food_mineral
    ADD CONSTRAINT fm_fk_mineral FOREIGN KEY (mineral_id) REFERENCES mineral (id) ON DELETE CASCADE;



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
CREATE SEQUENCE food_vitamin_sequence
    START 1
    INCREMENT 1
    MINVALUE 1
    OWNED BY food_vitamin.id;
CREATE SEQUENCE food_mineral_sequence
    START 1
    INCREMENT 1
    MINVALUE 1
    OWNED BY food_mineral.id;









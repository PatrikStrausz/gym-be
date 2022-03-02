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
    id        SERIAL PRIMARY KEY,
    firstname VARCHAR(100) NOT NULL,
    lastname  VARCHAR(100) NOT NULL,
    height    integer      NOT NULL,
    weight    integer      NOT NULL,
    age       integer      NOT NULL,
    goal      VARCHAR(100) NOT NULL,
    sex       VARCHAR(100),
    activity  VARCHAR(100),
    user_id   integer      NOT NULL UNIQUE

);



CREATE TABLE user_details_food
(
    id              SERIAL PRIMARY KEY,
    food_id         integer,
    user_details_id integer,
    amount          double precision,
    time_of_the_day VARCHAR(100),
    date            VARCHAR(100),
    food_name       VARCHAR(100),
    total_calories  double precision


);

CREATE TABLE user_details_training
(
    id              SERIAL PRIMARY KEY,
    training_id     integer,
    user_details_id integer,
    name            VARCHAR(100),
    reps            integer[],
    sets            integer,
    weight          integer[],
    date            VARCHAR(100)


);



CREATE TABLE training
(
    id   SERIAL PRIMARY KEY,
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
    secondary_muscles   VARCHAR(255),
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

CREATE TABLE macros
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE user_details_macros
(
    id              SERIAL PRIMARY KEY,
    user_details_id integer,
    macros_id       integer,
    totalAmount     double precision
);



insert into training(id, name)
VALUES (1, 'my');


ALTER TABLE user_role
    ADD CONSTRAINT ur_fk_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE;
ALTER TABLE user_role
    ADD CONSTRAINT ur_fk_role FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE CASCADE;


ALTER TABLE user_details
    ADD CONSTRAINT ud_fk_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE;



ALTER TABLE user_details_food
    ADD CONSTRAINT udf_fk_user_details FOREIGN KEY (user_details_id) REFERENCES user_details (id) ON DELETE CASCADE;
ALTER TABLE user_details_food
    ADD CONSTRAINT udf_fk_food FOREIGN KEY (food_id) REFERENCES food (id) ON DELETE CASCADE;


ALTER TABLE user_details_training
    ADD CONSTRAINT udt_fk_training FOREIGN KEY (training_id) REFERENCES training (id) ON DELETE CASCADE;
ALTER TABLE user_details_training
    ADD CONSTRAINT udt_fk_user_details FOREIGN KEY (user_details_id) REFERENCES user_details (id) ON DELETE CASCADE;



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

ALTER TABLE user_details_macros
    ADD CONSTRAINT udm_fk_user_details FOREIGN KEY (user_details_id) REFERENCES user_details (id) ON DELETE CASCADE;
ALTER TABLE user_details_macros
    ADD CONSTRAINT udm_fk_macros FOREIGN KEY (macros_id) REFERENCES macros (id) ON DELETE CASCADE;



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
CREATE SEQUENCE user_details_food_sequence
    START 1
    INCREMENT 1
    MINVALUE 1
    OWNED BY user_details_food.id;
CREATE SEQUENCE user_role_sequence
    START 1
    INCREMENT 1
    MINVALUE 1
    OWNED BY user_role.id;
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
CREATE SEQUENCE user_details_macros_sequence
    START 1
    INCREMENT 1
    MINVALUE 1
    OWNED BY user_details_macros.id;
CREATE SEQUENCE training_sequence
    START 1
    INCREMENT 1
    MINVALUE 1
    OWNED BY training.id;
CREATE SEQUENCE user_details_training_sequence
    START 1
    INCREMENT 1
    MINVALUE 1
    OWNED BY user_details_macros.id;










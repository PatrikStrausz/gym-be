

CREATE TABLE gym_user
(
    id       SERIAL PRIMARY KEY,
    login    character varying(255) NOT NULL,
    email    character varying(255) NOT NULL,
    password character varying(255) NOT NULL
);


CREATE TABLE user_details
(
    id          SERIAL PRIMARY KEY,
    firstname   character varying(255) NOT NULL,
    lastname    character varying(255) NOT NULL,
    height      integer                NOT NULL,
    weight      integer                NOT NULL,
    age         integer                NOT NULL,
    goal        character varying(255) NOT NULL,
    user_id     integer                NOT NULL,
    training_id integer,
    diet_id     integer

);


CREATE TABLE diet
(
    id   integer PRIMARY KEY,
    name character varying(255)
);


CREATE TABLE food_diet
(
    id      integer PRIMARY KEY,
    food_id integer,
    diet_id integer

);


CREATE TABLE training
(
    id   integer PRIMARY KEY,
    name character varying(255)
);


CREATE TABLE training_exercise
(
    id          integer PRIMARY KEY,
    exercise_id integer,
    training_id integer
);

CREATE TABLE exercise
(
    id                 integer PRIMARY KEY,
    name               character varying(255),
    exercise_type      character varying(255),
    equipment_required character varying(255),
    mechanics          character varying(255),
    forcetype          character varying(255),
    experience_level   character varying(255),
    overview           TEXT,
    instructions       TEXT,
    tips               TEXT,
    image              TEXT,
    video              TEXT
);


CREATE TABLE food
(
    fdc_id           integer PRIMARY KEY,
    data_type        character varying(255),
    description      character varying(255),
    food_category_id character varying(255),
    publication_date character varying(255)
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
    data_points      character varying(255),
    derivation_id    character varying(255),
    min              character varying(255),
    max              character varying(255),
    median           character varying(255),
    footnote         character varying(255),
    min_year_acqured character varying(255)

);



CREATE TABLE muscle
(

    id          integer PRIMARY KEY,
    name        character varying(255) NOT NULL,
    image_small TEXT                   NOT NULL,
    image_big   TEXT                   NOT NULL
);

CREATE TABLE public.nutrient
(
    id           integer PRIMARY KEY,
    name         character varying(255),
    unit_name    character varying(255),
    nutrient_nbr character varying(255),
    rank         character varying(255)
);


ALTER TABLE user_details
    ADD CONSTRAINT ud_fk_user FOREIGN KEY (user_id) REFERENCES gym_user (id) ON DELETE CASCADE;
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



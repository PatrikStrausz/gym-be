--
-- PostgreSQL database dump
--

-- Dumped from database version 13.4
-- Dumped by pg_dump version 13.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: diet; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.diet (
    id integer NOT NULL,
    name character varying(255)
);


ALTER TABLE public.diet OWNER TO postgres;

--
-- Name: diet_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.diet_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.diet_sequence OWNER TO postgres;

--
-- Name: exercise; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.exercise (
    id integer NOT NULL,
    name character varying(255),
    exercise_type character varying(255),
    equipment_required character varying(255),
    mechanics character varying(255),
    forcetype character varying(255),
    "experience_level " character varying(255),
    overview character varying(255),
    instructions character varying(255),
    tips character varying(255),
    image character varying,
    video character varying
);


ALTER TABLE public.exercise OWNER TO postgres;

--
-- Name: exercise_muscle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.exercise_muscle (
    id integer NOT NULL,
    muscle_id integer,
    exercise_id integer,
    is_main boolean
);


ALTER TABLE public.exercise_muscle OWNER TO postgres;

--
-- Name: exercise_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.exercise_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.exercise_sequence OWNER TO postgres;

--
-- Name: food; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.food (
    fdc_id bigint NOT NULL,
    data_type character varying,
    description character varying,
    food_category_id character varying,
    publication_date character varying
);


ALTER TABLE public.food OWNER TO postgres;

--
-- Name: food_diet; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.food_diet (
    id integer NOT NULL,
    food_id integer,
    diet_id integer
);


ALTER TABLE public.food_diet OWNER TO postgres;

--
-- Name: food_fdc_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.food_fdc_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.food_fdc_id_seq OWNER TO postgres;

--
-- Name: food_fdc_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.food_fdc_id_seq OWNED BY public.food.fdc_id;


--
-- Name: food_nutrient; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.food_nutrient (
    id integer NOT NULL,
    fdc_id integer NOT NULL,
    nutrient_id integer NOT NULL,
    amount double precision,
    data_points character varying,
    derivation_id character varying,
    min character varying,
    max character varying,
    median character varying,
    footnote character varying,
    min_year_acqured character varying
);


ALTER TABLE public.food_nutrient OWNER TO postgres;

--
-- Name: food_nutrient_fdc_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.food_nutrient_fdc_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.food_nutrient_fdc_id_seq OWNER TO postgres;

--
-- Name: food_nutrient_fdc_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.food_nutrient_fdc_id_seq OWNED BY public.food_nutrient.fdc_id;


--
-- Name: food_nutrient_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.food_nutrient_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.food_nutrient_id_seq OWNER TO postgres;

--
-- Name: food_nutrient_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.food_nutrient_id_seq OWNED BY public.food_nutrient.id;


--
-- Name: food_nutrient_nutrient_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.food_nutrient_nutrient_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.food_nutrient_nutrient_id_seq OWNER TO postgres;

--
-- Name: food_nutrient_nutrient_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.food_nutrient_nutrient_id_seq OWNED BY public.food_nutrient.nutrient_id;


--
-- Name: food_nutrient_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.food_nutrient_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.food_nutrient_sequence OWNER TO postgres;

--
-- Name: food_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.food_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.food_sequence OWNER TO postgres;

--
-- Name: gym_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.gym_user (
    id integer NOT NULL,
    login character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying NOT NULL
);


ALTER TABLE public.gym_user OWNER TO postgres;

--
-- Name: muscle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.muscle (
    id integer NOT NULL,
    name character varying,
    image_small character varying,
    image_big character varying
);


ALTER TABLE public.muscle OWNER TO postgres;

--
-- Name: nutrient; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nutrient (
    id integer NOT NULL,
    name character varying,
    unit_name character varying,
    nutrient_nbr character varying,
    rank character varying
);


ALTER TABLE public.nutrient OWNER TO postgres;

--
-- Name: nutrient_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.nutrient_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nutrient_id_seq OWNER TO postgres;

--
-- Name: nutrient_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.nutrient_id_seq OWNED BY public.nutrient.id;


--
-- Name: training; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.training (
    id integer NOT NULL,
    name character varying(255)
);


ALTER TABLE public.training OWNER TO postgres;

--
-- Name: training_exercise; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.training_exercise (
    id integer NOT NULL,
    exercise_id integer,
    training_id integer
);


ALTER TABLE public.training_exercise OWNER TO postgres;

--
-- Name: training_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.training_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.training_sequence OWNER TO postgres;

--
-- Name: user_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_details (
    id integer NOT NULL,
    firstname character varying(255) NOT NULL,
    lastname character varying(255) NOT NULL,
    height integer NOT NULL,
    weight integer NOT NULL,
    age integer NOT NULL,
    goal character varying NOT NULL,
    user_id integer NOT NULL,
    training_id integer,
    diet_id integer
);


ALTER TABLE public.user_details OWNER TO postgres;

--
-- Name: user_details_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_details_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_details_sequence OWNER TO postgres;

--
-- Name: user_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_sequence OWNER TO postgres;

--
-- Name: food fdc_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.food ALTER COLUMN fdc_id SET DEFAULT nextval('public.food_fdc_id_seq'::regclass);


--
-- Name: food_nutrient id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.food_nutrient ALTER COLUMN id SET DEFAULT nextval('public.food_nutrient_id_seq'::regclass);


--
-- Name: food_nutrient fdc_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.food_nutrient ALTER COLUMN fdc_id SET DEFAULT nextval('public.food_nutrient_fdc_id_seq'::regclass);


--
-- Name: food_nutrient nutrient_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.food_nutrient ALTER COLUMN nutrient_id SET DEFAULT nextval('public.food_nutrient_nutrient_id_seq'::regclass);


--
-- Name: nutrient id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nutrient ALTER COLUMN id SET DEFAULT nextval('public.nutrient_id_seq'::regclass);


--
-- Data for Name: diet; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.diet (id, name) FROM stdin;
\.


--
-- Data for Name: exercise; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.exercise (id, name, exercise_type, equipment_required, mechanics, forcetype, "experience_level ", overview, instructions, tips, image, video) FROM stdin;
\.


--
-- Data for Name: exercise_muscle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.exercise_muscle (id, muscle_id, exercise_id, is_main) FROM stdin;
\.


--
-- Data for Name: food; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.food (fdc_id, data_type, description, food_category_id, publication_date) FROM stdin;
\.


--
-- Data for Name: food_diet; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.food_diet (id, food_id, diet_id) FROM stdin;
\.


--
-- Data for Name: food_nutrient; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.food_nutrient (id, fdc_id, nutrient_id, amount, data_points, derivation_id, min, max, median, footnote, min_year_acqured) FROM stdin;
\.


--
-- Data for Name: gym_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.gym_user (id, login, email, password) FROM stdin;
\.


--
-- Data for Name: muscle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.muscle (id, name, image_small, image_big) FROM stdin;
\.


--
-- Data for Name: nutrient; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.nutrient (id, name, unit_name, nutrient_nbr, rank) FROM stdin;
\.


--
-- Data for Name: training; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.training (id, name) FROM stdin;
\.


--
-- Data for Name: training_exercise; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.training_exercise (id, exercise_id, training_id) FROM stdin;
\.


--
-- Data for Name: user_details; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_details (id, firstname, lastname, height, weight, age, goal, user_id, training_id, diet_id) FROM stdin;
\.


--
-- Name: diet_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.diet_sequence', 1, false);


--
-- Name: exercise_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.exercise_sequence', 1, false);


--
-- Name: food_fdc_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.food_fdc_id_seq', 1, false);


--
-- Name: food_nutrient_fdc_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.food_nutrient_fdc_id_seq', 1, false);


--
-- Name: food_nutrient_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.food_nutrient_id_seq', 1, false);


--
-- Name: food_nutrient_nutrient_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.food_nutrient_nutrient_id_seq', 1, false);


--
-- Name: food_nutrient_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.food_nutrient_sequence', 65, true);


--
-- Name: food_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.food_sequence', 3, true);


--
-- Name: nutrient_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.nutrient_id_seq', 1, false);


--
-- Name: training_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.training_sequence', 1, false);


--
-- Name: user_details_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_details_sequence', 1, false);


--
-- Name: user_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_sequence', 1, false);


--
-- Name: diet diet_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.diet
    ADD CONSTRAINT diet_pkey PRIMARY KEY (id);


--
-- Name: gym_user email; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gym_user
    ADD CONSTRAINT email UNIQUE (email) INCLUDE (email);


--
-- Name: exercise_muscle exercise_muscle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exercise_muscle
    ADD CONSTRAINT exercise_muscle_pkey PRIMARY KEY (id);


--
-- Name: exercise exercise_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exercise
    ADD CONSTRAINT exercise_pkey PRIMARY KEY (id);


--
-- Name: food_diet food_diet_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.food_diet
    ADD CONSTRAINT food_diet_pkey PRIMARY KEY (id);


--
-- Name: food_nutrient food_nutrient_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.food_nutrient
    ADD CONSTRAINT food_nutrient_pkey PRIMARY KEY (id);


--
-- Name: food food_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.food
    ADD CONSTRAINT food_pkey PRIMARY KEY (fdc_id);


--
-- Name: gym_user gym_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gym_user
    ADD CONSTRAINT gym_user_pkey PRIMARY KEY (id);


--
-- Name: training_exercise id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_exercise
    ADD CONSTRAINT id PRIMARY KEY (id);


--
-- Name: gym_user login; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gym_user
    ADD CONSTRAINT login UNIQUE (login) INCLUDE (login);


--
-- Name: muscle muscle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.muscle
    ADD CONSTRAINT muscle_pkey PRIMARY KEY (id);


--
-- Name: nutrient nutrient_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nutrient
    ADD CONSTRAINT nutrient_pkey PRIMARY KEY (id);


--
-- Name: gym_user password; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gym_user
    ADD CONSTRAINT password UNIQUE (password) INCLUDE (password);


--
-- Name: training training_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training
    ADD CONSTRAINT training_pkey PRIMARY KEY (id);


--
-- Name: user_details user_details_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_details
    ADD CONSTRAINT user_details_pkey PRIMARY KEY (id);


--
-- Name: user_details diet_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_details
    ADD CONSTRAINT diet_id FOREIGN KEY (diet_id) REFERENCES public.diet(id) NOT VALID;


--
-- Name: food_diet diet_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.food_diet
    ADD CONSTRAINT diet_id FOREIGN KEY (diet_id) REFERENCES public.diet(id);


--
-- Name: training_exercise exercise_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_exercise
    ADD CONSTRAINT exercise_id FOREIGN KEY (exercise_id) REFERENCES public.exercise(id);


--
-- Name: exercise_muscle exercise_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exercise_muscle
    ADD CONSTRAINT exercise_id FOREIGN KEY (exercise_id) REFERENCES public.exercise(id);


--
-- Name: food_nutrient fdc_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.food_nutrient
    ADD CONSTRAINT fdc_id FOREIGN KEY (fdc_id) REFERENCES public.food(fdc_id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;


--
-- Name: food_diet food_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.food_diet
    ADD CONSTRAINT food_id FOREIGN KEY (food_id) REFERENCES public.food(fdc_id);


--
-- Name: exercise_muscle muscle_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exercise_muscle
    ADD CONSTRAINT muscle_id FOREIGN KEY (muscle_id) REFERENCES public.muscle(id);


--
-- Name: food_nutrient nutrient_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.food_nutrient
    ADD CONSTRAINT nutrient_id FOREIGN KEY (nutrient_id) REFERENCES public.nutrient(id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;


--
-- Name: user_details training_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_details
    ADD CONSTRAINT training_id FOREIGN KEY (training_id) REFERENCES public.training(id) NOT VALID;


--
-- Name: training_exercise training_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_exercise
    ADD CONSTRAINT training_id FOREIGN KEY (training_id) REFERENCES public.training(id);


--
-- Name: user_details user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_details
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public.gym_user(id) NOT VALID;


--
-- PostgreSQL database dump complete
--


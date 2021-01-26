--
-- PostgreSQL database dump
--

-- Dumped from database version 12.5 (Ubuntu 12.5-0ubuntu0.20.04.1)
-- Dumped by pg_dump version 12.5 (Ubuntu 12.5-0ubuntu0.20.04.1)

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
-- Name: claim; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.claim (
    claim_id integer NOT NULL,
    meow_id integer,
    description text,
    total_amount integer,
    status integer,
    "time" timestamp without time zone NOT NULL
);


ALTER TABLE public.claim OWNER TO postgres;

--
-- Name: claim_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.claim_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.claim_seq OWNER TO postgres;

--
-- Name: claim_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.claim_seq OWNED BY public.claim.claim_id;


--
-- Name: comment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.comment (
    comment_id integer NOT NULL,
    claim_id integer NOT NULL,
    meow_id integer NOT NULL,
    comment text NOT NULL,
    "time" timestamp without time zone DEFAULT now() NOT NULL
);


ALTER TABLE public.comment OWNER TO postgres;

--
-- Name: comment_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.comment_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.comment_seq OWNER TO postgres;

--
-- Name: comment_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.comment_seq OWNED BY public.comment.comment_id;


--
-- Name: credential; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.credential (
    username text NOT NULL,
    meow_id integer NOT NULL,
    password text NOT NULL,
    "time" timestamp without time zone NOT NULL
);


ALTER TABLE public.credential OWNER TO postgres;

--
-- Name: entry; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.entry (
    entry_id integer NOT NULL,
    claim_id integer NOT NULL,
    creditor integer NOT NULL,
    debitor integer NOT NULL,
    amount integer NOT NULL,
    "time" timestamp without time zone NOT NULL
);


ALTER TABLE public.entry OWNER TO postgres;

--
-- Name: entry_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.entry_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.entry_seq OWNER TO postgres;

--
-- Name: entry_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.entry_seq OWNED BY public.entry.entry_id;


--
-- Name: meow; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.meow (
    meow_id integer NOT NULL,
    name text NOT NULL,
    phone character varying(30) NOT NULL,
    balance integer DEFAULT 0 NOT NULL,
    "time" timestamp without time zone NOT NULL
);


ALTER TABLE public.meow OWNER TO postgres;

--
-- Name: meow_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.meow_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.meow_seq OWNER TO postgres;

--
-- Name: meow_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.meow_seq OWNED BY public.meow.meow_id;


--
-- Name: transaction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transaction (
    transaction_id integer NOT NULL,
    claim_id integer NOT NULL,
    creditor integer NOT NULL,
    debitor integer NOT NULL,
    amount integer NOT NULL,
    status integer NOT NULL,
    "time" timestamp without time zone NOT NULL
);


ALTER TABLE public.transaction OWNER TO postgres;

--
-- Name: transaction_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.transaction_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.transaction_seq OWNER TO postgres;

--
-- Name: transaction_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.transaction_seq OWNED BY public.transaction.transaction_id;


--
-- Data for Name: claim; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.claim (claim_id, meow_id, description, total_amount, status, "time") FROM stdin;
1	1	Introduction to Spring Boot	123	0	2021-01-26 14:39:48.440642
\.


--
-- Data for Name: comment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.comment (comment_id, claim_id, meow_id, comment, "time") FROM stdin;
\.


--
-- Data for Name: credential; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.credential (username, meow_id, password, "time") FROM stdin;
meowmeow@gmail.com	1	meowmeow	2021-01-26 14:40:15.23924
meowmeow2@gmail.com	2	meowmeow	2021-01-26 14:40:15.23924
\.


--
-- Data for Name: entry; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.entry (entry_id, claim_id, creditor, debitor, amount, "time") FROM stdin;
1	1	1	2	100	2021-01-25 14:30:36.637
2	1	2	1	30	2021-01-25 14:30:41.223
3	1	1	1	300	2021-01-25 14:31:08.16
\.


--
-- Data for Name: meow; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.meow (meow_id, name, phone, balance, "time") FROM stdin;
1	meow meow tester	012-1234567	0	2021-01-26 14:40:29.026643
2	meow meow tester2	012-12343567	0	2021-01-26 14:40:29.026643
\.


--
-- Data for Name: transaction; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.transaction (transaction_id, claim_id, creditor, debitor, amount, status, "time") FROM stdin;
\.


--
-- Name: claim_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.claim_seq', 1, true);


--
-- Name: comment_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.comment_seq', 1, false);


--
-- Name: entry_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.entry_seq', 3, true);


--
-- Name: meow_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.meow_seq', 5, true);


--
-- Name: transaction_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.transaction_seq', 1, false);


--
-- Name: claim claim_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.claim
    ADD CONSTRAINT claim_pkey PRIMARY KEY (claim_id);


--
-- Name: comment comment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_pkey PRIMARY KEY (comment_id);


--
-- Name: credential credential_meow_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.credential
    ADD CONSTRAINT credential_meow_id_key UNIQUE (meow_id);


--
-- Name: credential credential_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.credential
    ADD CONSTRAINT credential_pkey PRIMARY KEY (username);


--
-- Name: entry entry_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entry
    ADD CONSTRAINT entry_pkey PRIMARY KEY (entry_id);


--
-- Name: meow meow_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.meow
    ADD CONSTRAINT meow_pkey PRIMARY KEY (meow_id);


--
-- Name: transaction transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_pkey PRIMARY KEY (transaction_id);


--
-- Name: entry claim_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entry
    ADD CONSTRAINT claim_ref FOREIGN KEY (claim_id) REFERENCES public.claim(claim_id);


--
-- Name: transaction claim_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT claim_ref FOREIGN KEY (claim_id) REFERENCES public.claim(claim_id);


--
-- Name: comment claim_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT claim_ref FOREIGN KEY (claim_id) REFERENCES public.claim(claim_id);


--
-- Name: entry meow_creditor_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entry
    ADD CONSTRAINT meow_creditor_ref FOREIGN KEY (creditor) REFERENCES public.meow(meow_id);


--
-- Name: transaction meow_debitor_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT meow_debitor_ref FOREIGN KEY (debitor) REFERENCES public.meow(meow_id);


--
-- Name: entry meow_debitor_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entry
    ADD CONSTRAINT meow_debitor_ref FOREIGN KEY (debitor) REFERENCES public.meow(meow_id);


--
-- Name: credential meow_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.credential
    ADD CONSTRAINT meow_ref FOREIGN KEY (meow_id) REFERENCES public.meow(meow_id);


--
-- Name: transaction meow_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT meow_ref FOREIGN KEY (creditor) REFERENCES public.meow(meow_id);


--
-- Name: comment meow_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT meow_ref FOREIGN KEY (meow_id) REFERENCES public.meow(meow_id);


--
-- Name: claim meow_ref; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.claim
    ADD CONSTRAINT meow_ref FOREIGN KEY (meow_id) REFERENCES public.meow(meow_id);


--
-- PostgreSQL database dump complete
--


CREATE TABLE students
(
    id SERIAL PRIMARY KEY,
    dob date NOT NULL,
    email character varying(200) NOT NULL,
    name character varying(200) NOT NULL
)

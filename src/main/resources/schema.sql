
DROP TABLE IF EXISTS records;

CREATE TABLE records (
    id SERIAL PRIMARY KEY,
    number VARCHAR(100) UNIQUE,
    name VARCHAR(1000)
);

CREATE TABLE companies (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    budget NUMERIC(36, 2) NOT NULL CHECK (budget >= 0)
);
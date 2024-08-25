CREATE TABLE IF NOT EXISTS users (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO users (name, username, password, role) VALUES
('Alice Smith', 'alice.smith', '$2a$12$h3cu/Kp00GspyxPqq9GOjeM0ZaY2679ESM50m8ohPsHClhN.YrQTa', 'ADMIN'),
('Bob Johnson', 'bob.johnson', '$2a$12$bY8yIX2ahPwy.ADZciIs7OKV7LPzDktzirb521OtTv8cch4Ta6WaK', 'USER'),
('Charlie Brown', 'charlie.brown', '$2a$12$7xWjvGBVAs6rH5/wl9/gGO1FIbk0C9PGfwo4Yo9Jr9D3/UsQ2E66S', 'USER');
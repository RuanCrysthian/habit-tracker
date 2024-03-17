CREATE TABLE IF NOT EXISTS tb_user (
    user_id UUID PRIMARY KEY,
    name VARCHAR(255),
    username VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255)
);
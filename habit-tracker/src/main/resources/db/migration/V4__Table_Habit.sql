CREATE TABLE IF NOT EXISTS tb_habit (
    habit_id UUID PRIMARY KEY,
    user_id UUID REFERENCES tb_user(user_id),
    habit_name VARCHAR(255),
    description TEXT,
    start_date TIMESTAMP,
    goal NUMERIC
);
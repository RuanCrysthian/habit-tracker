CREATE TABLE IF NOT EXISTS tb_habit_record (
    habit_record_id UUID PRIMARY KEY,
    habit_id UUID REFERENCES tb_habit(habit_id),
    record_date TIMESTAMP,
    habit_status VARCHAR(50)
);

INSERT INTO tb_role (role_id, authority) VALUES ('d4e0132a-b966-4b94-8051-3496f6e8d4e5', 'ROLE_USER');
INSERT INTO tb_role (role_id, authority) VALUES ('f0ec7877-02f6-4240-a76a-94b3ac38f374', 'ROLE_ADMIN');

INSERT INTO tb_user (user_id, name, username, password, email) VALUES ('f0ec7877-02f6-4240-a76a-94b3ac38f374', 'Jane Smith', 'jane.smith', '098f6bcd4621d373cade4e832627b4f6', 'jane.smith@example.com');
INSERT INTO tb_user (user_id, name, username, password, email) VALUES ('c5c7b3b2-8507-4e4a-b1db-992a60bb5b5e', 'Alice Johnson', 'alice.johnson', 'e99a18c428cb38d5f260853678922e03', 'alice.johnson@example.com');
INSERT INTO tb_user (user_id, name, username, password, email) VALUES ('a3b6e8e5-7c2a-48fb-8f68-1f0c4d3e6bfe', 'Bob Brown', 'bob.brown', 'c4ca4238a0b923820dcc509a6f75849b', 'bob.brown@example.com');
INSERT INTO tb_user (user_id, name, username, password, email) VALUES ('f4a0e8f9-235e-4be2-bce7-0457153f09a3', 'Emma Davis', 'emma.davis', 'eccbc87e4b5ce2fe28308fd9f2a7baf3', 'emma.davis@example.com');

INSERT INTO tb_user_role (user_id, role_id) VALUES ('f0ec7877-02f6-4240-a76a-94b3ac38f374', 'd4e0132a-b966-4b94-8051-3496f6e8d4e5');
INSERT INTO tb_user_role (user_id, role_id) VALUES ('f0ec7877-02f6-4240-a76a-94b3ac38f374', 'f0ec7877-02f6-4240-a76a-94b3ac38f374');
INSERT INTO tb_user_role (user_id, role_id) VALUES ('c5c7b3b2-8507-4e4a-b1db-992a60bb5b5e', 'd4e0132a-b966-4b94-8051-3496f6e8d4e5');

INSERT INTO tb_habit(habit_id, user_id, habit_name, description, start_date, goal) VALUES ('2797887c-7422-4725-ae57-e24ae1cbe8b6', 'f0ec7877-02f6-4240-a76a-94b3ac38f374', 'Study English', 'test', '2020-07-14T10:00:00Z', 100);
INSERT INTO tb_habit(habit_id, user_id, habit_name, description, start_date, goal) VALUES ('f7a25889-467d-4562-a10f-eaebf0a0ce94', 'f0ec7877-02f6-4240-a76a-94b3ac38f374', 'Workout', 'test', '2020-07-14T10:00:00Z', 100);
INSERT INTO tb_habit(habit_id, user_id, habit_name, description, start_date, goal) VALUES ('281c37e0-e1c0-433f-bd77-2edc71a46c7b', 'f0ec7877-02f6-4240-a76a-94b3ac38f374', 'Read', 'test', '2020-07-14T10:00:00Z', 100);
INSERT INTO tb_habit(habit_id, user_id, habit_name, description, start_date, goal) VALUES ('1d815824-aa58-49f7-9af2-cff8690ee2bd', 'f4a0e8f9-235e-4be2-bce7-0457153f09a3', 'Read', 'test', '2020-07-14T10:00:00Z', 100);
INSERT INTO tb_habit(habit_id, user_id, habit_name, description, start_date, goal) VALUES ('b519e122-8a4e-4167-b10c-f0496493d5e8', 'f4a0e8f9-235e-4be2-bce7-0457153f09a3', 'Workout', 'test', '2020-07-14T10:00:00Z', 100);

INSERT INTO tb_habit_record (habit_record_id, habit_id, record_date, habit_status) VALUES ('c4a7f23e-3c91-4d38-87a6-3a2f8f4b01d2', '2797887c-7422-4725-ae57-e24ae1cbe8b6', '2024-03-13 08:00:00', 'DONE');
INSERT INTO tb_habit_record (habit_record_id, habit_id, record_date, habit_status) VALUES  ('e7b23742-afdd-424b-9e17-c5a0fca2ea51', '2797887c-7422-4725-ae57-e24ae1cbe8b6', '2024-03-12 08:00:00', 'NOT_DONE');
INSERT INTO tb_habit_record (habit_record_id, habit_id, record_date, habit_status) VALUES  ('a33997cb-6530-4d1e-b153-b62748367850', '1d815824-aa58-49f7-9af2-cff8690ee2bd', '2024-03-11 08:00:00', 'DONE');
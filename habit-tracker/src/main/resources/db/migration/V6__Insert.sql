INSERT INTO tb_role (role_id, authority) VALUES ('d4e0132a-b966-4b94-8051-3496f6e8d4e5', 'ROLE_USER');
INSERT INTO tb_role (role_id, authority) VALUES ('f0ec7877-02f6-4240-a76a-94b3ac38f374', 'ROLE_ADMIN');

INSERT INTO tb_user (user_id, name, username, password, email) VALUES ('f0ec7877-02f6-4240-a76a-94b3ac38f374', 'Jane Smith', 'jane.smith', '098f6bcd4621d373cade4e832627b4f6', 'jane.smith@example.com');
INSERT INTO tb_user (user_id, name, username, password, email) VALUES ('c5c7b3b2-8507-4e4a-b1db-992a60bb5b5e', 'Alice Johnson', 'alice.johnson', 'e99a18c428cb38d5f260853678922e03', 'alice.johnson@example.com');

INSERT INTO tb_user_role (user_id, role_id) VALUES ('f0ec7877-02f6-4240-a76a-94b3ac38f374', 'd4e0132a-b966-4b94-8051-3496f6e8d4e5');
INSERT INTO tb_user_role (user_id, role_id) VALUES ('f0ec7877-02f6-4240-a76a-94b3ac38f374', 'f0ec7877-02f6-4240-a76a-94b3ac38f374');
INSERT INTO tb_user_role (user_id, role_id) VALUES ('c5c7b3b2-8507-4e4a-b1db-992a60bb5b5e', 'd4e0132a-b966-4b94-8051-3496f6e8d4e5');

INSERT INTO tb_habit(habit_id, user_id, habit_name, description, start_date, goal) VALUES ('2797887c-7422-4725-ae57-e24ae1cbe8b6', 'f0ec7877-02f6-4240-a76a-94b3ac38f374', 'Study English', 'Study English', '2024-03-17T10:00:00Z', 100);
INSERT INTO tb_habit(habit_id, user_id, habit_name, description, start_date, goal) VALUES ('f7a25889-467d-4562-a10f-eaebf0a0ce94', 'f0ec7877-02f6-4240-a76a-94b3ac38f374', 'Workout', 'Go to the Gym', '2024-03-17T10:00:00Z', 100);
INSERT INTO tb_habit(habit_id, user_id, habit_name, description, start_date, goal) VALUES ('281c37e0-e1c0-433f-bd77-2edc71a46c7b', 'f0ec7877-02f6-4240-a76a-94b3ac38f374', 'Read', 'Read books', '2024-03-17T10:00:00Z', 100);
INSERT INTO tb_habit(habit_id, user_id, habit_name, description, start_date, goal) VALUES ('1d815824-aa58-49f7-9af2-cff8690ee2bd', 'c5c7b3b2-8507-4e4a-b1db-992a60bb5b5e', 'Read', 'Read articles', '2024-03-17T10:00:00Z', 100);
INSERT INTO tb_habit(habit_id, user_id, habit_name, description, start_date, goal) VALUES ('b519e122-8a4e-4167-b10c-f0496493d5e8', 'c5c7b3b2-8507-4e4a-b1db-992a60bb5b5e', 'Workout', 'Go to the Gym', '2024-03-17T10:00:00Z', 100);

INSERT INTO tb_habit_record (habit_record_id, habit_id, record_date, habit_status) VALUES ('c4a7f23e-3c91-4d38-87a6-3a2f8f4b01d2', '2797887c-7422-4725-ae57-e24ae1cbe8b6', '2024-03-12 08:00:00', 'DONE');
INSERT INTO tb_habit_record (habit_record_id, habit_id, record_date, habit_status) VALUES  ('d1b3f209-b6e6-48dc-b81d-e0e4eadcf6b5', '2797887c-7422-4725-ae57-e24ae1cbe8b6', '2024-03-13 08:00:00', 'NOT_DONE');
INSERT INTO tb_habit_record (habit_record_id, habit_id, record_date, habit_status) VALUES  ('24d75838-0d9f-4ac9-b70e-ceaf52a2c9ed', '2797887c-7422-4725-ae57-e24ae1cbe8b6', '2024-03-14 08:00:00', 'DONE');
INSERT INTO tb_habit_record (habit_record_id, habit_id, record_date, habit_status) VALUES  ('6f915da0-a183-4aa5-9277-c2884f0937ee', '2797887c-7422-4725-ae57-e24ae1cbe8b6', '2024-03-15 08:00:00', 'NOT_DONE');
INSERT INTO tb_habit_record (habit_record_id, habit_id, record_date, habit_status) VALUES  ('20097dde-eb01-46c5-8f00-5a1dae5d9585', '2797887c-7422-4725-ae57-e24ae1cbe8b6', '2024-03-16 08:00:00', 'DONE');
INSERT INTO tb_habit_record (habit_record_id, habit_id, record_date, habit_status) VALUES  ('dcbd648f-3b37-461e-a098-6558d158d7c7', '2797887c-7422-4725-ae57-e24ae1cbe8b6', '2024-03-17 08:00:00', 'DONE');
INSERT INTO tb_habit_record (habit_record_id, habit_id, record_date, habit_status) VALUES  ('e7b23742-afdd-424b-9e17-c5a0fca2ea51', '2797887c-7422-4725-ae57-e24ae1cbe8b6', '2024-03-18 08:00:00', 'NOT_DONE');
INSERT INTO tb_habit_record (habit_record_id, habit_id, record_date, habit_status) VALUES  ('3bce10ba-68e1-4f56-8faa-f3111b3ab823', '1d815824-aa58-49f7-9af2-cff8690ee2bd', '2024-03-11 08:00:00', 'DONE');
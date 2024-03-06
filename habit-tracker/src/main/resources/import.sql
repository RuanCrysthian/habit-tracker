INSERT INTO tb_role (role_id, authority) VALUES ('d4e0132a-b966-4b94-8051-3496f6e8d4e5', 'ROLE_USER');
INSERT INTO tb_role (role_id, authority) VALUES ('f0ec7877-02f6-4240-a76a-94b3ac38f374', 'ROLE_ADMIN');

INSERT INTO tb_user (user_id, name, username, password, email) VALUES ('f0ec7877-02f6-4240-a76a-94b3ac38f374', 'Jane Smith', 'jane.smith', '098f6bcd4621d373cade4e832627b4f6', 'jane.smith@example.com');
INSERT INTO tb_user (user_id, name, username, password, email) VALUES ('c5c7b3b2-8507-4e4a-b1db-992a60bb5b5e', 'Alice Johnson', 'alice.johnson', 'e99a18c428cb38d5f260853678922e03', 'alice.johnson@example.com');
INSERT INTO tb_user (user_id, name, username, password, email) VALUES ('a3b6e8e5-7c2a-48fb-8f68-1f0c4d3e6bfe', 'Bob Brown', 'bob.brown', 'c4ca4238a0b923820dcc509a6f75849b', 'bob.brown@example.com');
INSERT INTO tb_user (user_id, name, username, password, email) VALUES ('f4a0e8f9-235e-4be2-bce7-0457153f09a3', 'Emma Davis', 'emma.davis', 'eccbc87e4b5ce2fe28308fd9f2a7baf3', 'emma.davis@example.com');

INSERT INTO tb_user_role (user_id, role_id) VALUES ('f0ec7877-02f6-4240-a76a-94b3ac38f374', 'd4e0132a-b966-4b94-8051-3496f6e8d4e5');
INSERT INTO tb_user_role (user_id, role_id) VALUES ('f0ec7877-02f6-4240-a76a-94b3ac38f374', 'f0ec7877-02f6-4240-a76a-94b3ac38f374');
INSERT INTO tb_user_role (user_id, role_id) VALUES ('c5c7b3b2-8507-4e4a-b1db-992a60bb5b5e', 'd4e0132a-b966-4b94-8051-3496f6e8d4e5');
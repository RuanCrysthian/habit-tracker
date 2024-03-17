CREATE TABLE IF NOT EXISTS tb_user_role (
    user_id UUID REFERENCES tb_user(user_id),
    role_id UUID REFERENCES tb_role(role_id),
    PRIMARY KEY (user_id, role_id)
);

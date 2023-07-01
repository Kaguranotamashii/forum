create database forum;
use forum;


CREATE TABLE Users (
                       id INT PRIMARY KEY auto_increment, #用户ID，主键
                       username VARCHAR(255), #用户名
                       email VARCHAR(255), #用户邮箱
                       password VARCHAR(255),#用户密码
                       is_admin BOOLEAN #是否是管理员（true/false）
);

CREATE TABLE Tiezi (
                       id INT PRIMARY KEY auto_increment, #帖子ID，主键
                       user_id INT, #发帖用户的ID，外键关联Users表
                       title VARCHAR(255), #帖子标题
                       content TEXT, #帖子内容
                       created_at TIMESTAMP,#帖子创建时间
                       updated_at TIMESTAMP,#帖子最后更新时间
                       FOREIGN KEY (user_id) REFERENCES Users(id)
);
INSERT INTO Users (id, username, email, password, is_admin)
VALUES (1, 'songyuran', 'user1@example.com', 'password1', true),
       (2, 'liuzihe', 'user2@example.com', 'password2', false),
       (3, 'tianshaojie', 'user2@example.com', 'password2', false),
       (4, 'luqingyi', 'admin@example.com', 'adminpassword', false);

INSERT INTO forum (id, user_id, title, content, created_at, updated_at)
VALUES (1, 1, 'First Post', 'This is the first post content.', '2023-06-30 14:00:00', '2023-06-30 14:00:00'),
       (2, 1, 'Second Post', 'This is the second post content.', '2023-06-30 15:00:00', '2023-06-30 15:30:00'),
       (3, 2, 'Third Post', 'This is the third post content.', '2023-06-30 16:00:00', '2023-06-30 16:30:00');
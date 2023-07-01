create database forum;
use forum;

create table users
(
    userid       int auto_increment
        primary key,
    username     varchar(255)         null,
    useremail    varchar(255)         null,
    userpassword varchar(255)         null,
    isAdmin      tinyint(1) default 0 not null
);

create table forum
(
    fid        int auto_increment
        primary key,
    userid     int          null,
    title      varchar(255) null,
    content    text         null,
    created_at timestamp    null,
    updated_at timestamp    null,
    constraint forum_ibfk_1
        foreign key (userid) references users (userid)
);

create index user_id
    on forum (userid);


INSERT INTO forum.users (userid, username, useremail, userpassword, isAdmin) VALUES (1, 'songyuran', 'user1@example.com', 'password1', 1);
INSERT INTO forum.users (userid, username, useremail, userpassword, isAdmin) VALUES (2, 'liuzihe', 'user2@example.com', 'password2', 0);
INSERT INTO forum.users (userid, username, useremail, userpassword, isAdmin) VALUES (3, 'tianshaojie', 'user2@example.com', 'password2', 0);
INSERT INTO forum.users (userid, username, useremail, userpassword, isAdmin) VALUES (4, 'luqingyi', 'admin@example.com', 'adminpassword', 0);
INSERT INTO forum.users (userid, username, useremail, userpassword, isAdmin) VALUES (5, 'user1', 'user1@example.com', 'password1', 1);


INSERT INTO forum.forum (fid, userid, title, content, created_at, updated_at) VALUES (1, 1, 'First Post', 'This is the first post content.', '2023-06-30 14:00:00', '2023-06-30 14:00:00');
INSERT INTO forum.forum (fid, userid, title, content, created_at, updated_at) VALUES (2, 1, 'Second Post', 'This is the second post content.', '2023-06-30 15:00:00', '2023-06-30 15:30:00');
INSERT INTO forum.forum (fid, userid, title, content, created_at, updated_at) VALUES (3, 2, 'Third Post', 'This is the third post content.', '2023-06-30 16:00:00', '2023-06-30 16:30:00');


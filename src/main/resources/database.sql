USE db_webapp;

CREATE TABLE students (
    id      INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    study_group VARCHAR(50)  NOT NULL,
    course  SMALLINT     NOT NULL
);

CREATE TABLE users (
    id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled TINYINT(1)
);

CREATE TABLE authorities (
    id        INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username  VARCHAR(50) NOT NULL,
    role_name VARCHAR(50) NOT NULL,

    FOREIGN KEY (id) REFERENCES users(id)
);

CREATE TABLE user_roles (
    user_id INT NOT NULL,
    role_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES authorities (id),

    UNIQUE (user_id, role_id)
);

INSERT INTO users(username, password, enabled)
VALUES
    ('Dimevision', '{bcrypt}$2y$10$ToEtxCTfK4a8daBmmtsX9.1L5OLjN0LM2lacA.H/odBoM/HG5TQ4K', 1),
    ('Phil', '{bcrypt}$2y$10$lLWFnOJc9dHV38lDyhdnAufjSb9WglxfKwiP8IjcjLtwxLg/tUBCq', 1),
    ('Olga', '{bcrypt}$2y$10$DlSYbxitPhE.ejFgjey.Ou820R0ApzcWuqo/8E0sGXrfx.AUzy48m', 1),
    ('Peter', '{bcrypt}$2y$10$UICEQlEf0UvXmMq1KFPYAOXpVJbC.Lzutg5QPhlrWulqeJOWT5q.i', 1);

INSERT INTO authorities(username, role_name)
VALUES
    ('Dimevision', 'ADMIN'),
    ('Olga', 'TEACHER'),
    ('Phil', 'STUDENT'),
    ('Peter', 'STUDENT')

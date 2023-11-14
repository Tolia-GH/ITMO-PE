INSERT INTO characters (name) values
    ('Alvin'),
    ('Robot');

INSERT INTO locations (name) values
    ('in front of the screen'),
    ('in a small recess under the curved ceiling'),
    ('space'),
    ('to the Earth'),
    ('to Liz');

INSERT INTO events (name) values
    ('sit'),
    ('find'),
    ('feel'),
    ('disappear'),
    ('found'),
    ('lead'),
    ('follow'),
    ('perform previous duties as a pilot');

INSERT INTO status (description) values
    ('comfortably'),
    ('looking around'),
    ('surprised'),
    ('snugly'),
    ('finally'),
    ('like all these past times never happened');

INSERT INTO relations (name, subject, object) values
    ('master', 1, 2),
    ('servant', 2, 1);

INSERT INTO actions (event, subject, object, location, status, process) values
    (1, 1, null, 1, 1, 'DOING'),
    (2, 1, 2, null, 2, 'DOING'),
    (3, 1, null, null, 3, 'DONE'),
    (4, 2, null, null, null, 'DONE'),
    (5, 1, 2, 2, 5, 'DONE'),
    (1, 2, null, 2, 4, 'DOING'),
    (6, 2, 1, 4, null, 'DONE'),
    (7, 2, 1, 5, null, 'DONE'),
    (8, 1, null, null, 6, 'TODO');

INSERT INTO movements (subject, starting_location, destination_location) values
    (2, 3, 4),
    (1, 3, 4),
    (2, 4, 5),
    (1, 4, 5);

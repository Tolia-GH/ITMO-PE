--create enum 'Process'
CREATE TYPE PROCESS AS ENUM (
    'TODO',
    'DOING',
    'DONE'
);

--create table 'Characters'
CREATE TABLE characters (
    id SERIAL PRIMARY KEY,
    name VARCHAR(64) NOT NULL
);

--create table 'Locations'
CREATE TABLE locations (
    id SERIAL PRIMARY KEY,
    name VARCHAR(64) NOT NULL
);

--create table 'ActionList'
CREATE TABLE events (
    id SERIAL PRIMARY KEY,
    name VARCHAR(64) NOT NULL
);

--create table 'Status'
CREATE TABLE status (
    id SERIAL PRIMARY KEY,
    description VARCHAR(64) NOT NULL
);

--create table 'Relations'
CREATE TABLE relations (
    id SERIAL PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    subject INT NOT NULL,
    FOREIGN KEY (subject) REFERENCES characters(id),
    object INT NOT NULL,
    FOREIGN KEY (object) REFERENCES Characters(id)
);

--create table 'Actions'
CREATE TABLE actions (
    id SERIAL PRIMARY KEY,
    event INT REFERENCES events(id) NOT NULL,
    subject INT NOT NULL,
    FOREIGN KEY (subject) REFERENCES characters(id),
    object INT,
    FOREIGN KEY (object) REFERENCES characters(id),
    location INT,
    FOREIGN KEY (location) REFERENCES locations(id),
    status INT UNIQUE,
    FOREIGN KEY (status) REFERENCES status(id),
    process PROCESS NOT NULL
);

--create table 'Movements'
CREATE TABLE movements (
    id SERIAL PRIMARY KEY,
    subject INT,
    FOREIGN KEY (subject) REFERENCES characters(id),
    starting_location INT,
    FOREIGN KEY (starting_location) REFERENCES locations(id),
    destination_location INT,
    FOREIGN KEY (destination_location) REFERENCES locations(id)
);
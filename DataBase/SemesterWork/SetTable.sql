-- Create TYPE ENUM
CREATE TYPE PROBLEM_TYPE AS ENUM ('UI', 'BUGS', 'SCRIPT');
CREATE TYPE HOUSE_TYPE AS ENUM ('APARTMENTS', 'VILLAS', 'HIGH-END','ORDINARY');
CREATE TYPE DEVICE_TYPE AS ENUM ('AIR_CONDITION','LIGHT', 'HUMIDIFIER', 'BATHTUB', 'OUTLET','CURTAINS', 'FAN', 'CAMERA', 'WATER_HEATER');
CREATE TYPE SENSOR_TYPE AS ENUM ('TEMPERATURE', 'HUMIDITY', 'SMOKE');
CREATE TYPE ACTION_TYPE AS ENUM ('CLOSE','OPEN','SWITCH_OFF','SWITCH_ON','ADJUST_VALUE','TURN_ON','TURN_OFF');
CREATE TYPE SCRIPT_TYPE AS ENUM ('CONDITIONAL','SCHEDULE');
CREATE TYPE COUNTRY AS ENUM('US','UK','RUSSIAN','CHINA','FRANCE');
CREATE TYPE CITY AS ENUM('Shanghai', 'Beijing', 'Shenzhen', 'Guangzhou', 'Chengdu','Paris', 'Marseille', 'Lyon', 'Toulouse','Cambridge', 'Edinburgh',  'London', 'Liverpool','New York', 'Los Angeles', 'Chicago', 'Boston');
CREATE TYPE ROOM_TYPE AS ENUM('KITCHEN','BEDROOM','BATHROOM','LIVING');
CREATE TYPE GENDER AS ENUM ('MALE','FEMALE');

-- Create Table
CREATE TABLE IF NOT EXISTS family(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(64) NOT NULL,
    info TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS "user"(
    id SERIAL PRIMARY KEY NOT NULL,
    password VARCHAR(256) NOT NULL,
    gender GENDER NOT NULL,
    username VARCHAR(64) NOT NULL,
    age INT NOT NULL CHECK (age > 0)
);

CREATE TABLE IF NOT EXISTS supporter(
    id SERIAL PRIMARY KEY NOT NULL,
    password VARCHAR(256) NOT NULL,
    username VARCHAR(64) NOT NULL,
    is_free BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS issue(
    id SERIAL PRIMARY KEY NOT NULL,
    user_id INT NOT NULL REFERENCES "user"(id),
    supporter_id INT NOT NULL REFERENCES supporter(id),
    is_finished BOOLEAN NOT NULL DEFAULT FALSE,
    description TEXT NOT NULL,
    issue_type PROBLEM_TYPE NOT NULL,
    create_time DATE DEFAULT CURRENT_DATE
);

CREATE TABLE IF NOT EXISTS address(
    id SERIAL NOT NULL PRIMARY KEY,
    country COUNTRY NOT NULL,
    city CITY NOT NULL,
    street VARCHAR(128) NOT NULL
);

CREATE TABLE IF NOT EXISTS house(
    id SERIAL PRIMARY KEY NOT NULL,
    address_id INT REFERENCES address(id) NOT NULL,
    house_type HOUSE_TYPE NOT NULL
);

CREATE TABLE IF NOT EXISTS room(
    id SERIAL PRIMARY KEY NOT NULL,
    house_id INT NOT NULL REFERENCES house(id),
    area_size FLOAT NOT NULL,
    height FLOAT NOT NULL,
    room_type ROOM_TYPE NOT NULL,
    is_filled BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS device(
    id SERIAL PRIMARY KEY NOT NULL,
    room_id INT REFERENCES room(id) NOT NULL,
    manufacture VARCHAR(256) NOT NULL,
    available BOOLEAN NOT NULL DEFAULT TRUE,
    device_type DEVICE_TYPE NOT NULL
);

CREATE TABLE IF NOT EXISTS sensor(
    id SERIAL PRIMARY KEY NOT NULL,
    room_id INT REFERENCES room(id) NOT NULL,
    manufacture VARCHAR(256) NOT NULL,
    available BOOLEAN NOT NULL DEFAULT TRUE,
    sensor_type SENSOR_TYPE NOT NULL
);

CREATE TABLE IF NOT EXISTS device_action(
    id SERIAL PRIMARY KEY NOT NULL,
    device_type DEVICE_TYPE NOT NULL,
    action_type ACTION_TYPE NOT NULL,
    description TEXT
);

CREATE TABLE IF NOT EXISTS script(
    id SERIAL PRIMARY KEY NOT NULL,
    creator INT REFERENCES "user"(id) NOT NULL,
    script_type SCRIPT_TYPE NOT NULL
);

CREATE TABLE IF NOT EXISTS schedule_script(
    id SERIAL PRIMARY KEY NOT NULL,
    script_id INT REFERENCES script(id) NOT NULL,
    action_time TIME NOT NULL,
    repeat_on_monday BOOLEAN NOT NULL DEFAULT FALSE,
    repeat_on_tuesday BOOLEAN NOT NULL DEFAULT FALSE,
    repeat_on_wednesday BOOLEAN NOT NULL DEFAULT FALSE,
    repeat_on_thursday BOOLEAN NOT NULL DEFAULT FALSE,
    repeat_on_friday BOOLEAN NOT NULL DEFAULT FALSE,
    repeat_on_saturday BOOLEAN NOT NULL DEFAULT FALSE,
    repeat_on_sunday BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS condition_script(
    id SERIAL PRIMARY KEY NOT NULL,
    script_id INT REFERENCES script(id) NOT NULL,
    condition_text TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS contact(
    user_id INT REFERENCES "user"(id) NOT NULL UNIQUE,
    email VARCHAR(128) NOT NULL UNIQUE,
    phone_num VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS list_action_script(
    id SERIAL NOT NULL PRIMARY KEY,
    script_id INT REFERENCES script(id),
    action_id INT REFERENCES device_action(id)
);

CREATE TABLE IF NOT EXISTS list_script_user(
    id SERIAL NOT NULL PRIMARY KEY,
    script_id INT REFERENCES script(id),
    user_id INT REFERENCES "user"(id),
    UNIQUE (script_id, user_id)
);

CREATE TABLE IF NOT EXISTS list_user_house(
    id SERIAL NOT NULL PRIMARY KEY,
    user_id INT REFERENCES "user"(id),
    house_id INT REFERENCES house(id),
    UNIQUE (user_id, house_id)
);

CREATE TABLE IF NOT EXISTS list_user_family(
    id SERIAL NOT NULL PRIMARY KEY,
    user_id INT REFERENCES "user"(id),
    family_id INT REFERENCES house(id),
    UNIQUE (user_id, family_id)
);

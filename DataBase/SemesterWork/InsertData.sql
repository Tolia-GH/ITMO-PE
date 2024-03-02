-- Inserting data into "user" table
INSERT INTO "user" (id, password, gender, username, age) VALUES
    (1, '91dfd9ddb4198affc5c194cd8ce6d338fde470e2', 'MALE', 'John Doe', 25),
    (2, '7c4a8d09ca3762af61e59520943dc26494f8941b', 'FEMALE', 'Jane Smith', 30),
    (3, '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8', 'MALE', 'Bob Johnson', 22),
    (4, '6adfb183a4a2c94a2f92dab5ade762a47889a5a1', 'FEMALE', 'Zhang San', 24);

INSERT INTO family(id, name, info) VALUES
    (1, 'family of John', '3 people family'),
    (2, 'family of Zhang', 'single family');

-- Inserting data into Support_man table
INSERT INTO supporter (id, password, username, is_free) VALUES
    (1, '9297713a1c03564d7529db2667175a8fc77262bf', 'Support Person 1', true),
    (2, 'a5658598841346477d48e227ef18db8e3a4e82f2', 'Support Person 2', true),
    (3, '6486e7b9272e0dd07aaf2c7048d0382ae6e6ea96', 'Support Person 3', false);

-- Inserting data into Problem table
INSERT INTO issue (id, user_id, supporter_id, description, issue_type) VALUES
    (1, 1, 1, 'UI issue', 'UI'),
    (2, 2, 2, 'Bug in application', 'BUGS'),
    (3, 3, 3, 'Script not working', 'SCRIPT');

-- Inserting data into address table
INSERT INTO address (id, country, city, street) VALUES
    (1, 'US', 'New York', '123 Main St'),
    (2, 'UK', 'London', '456 High St'),
    (3, 'CHINA', 'Beijing', '789 East St');

-- Inserting data into House table
INSERT INTO house (id, address_id, house_type) VALUES
    (1, 1, 'APARTMENTS'),
    (2, 2, 'VILLAS'),
    (3, 3, 'HIGH-END');

-- Inserting data into Room table
INSERT INTO room (id, house_id, area_size, height, room_type, is_filled) VALUES
    (1, 1, 100.0, 3.0, 'KITCHEN', true),
    (2, 2, 200.0, 4.0, 'BEDROOM', false),
    (3, 3, 150.0, 3.5, 'BATHROOM', true);

-- Inserting data into device table
INSERT INTO device (id, room_id, manufacture, Available, device_type) VALUES
    (1, 1, 'PineApple', true, 'AIR_CONDITION'),
    (2, 2, 'Tec yes', false, 'LIGHT'),
    (3, 3, 'Da mi', true, 'BATHTUB'),
    (4, 2, 'Da mi', false, 'AIR_CONDITION'),
    (5, 3, 'Tec yes', true, 'BATHTUB'),
    (6, 1, 'PineApple', true, 'BATHTUB'),
    (7, 2, 'PineApple', false, 'LIGHT'),
    (8, 2, 'Tec yes', true, 'LIGHT');

-- Inserting data into sensor table
INSERT INTO sensor (id, room_id, manufacture, Available, sensor_type) VALUES
    (1, 1, 'PineApple', true, 'TEMPERATURE'),
    (2, 2, 'Tec yes', false, 'SMOKE'),
    (3, 3, 'Da mi', true, 'HUMIDITY'),
    (4, 2, 'Da mi', false, 'SMOKE'),
    (5, 3, 'Tec yes', true, 'TEMPERATURE'),
    (6, 1, 'PineApple', true, 'HUMIDITY'),
    (7, 2, 'PineApple', false, 'SMOKE'),
    (8, 3, 'Tec yes', true, 'SMOKE');

-- Inserting data into action table
INSERT INTO device_action (id, device_type, action_type, description) VALUES
    (1, 'AIR_CONDITION', 'SWITCH_ON', 'Turn on air conditioner'),
    (2, 'LIGHT', 'SWITCH_OFF', 'Turn off lights'),
    (3, 'BATHTUB', 'OPEN', 'Open bathtub water flow');

-- Inserting data into script table
INSERT INTO script (id, creator, script_type) VALUES
    (1, 1, 'CONDITIONAL'),
    (2, 2, 'SCHEDULE'),
    (3, 3, 'CONDITIONAL');

-- Inserting data into schedule_script table
INSERT INTO schedule_script (id, script_id, action_time) VALUES
    (1, 2, '08:00:00');

-- Inserting data into Condition_script table
INSERT INTO condition_script (id, script_id, condition_text) VALUES
    (1, 1, 'Temperature > 25'),
    (2, 3, 'Humidity < 30');

-- Inserting data into contact table
INSERT INTO contact (user_id, email, phone_num) VALUES
    (1, 'john.doe@example.com', '+71112223344'),
    (2, 'jane.smith@example.com', '+82223334455'),
    (3, 'bob.johnson@example.com', '+33334445566'),
    (4, 'zhang.san@example.com', '+91112224433');

-- Inserting data into list_action_script table
INSERT INTO list_action_script (id, script_id, action_id) VALUES
    (1, 1, 1),
    (2, 2, 2),
    (3, 3, 3);

-- Inserting data into list_script_user table
INSERT INTO list_script_user (id, script_id, user_id) VALUES
    (1, 1, 1),
    (2, 2, 2),
    (3, 3, 3);

-- Inserting data into list_user_house table
INSERT INTO list_user_house (id, user_id, house_id) VALUES
    (1, 1, 1),
    (2, 2, 2),
    (3, 3, 3);

INSERT INTO list_user_family(id, user_id, family_id) VALUES
    (1, 1, 1),
    (2, 2, 1),
    (3, 3, 1),
    (4, 4, 2);
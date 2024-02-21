--When add new issue to table, will use new_issue function to check whether the supporter is busy
CREATE OR REPLACE FUNCTION new_issue()
RETURNS TRIGGER AS $before_insert_issue_trigger$
BEGIN
    IF ((SELECT COUNT(*) FROM issue WHERE supporter_id = NEW.supporter_id AND issue.is_finished = FALSE) >3) THEN
        RAISE EXCEPTION 'You cannot dispatch this problem to a busy supporter';
    ELSIF ((SELECT COUNT(*) FROM issue WHERE supporter_id = NEW.supporter_id AND issue.is_finished = false) >= 3) THEN
        UPDATE supporter SET is_free = FALSE where supporter.id = NEW.supporter_id;
    END IF;
    Return NEW;
END;
$before_insert_issue_trigger$ LANGUAGE plpgsql;
CREATE TRIGGER before_insert_issue_trigger
BEFORE INSERT ON issue
FOR EACH ROW
EXECUTE PROCEDURE new_issue();

--When after update issue, this function will automatically set the is_free of supporter according to the number of unfinished issue
CREATE OR REPLACE FUNCTION after_update_issue()
RETURNS TRIGGER AS $after_update_issue_trigger$
BEGIN
    IF((SELECT COUNT(*) FROM issue WHERE supporter_id = NEW.supporter_id AND issue.is_finished = false)>=3) THEN
        UPDATE supporter SET is_free = FALSE WHERE supporter.id = NEW.supporter_id;
    ELSIF((SELECT COUNT(*) FROM issue WHERE supporter_id = NEW.support_man_id and issue.is_finished = false)<3) THEN
        UPDATE supporter SET is_free = TRUE WHERE supporter.id = NEW.supporter_id;
    END IF;
    IF((SELECT COUNT(*) FROM issue where support_man_id = OLD.supporter_id AND issue.is_finished = false)>=3) THEN
        UPDATE supporter SET is_free = FALSE WHERE supporter.id = OLD.support_man_id;
    ELSIF((SELECT COUNT(*) FROM issue where supporter_id = OLD.supporter_id AND issue.is_finished = false)<3) THEN
        UPDATE supporter SET is_free = TRUE WHERE supporter.id = OLD.supporter_id;
    END IF;
    RETURN NEW;
END;
$after_update_issue_trigger$ LANGUAGE plpgsql;

CREATE TRIGGER after_update_issue_trigger
AFTER UPDATE ON issue
FOR EACH ROW
EXECUTE PROCEDURE after_update_issue();

-- When before update issue, this function will check whether user give this issue to a busy supporter
CREATE OR REPLACE FUNCTION before_update_issue()
RETURNS TRIGGER AS $before_update_issue_trigger$
BEGIN
    IF((SELECT COUNT(*) FROM issue WHERE supporter_id = NEW.supporter_id AND issue.is_finished = FALSE)>=5 and NEW.is_finished = FALSE) THEN
        RAISE EXCEPTION 'Dispatch a problem to a busy support man is forbidden';
    END IF;
    RETURN NEW;
END;
$before_update_issue_trigger$ LANGUAGE plpgsql;
CREATE TRIGGER before_update_issue_trigger
BEFORE UPDATE ON issue
FOR EACH ROW
EXECUTE PROCEDURE before_update_issue();

-- When add new device to table, this function will check whether the room is filled according to the amount of device and sensor
CREATE OR REPLACE FUNCTION new_device()
RETURNS TRIGGER AS $insert_device_trigger$
BEGIN
    IF ((SELECT COUNT(*) FROM device WHERE room_id = NEW.room_id) + (SELECT COUNT(*) FROM sensor WHERE room_id = NEW.room_id) >= 10) THEN
        RAISE EXCEPTION 'Room is filled.';
    ELSIF ((SELECT COUNT(*) FROM device WHERE room_id = NEW.room_id) + (SELECT COUNT(*) FROM sensor WHERE room_id = NEW.room_id) >= 9) THEN
        UPDATE room SET is_filled = TRUE WHERE room.id = NEW.room_id;
    END IF;
    RETURN NEW;
END;
$insert_device_trigger$ LANGUAGE plpgsql;
CREATE TRIGGER insert_device_trigger
BEFORE INSERT ON device
FOR EACH ROW
EXECUTE PROCEDURE new_device();

-- When add new sensor to table, this function will check whether the room is filled according to the amount of device and sensor
CREATE OR REPLACE FUNCTION new_sensor()
RETURNS TRIGGER AS $insert_sensor_trigger$
BEGIN
    IF ((SELECT COUNT(*) FROM sensor WHERE room_id = NEW.room_id) + (SELECT COUNT(*) FROM device WHERE room_id = NEW.room_id) >= 10) THEN
        RAISE EXCEPTION 'Room is filled.';
    ELSIF ((SELECT COUNT(*) FROM sensor WHERE room_id = NEW.room_id) + (SELECT COUNT(*) FROM device WHERE room_id = NEW.room_id) >= 9) THEN
        UPDATE room SET is_filled = TRUE WHERE room.id = NEW.room_id;
    END IF;
    RETURN NEW;
END;
$insert_sensor_trigger$ LANGUAGE plpgsql;
CREATE TRIGGER insert_sensor_trigger
BEFORE INSERT ON sensor
FOR EACH ROW
EXECUTE PROCEDURE new_sensor();

--When before adding new contact to table, this function will check whether the phone number and email was used by other user
CREATE OR REPLACE FUNCTION new_contact()
RETURNS TRIGGER AS $insert_contact_trigger$
BEGIN
    IF ((SELECT COUNT(*) FROM contact WHERE phone_num = NEW.phone_num) > 0) THEN
        RAISE EXCEPTION 'This phone number is already in used';
    ELSIF ((SELECT COUNT(*) FROM contact WHERE email = NEW.email) > 0) THEN
        RAISE EXCEPTION 'This email is already in used';
    END IF;
    RETURN NEW;
END;
$insert_contact_trigger$ LANGUAGE plpgsql;

CREATE TRIGGER insert_contact_trigger
BEFORE INSERT ON contact
FOR EACH ROW
EXECUTE PROCEDURE new_contact();

--when before update contact info, this function will check whether the phone number and email was used by other user, and then check whether the new contact info is the same to the old contact info
CREATE OR REPLACE FUNCTION before_update_contact()
    RETURNS TRIGGER AS $before_update_contact_trigger$
BEGIN
    IF ((SELECT COUNT(*) FROM contact WHERE phone_num = NEW.phone_num) > 0) THEN
        RAISE EXCEPTION 'This phone number is already in used';
    ELSIF ((SELECT COUNT(*) FROM contact WHERE email = NEW.email) > 0) THEN
        RAISE EXCEPTION 'This email is already in used';
    END IF;
    IF ((OLD.phone_num = NEW.phone_num) AND (OLD.email = NEW.email)) THEN
        RAISE EXCEPTION 'Contact info did not change';
    END IF;
    RETURN NEW;
END;
$before_update_contact_trigger$ LANGUAGE plpgsql;
CREATE TRIGGER before_update_contact_trigger
BEFORE UPDATE ON contact
FOR EACH ROW
EXECUTE PROCEDURE before_update_contact();
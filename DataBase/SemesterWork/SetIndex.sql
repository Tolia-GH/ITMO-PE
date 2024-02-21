CREATE INDEX issue_index ON issue (supporter_id);
CREATE INDEX device_index ON device(room_id);
CREATE INDEX sensor_index ON sensor(room_id);
CREATE INDEX schedule_script_index ON schedule_script(script_id);
CREATE INDEX condition_script_index ON condition_script(script_id);
CREATE INDEX list_action_script_index ON list_action_script(script_id);

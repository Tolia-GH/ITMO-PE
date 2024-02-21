DROP TRIGGER before_insert_issue_trigger ON issue;
DROP TRIGGER after_update_issue_trigger ON issue;
DROP TRIGGER before_update_issue_trigger ON issue;
DROP TRIGGER insert_device_trigger ON device;
DROP TRIGGER insert_sensor_trigger ON sensor;
DROP TRIGGER insert_contact_trigger ON contact;
DROP TRIGGER before_update_contact_trigger ON contact;

DROP FUNCTION new_issue();
DROP FUNCTION after_update_issue();
DROP FUNCTION before_update_issue();
DROP FUNCTION new_device();
DROP FUNCTION new_sensor();
DROP FUNCTION new_contact();
DROP FUNCTION before_update_contact();

drop function register(varchar, varchar, integer, gender, varchar, varchar);
drop function login_by_phone(varchar, varchar);
drop function login_by_email(varchar, varchar);
drop function add_user_to_home(integer, integer);
drop function add_room_to_home(integer, double precision, double precision,
                                                    room_type);

drop function add_device_to_room(integer, varchar, boolean, device_type);

drop function add_sensor_to_room(integer, varchar, boolean, device_type);

drop function add_condition_script(text, integer);

drop function add_schedule_script(time, integer, boolean, boolean, boolean, boolean, boolean,
                                                       boolean, boolean);

drop function add_user_script(integer, integer);

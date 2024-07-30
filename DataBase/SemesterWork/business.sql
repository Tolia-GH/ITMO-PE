-- registration
create or replace function register(username_u varchar(64),password_u varchar(256), age_u int, gender_u gender,phone_u varchar(64),email_u varchar(128))
returns setof "user" as $$
DECLARE
    new_id int;
BEGIN
    insert into "user"(password, gender, username, age)  values (password_u, gender_u, username_u, age_u);
    select id from "user" order by id desc limit 1 into new_id;
    insert into contact(user_id, email, phone_num) values (new_id, email_u, phone_u);
    return query select * from "user" order by id desc limit 1;
end;
$$ language plpgsql;

-- login
create or replace function login_by_phone(phone_u varchar(64),password_u varchar(256)) returns bool as $$
BEGIN
    if (select count(*) from "user" inner join contact c on "user".id = c.user_id where "user".password = password_u and c.phone_num = phone_u) = 1 then
        return true;
    else
        return false;
    end if;
end;
$$ language plpgsql;

create or replace function login_by_email(email_u varchar(128),password_u varchar(256)) returns bool as $$
BEGIN
    if (select count(*) from "user" inner join contact c on "user".id = c.user_id where "user".password = password_u and c.email = email_u) = 1 then
        return true;
    else
        return false;
    end if;
end;
$$ language plpgsql;
select login_by_email('test@gmail.com', '481.6490150315751');

create or replace function add_user_to_home(user_id_u int, home_id int) returns setof list_user_house as $$
BEGIN
    insert into list_user_house(user_id, house_id) VALUES (user_id_u, home_id);
    return query select * from list_user_house order by id desc limit 1;
end;
$$ language plpgsql;

create or replace function add_room_to_home(house_id_u int, square_u float,height_u float, t room_type) returns setof room as $$
BEGIN
    insert into room(house_id, area_size, height, room_type) VALUES (house_id_u, square_u, height_u, t);
    return query select * from room order by id desc limit 1;
end;
$$ language plpgsql;

create or replace function add_device_to_room(room int, manu varchar(64), avai bool,ft device_type) returns setof device as $$
BEGIN
    insert into device(room_id, manufacture, Available, device_type) VALUES (room, manu, avai, ft);
    return query select * from device order by id desc limit 1;
end;
$$ language plpgsql;

create or replace function add_sensor_to_room(room int, manu varchar(64), avai bool,ft device_type) returns setof device as $$
BEGIN
    insert into sensor(room_id, manufacture, Available, sensor_type) VALUES (room, manu, avai, ft);
    return query select * from sensor order by id desc limit 1;
end;
$$ language plpgsql;

create or replace function add_condition_script(con text, creator int) returns setof script as $$
DECLARE
    new_id int = 0;
BEGIN
    insert into script(creator, type) VALUES (creator, 'CONDITIONAL');
    select script.id from script order by id desc limit 1 into new_id;
    insert into condition_script(script_id, condition) VALUES (new_id, con);
    return query select * from script order by id desc limit 1;
end;
$$ language plpgsql;

create or replace function add_schedule_script(at time, creator int, monR boolean, tueR boolean, wedR boolean, thuR boolean, friR boolean, satR boolean, sunR boolean) returns setof script as $$
DECLARE
    new_id int = 0;
BEGIN
    insert into script(creator, type) VALUES (creator, 'SCHEDULE');
    select script.id from script order by id desc limit 1 into new_id;
    insert into schedule_script(script_id, action_time, repeat_on_monday, repeat_on_tuesday, repeat_on_wendsday, repeat_on_thursday, repeat_on_friday, repeat_on_saturday, repeat_on_sunday) VALUES (new_id, at, monR, tueR, wedR, thuR, friR, satR, sunR);
    return query select * from script order by id desc limit 1;
end;
$$ language plpgsql;

create or replace function add_user_script(ui int , si int) returns setof list_script_user as $$
BEGIN
    insert into list_script_user(script_id, user_id) VALUES (si,ui);
    return query select * from list_script_user order by id desc limit 1;
end;
$$ language plpgsql;

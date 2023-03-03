set global log_bin_trust_function_creators = 1;
drop function if exists user_login;
delimiter $$
create function user_login(
	a_userId varchar(50),
	a_userPassword varchar(50)
) returns int
begin
	declare v_userPassword varchar(50);
    
    declare exit handler for not found 
		return 2;
    
    select userpassword into v_userPassword
		from users where userid = a_userid;
	
    if(v_userPassword = a_userPassword) then
		return 0;
	else
		return 1;
	end if;
end $$
delimiter ;

select user_login('java', '12345'); // 0
select user_login('java', '123451'); // 1
select user_login('java1', '12345'); // 2

drop procedure if exists user_create;
delimiter $$
create procedure user_create (
	In a_userId varchar(50),
    In a_userName varchar(50),
    In a_userPassword varchar(50),
    In a_userAge decimal(3, 0),
    In a_userEmail varchar(50),
    OUT a_rows INT
) BEGIN
	insert into users(userid, username, userpassword, userage, useremail) 
		values (a_userId, a_userName, a_userPassword, a_userAge, a_userEmail);
	select count(*) into a_rows from users; 
End $$
delimiter ;

call user_create('mysql', '에스큐엘', '1234', 30, 'my@sql.com', @rows);
select * from users;
select @rows;

# rows가 5가 나온다.

 
SET SERVEROUT ON



create table prepared (message varchar(30),id number(2));
create table startT(message varchar(30),id number(2));
create table commitT(message varchar(30),id number(2));




create or replace procedure c1
is 
i NUMBER := 0;
j NUMBER := 0;
begin 

insert into startT values('start',19);
insert into startT values('start',21);
commit;


while i < 5 
   loop
	select count(*) into j from prepared ;
	if j = 2 then 
	
	i := 10;
	insert into commitT values('commit',19);
	dbms_output.put_line('sent commit to 19');
	insert into commitT values('commit',21);
	dbms_output.put_line('sent to commit 21');
	commit;
	end if;
	dbms_lock.sleep(10);
	i := i + 1;
   end loop;

   if i = 5 then 
	insert into commitT values('abort',19);
	dbms_output.put_line('sent abort to 19');
	insert into commitT values('abort',21);	
	dbms_output.put_line('sent abort to 21');
	commit;
    end if;
end;



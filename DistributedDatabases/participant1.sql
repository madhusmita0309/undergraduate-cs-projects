

create or replace procedure p1
is
i NUMBER := 0;
j NUMBER := 0;
a NUMBER := 0;
begin 

while i < 5 
    loop 
	select count(*) into j from startT@asys  where id = 19;
	if j = 1 then
    		dbms_output.put_line('start transaction at 19');
		
		 
		i := 10;
		
		select count(*) into a from airlines;
		dbms_output.put_line('airlines:Number of airlines is');
		dbms_output.put_line(a);
		
		insert into prepared@asys values('yes',19);	 
		commit;   
	else
    		dbms_output.put_line('start message not received at 19');
	end if;
	DBMS_LOCK.sleep(5);
	i := i + 1;
     end loop;
     if i = 5 then 
	dbms_output.put_line(' airlines : NO');
        insert into prepared@asys values('no',19);	 
	commit;
     end if;

	i:=0;
	j:=0;
	while i < 5     
	loop
		select count(*) into j from commitT@asys where message='commit' and id=19;
		if j = 1 then
			dbms_output.put_line('commit message received at 19');
			commit;
			dbms_output.put_line('airlines: commit done');
			i:=10;
		end if;
	end loop;
	if i= 5 then 
		dbms_output.put_line('airlines: rollback done');
		rollback;
	end if;
end;


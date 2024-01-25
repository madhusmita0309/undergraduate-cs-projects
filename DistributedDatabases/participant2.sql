
create or replace procedure p1
is
a NUMBER := 0;
i NUMBER := 0;
j NUMBER := 0;
begin 

while i < 5 
    loop 
	select count(*) into j from startT@fsys  where id = 21;
	if j = 1 then
    		dbms_output.put_line('start transaction at 21');
		
		i := 10;	
		
		select count(*) into a from flights;
		dbms_output.put_line('flight : Number of flights is');
		dbms_output.put_line(a);
		
		insert into prepared@fsys values('yes',21);	    
		commit;
	else
    		dbms_output.put_line('start message not received at 21');
	end if;
	DBMS_LOCK.sleep(5);
	i := i + 1;
     end loop;	 
     if i = 5 then 
	dbms_output.put_line(' flight : NO');
        insert into prepared@fsys values('no',21);	 
	commit;
     end if;

	i:=0;
	j:=0;
	while i < 5     
	loop
		select count(*) into j from commitT@fsys where message='commit' and id=21;
		if j = 1 then
			dbms_output.put_line('commit message received at 21');
			commit;
			dbms_output.put_line('flight: commit done');
			i:=10;
		end if;
	end loop;
	if i= 5 then 
		dbms_output.put_line('flight: rollback done');
		rollback;
	end if;
end;
/


insert into airlines values('a001','Jet Airways','Bangalore');
insert into airlines values('a002','Air India','Chennai');
insert into airlines values('a003','Indian Airlines','Mumbai');
insert into airlines values('a004','Kingfisher','Bangalore');
insert into airlines values('a005','Fly Emirates','Chennai');
insert into airlines values('a006','Spice Jet','Mumbai');

(airlines)
create table pass1(pname varchar2(20),pid varchar2(5),address varchar2(20),
gender varchar2(2), age int, contact numeric(10,0),primary key(pid));

(flights)
create table pass2(pname varchar2(20),pid varchar2(5),address varchar2(20),
gender varchar2(2), age int, contact numeric (10,0),primary key(pid));

(travel)
create table pass3(pname varchar2(20),pid varchar2(5),address varchar2(20),
gender varchar2(2), age int, contact numeric(10,0),primary key(pid));

create or replace trigger pass
after insert or update
on passenger
for each row
begin
if:new.address='Mumbai' then insert into airlines.pass1
values(:new.pname,:new.pid,:new.address,:new.gender,:new.age,:new.contact);
else 

if:new.address='Bangalore' then insert into flights.pass2
values(:new.pname,:new.pid,:new.address,:new.gender,:new.age,:new.contact);

else

if:new.address='Chennai' then insert into travel.pass3
values(:new.pname,:new.pid,:new.address,:new.gender,:new.age,:new.contact);

end if;
end if;
end if;
end pass;


insert into passenger values('Tejal','p001','Mumbai','F',21,9833734780);
insert into passenger values('Madhu','p002','Mumbai','F',22,9133734780);
insert into passenger values('Laksh','p003','Chennai','F',39,9833736780);
insert into passenger values('MSD','p004','Bangalore','M',41,9871344780);
insert into passenger values('SRK','p005','Chennai','M',49,9855555780);
insert into passenger values('Daniel','p006','Bangalore','M',29,8833734780);


create sequence seq1 
minvalue 0
start with 0
increment by 1 ;

create or replace trigger fly1
after insert 
on booking
for each row 
begin
update flights.flights set flights.noofseats=flights.noofseats+1;
end;

(airlines)
create table agency1 (tid varchar2(5), tname varchar2(20), address varchar2(20), contact numeric(10,0),primary key(tid));
(flights)
create table agency2 (tid varchar2(5), tname varchar2(20), address varchar2(20), contact numeric(10,0),primary key(tid));
(travel)
create table agency3 (tid varchar2(5), tname varchar2(20), address varchar2(20), contact numeric(10,0),primary key(tid));


create or replace trigger abc
after insert or update
on agency
for each row
begin
if:new.address='Mumbai' then insert into airlines.agency1
values(:new.tid,:new.tname,:new.address,:new.contact);
else 

if:new.address='Bangalore' then insert into flights.agency2
values(:new.tid,:new.tname,:new.address,:new.contact);
else

if:new.address='Chennai' then insert into travel.agency3
values(:new.tid,:new.tname,:new.address,:new.contact);

end if;
end if;
end if;
end abc;

(airlines)
create table flights1(fno varchar2(5),acode varchar2(5),src varchar2(15),dest varchar2(15),dow varchar2(10),
atime interval day(0) to second(0),dtime interval day(0) to second(0),noofseats int,primary key(fno));
(flights)
create table flights2(fno varchar2(5),acode varchar2(5),src varchar2(15),dest varchar2(15),dow varchar2(10),
atime interval day(0) to second(0),dtime interval day(0) to second(0),noofseats int,primary key(fno));
(travel)
create table flights3(fno varchar2(5),acode varchar2(5),src varchar2(15),dest varchar2(15),dow varchar2(10),
atime interval day(0) to second(0),dtime interval day(0) to second(0),noofseats int,primary key(fno));




create or replace trigger fly2
after insert or update
on flights
for each row
begin
if:new.src='Mumbai' then insert into airlines.flights1
values(:new.fno ,:new.acode ,:new.src, :new.dest,:new.dow, :new.atime , :new.dtime,:new.noofseats );
else 

if:new.src='Bangalore' then insert into flights.flights2
values(:new.fno ,:new.acode ,:new.src, :new.dest,:new.dow, :new.atime , :new.dtime, :new.noofseats );
else

if:new.src='Chennai' then insert into travel.flights3
values(:new.fno ,:new.acode ,:new.src, :new.dest,:new.dow, :new.atime , :new.dtime , :new.noofseats);

end if;
end if;
end if;
end fly2;

insert into flights values('f001','a001','Mumbai','Delhi','Monday','0 12:0:0','0 14:30:00');

insert into flights values('f002','a002','Mumbai','Bangalore','Tuesday','0 12:0:0','0 15:30:00');

insert into flights values('f003','a003','Bangalore','Delhi','Monday','0 11:0:0','0 14:30:00');

insert into flights values('f004','a004','Bangalore','Mumbai','Wednesday','0 01:0:0','0 04:30:00');

insert into flights values('f005','a005','Chennai','Delhi','Monday','0 9:0:0','0 14:30:00');

insert into flights values('f006','a006','Chennai','Mumbai','Sunday','0 10:0:0','0 14:30:00');


insert into booking values('b001','p001','','f001');
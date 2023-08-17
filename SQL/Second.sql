create database Details;
use Details;
Create table details(
id int(20),
lastName varchar(30),
firstName varchar(30),
mi varchar(10),
address varchar(100),
city varchar(20),
state varchar(10),
telephone int(20),
primary key(id)
);
insert into details value(123,"Gagan Rohith","Nadella","Venkata","vellore","vellore","TN","1234567890");
select * from details;
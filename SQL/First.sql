-- create database Book;
use Book;
create table book(
title varchar(20),
author varchar(20),
pubYear varchar(20),
descr varchar(100),
primary key(title)
);
select * from book;
insert into book values("First book","gagan","1920","this is the first book");
insert into book values("Second book","gagan","1922","this is Second book"),
("third book","bhargav","1925","this is third book"),
("fourth book","bhargav","1926","this is fourth book"),
("fifth book","arjun","1927","this is fifth book"),
("Sixth book","arjun","1928","this is sixth book");

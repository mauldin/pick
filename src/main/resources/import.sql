-- create table sam.statetb(
-- stateid varchar(2) primary key,
-- statename varchar(30)
-- );
-- 
-- create table sam.caller (
-- callerid int primary key,
-- firstname varchar(20) not null,
-- lastname varchar(20) not null,
-- phonenum varchar(12) not null
-- );
-- create table sam.contact(
-- contactid int primary key,
-- firstname varchar(20) not null,
-- lastname varchar(20) not null,
-- ext varchar(8),
-- fax varchar(12)
-- );
-- 
-- create table sam.shipper(
-- shipperid int primary key,
-- shippername varchar(50) not null,
-- phone varchar(12) not null,
-- route varchar(50) not null,
-- credit varchar(50) not null,
-- comments varchar(200),
-- contactid int not null,
-- addressid int not null,
-- CONSTRAINT shipper_fk3 FOREIGN KEY (contactid)
-- -- REFERENCES sam.contact (contactid),
--  CONSTRAINT shipper_fk2 FOREIGN KEY (addressid)
-- REFERENCES sam.address (addressid)
-- );
-- create table sam.shippickup(
-- spid int primary key,
-- requesteddt date not null,
-- startshiptime time not null,
-- endshiptime time not null,
-- secondarynum varchar(12) not null,
-- spotpick varchar(1) not null,   
-- appointmentreq varchar(1) not null,
-- shipperid int not null,
-- CONSTRAINT shippick_fk FOREIGN KEY (shipperid)
-- REFERENCES sam.shipper (shipperid)
-- );
-- -- create table sam.address(
-- -- addressid int primary key,
-- -- addressOne varchar(70) not null,
-- addressTwo varchar(70) not null,
-- city varchar(50) not null,
-- stateid varchar(2) not null,
-- zip varchar(5) not null,
-- CONSTRAINT address_fk1 FOREIGN KEY (stateid)
-- REFERENCES sam.statetb (stateid)
-- );
-- -- 
-- insert into sam.STATETB values (
-- 'SC', 'South Carolina'
-- );
-- -- 
-- insert into sam.CONTACT values(
-- 1,'Test Contact',null,null
-- )

-- -- -- -- -- 
-- insert into sam.address values (1,'Wove Test Add', 'Something Yo', 'Danville', 'SC', '24541');
-- -- 

-- insert into sam.shipper values (
-- 1,'Mauldin Test Shipper', '8642001111', 'DANVILLE', 'Has Credit', 'test comment', 1,1
-- );

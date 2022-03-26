--  creat user table :users
-- userId serial,
drop table if exists users;

create table users
(
	userId  serial,
	username varchar(20),
	passwords varchar(20),
	gender varchar(10),
	notifications varchar(20),
	qualification varchar(20),
	primary key(userId)	
)



drop table if exists  employeeusers;
create table  employeeusers
(
	userId  serial,
	username varchar(20) unique,
	passwords varchar(20),
	gender varchar(10),
	notifications varchar(20),
	qualification varchar(20),
	primary key(userId)	
)

-------------- for reimbursement application --
drop table if exists reimbursement;
create table reimbursement
(
	reimburseId  serial,
	employeename varchar(20) ,
    reimburseHotel int, 
	reimburseAirplaneticket int,
	reimburseRentCar int,
	status varchar(20), 
	primary key(reimburseId),
	FOREIGN KEY (employeename) REFERENCES employeeusers(username)  
)



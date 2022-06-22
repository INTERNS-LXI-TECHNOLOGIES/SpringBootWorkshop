create schema carshowroom;
use carshowroom;

create table car (
    car_id int not null auto_increment, 
    manufacturer varchar(100) not null,
    model varchar(100) not null,
    variant varchar(10) not null,
    year int not null,
    total_kilometers int not null,
	expected_price int not null,
    other_details varchar(500),
    primary key (car_id)
);

create table role (
  role_name varchar(15) not null primary key
);
insert into role values ('ROLE_ADMIN');
insert into role values ('ROLE_USER');

create table user (
  username varchar(15) not null primary key,
  password varchar(100) not null,
  role varchar(15) not null,
  foreign key (role) references role (role_name)
);
insert into user values ('admin', '$2a$10$giqt6IFjTXvUXghLzKRoxOVW08hi0Q4ArbCH6xR4TX14v5BxpDXjm', 'ROLE_ADMIN');
insert into user values ('user', '$2a$10$PWtOUr63Wy8ExoTN.2Nc/Oaa51wH.lmqh16ntcXL5hfeCn1NxWHFC', 'ROLE_USER');

create table service_history (
   service_date datetime not null,
   total_kilometers int not null,
   showroom varchar(100) not null,
   car_id int not null,
   primary key (service_date),
   foreign key (car_id) references car (car_id)
 );
 
 create table owner (
   name varchar(100) not null,
   address varchar(100) not null,
   phone_number bigint not null primary key
 ); 
 
create table car_owner (
  car_id int not null,
  phone_number bigint not null,
  foreign key (car_id) references car (car_id),
  foreign key (phone_number) references owner (phone_number)
);
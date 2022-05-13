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
INSERT INTO role VALUES ('ROLE_ADMIN');
INSERT INTO role VALUES ('ROLE_USER');

create table user (
  username varchar(15) not null primary key,
  password varchar(100) not null,
  role varchar(15) not null,
  FOREIGN KEY (role) REFERENCES role (role_name)
);
INSERT INTO user VALUES ('admin', '$2a$10$giqt6IFjTXvUXghLzKRoxOVW08hi0Q4ArbCH6xR4TX14v5BxpDXjm', 'ROLE_ADMIN');
INSERT INTO user VALUES ('user', '$2a$10$PWtOUr63Wy8ExoTN.2Nc/Oaa51wH.lmqh16ntcXL5hfeCn1NxWHFC', 'ROLE_USER');

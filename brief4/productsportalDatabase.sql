create table Client (
	ClientID BIGSERIAL NOT NULL PRIMARY KEY ,
	ClientName VARCHAR(50) NOT NULL,
	ClientEmail VARCHAR(50) NOT NULL,
	ClientPassword VARCHAR(50) NOT NULL
);
INSERT INTO Client (ClientName, ClientEmail, ClientPassword) VALUES ('Teressa', 'tsaunper0@addtoany.com', 'xmlQR9ou6mh');
INSERT INTO Client (ClientName, ClientEmail, ClientPassword) VALUES ('Helenelizabeth', 'hgodart1@gizmodo.com', '4juBW6QVDr');
INSERT INTO Client (ClientName, ClientEmail, ClientPassword) VALUES ('Skelly', 'strotton2@digg.com', 'mmTJ3wKqf');
INSERT INTO Client (ClientName, ClientEmail, ClientPassword) VALUES ('Antin', 'amccobb3@uiuc.edu', 'A3Q8DZF4');
INSERT INTO Client (ClientName, ClientEmail, ClientPassword) VALUES ('Irwinn', 'ianglin4@go.com', 'xMiw9OY');
INSERT INTO Client (ClientName, ClientEmail, ClientPassword) VALUES ('Ericka', 'edurgan5@cisco.com', 'hE2gsUxF');
INSERT INTO Client (ClientName, ClientEmail, ClientPassword) VALUES ('Kaitlyn', 'kcolnet6@dot.gov', '6AczUhvVh');
INSERT INTO Client (ClientName, ClientEmail, ClientPassword) VALUES ('Wynn', 'wrosenfelt7@geocities.com', '6o6WVhtlDnnq');
INSERT INTO Client (ClientName, ClientEmail, ClientPassword) VALUES ('Drucy', 'dgarthland8@tripadvisor.com', '1qaR9Om56');
INSERT INTO Client (ClientName, ClientEmail, ClientPassword) VALUES ('Casar', 'ccoltart9@biblegateway.com', 't54QuwavFUK');

create table Admin (
	AdminID BIGSERIAL NOT NULL PRIMARY KEY,
	AdminName VARCHAR(50) NOT NULL,
	AdminEmail VARCHAR(50) NOT NULL,
	AdminPassword VARCHAR(50) NOT NULL
);
INSERT INTO Admin (AdminName, AdminEmail, AdminPassword) VALUES ('Orland', 'ochestney0@utexas.edu', 'XoZ7Qn');
INSERT INTO Admin (AdminName, AdminEmail, AdminPassword) VALUES ('Taber', 'tbohey1@acquirethisname.com', 'jFHUUHzutTo');
INSERT INTO Admin (AdminName, AdminEmail, AdminPassword) VALUES ('Fin', 'fyakovlev2@cloudflare.com', '6yd783t7e');
INSERT INTO Admin (AdminName, AdminEmail, AdminPassword) VALUES ('Lisle', 'ltrammel3@fda.gov', 'KujwZQ');
INSERT INTO Admin (AdminName, AdminEmail, AdminPassword) VALUES ('Naomi', 'ntunnow4@jimdo.com', 'FRTd6G');
INSERT INTO Admin (AdminName, AdminEmail, AdminPassword) VALUES ('Jerrold', 'jdomoni5@godaddy.com', 'tc5ztggkx6Z');
INSERT INTO Admin (AdminName, AdminEmail, AdminPassword) VALUES ('Agnesse', 'adelea6@vinaora.com', 'M74HK7m1Xjji');
INSERT INTO Admin (AdminName, AdminEmail, AdminPassword) VALUES ('Rozele', 'rdibaudi7@narod.ru', 'n1j4jWUp');
INSERT INTO Admin (AdminName, AdminEmail, AdminPassword) VALUES ('Haven', 'hgrise8@myspace.com', 'vjYUF8KryM8');
INSERT INTO Admin (AdminName, AdminEmail, AdminPassword) VALUES ('Heddie', 'hfavela9@shinystat.com', 'DOaUq6Ehhvc');

create table Product (
	ProductID BIGSERIAL NOT NULL PRIMARY KEY ,
	ProductName VARCHAR(50) NOT NULL,
	ProductPrice VARCHAR(50) NOT NULL,
	Stock INT NOT NULL,
	adminid int
);
ALTER TABLE product ADD CONSTRAINT adminid FOREIGN KEY(adminid) REFERENCES admin(adminid);

INSERT INTO Product (ProductName, ProductPrice, Stock,AdminID) VALUES ('Soup - French Can Pea', '$200.58', 72,4);
INSERT INTO Product (ProductName, ProductPrice, Stock,AdminID) VALUES ('Cabbage Roll', '$128.14', 18,7);
INSERT INTO Product (ProductName, ProductPrice, Stock,AdminID) VALUES ('Lettuce - Romaine', '$68.00', 19,8);
INSERT INTO Product (ProductName, ProductPrice, Stock,AdminID) VALUES ('Appetizer - Escargot Puff', '$142.32', 83,10);
INSERT INTO Product (ProductName, ProductPrice, Stock,AdminID) VALUES ('Table Cloth 62x120 Colour', '$120.11', 60,8);
INSERT INTO Product (ProductName, ProductPrice, Stock,AdminID) VALUES ('Filling - Mince Meat', '$45.03', 33,9);
INSERT INTO Product (ProductName, ProductPrice, Stock,AdminID) VALUES ('Chocolate - Semi Sweet', '$26.01', 60,1);
INSERT INTO Product (ProductName, ProductPrice, Stock,AdminID) VALUES ('Cheese - Marble', '$151.07', 88,6);
INSERT INTO Product (ProductName, ProductPrice, Stock,AdminID) VALUES ('Table Cloth 81x81 White', '$231.38', 5,5);
INSERT INTO Product (ProductName, ProductPrice, Stock,AdminID) VALUES ('Bread - French Baquette', '$138.88', 89,4);

create table Vote (
    VoteID BIGSERIAL NOT NULL PRIMARY KEY,
	VoteNbr INT NOT NULL,
	DateOfVote DATE NOT NULL,
    productid int,
    ClientID int ,
    FOREIGN KEY(productid) REFERENCES product(productid),
    FOREIGN KEY(ClientID) REFERENCES Client(ClientID)
);
insert into Vote (VoteNbr, DateOfVote,productid,ClientID) values (72, '2021-06-25',1,3);
insert into Vote (VoteNbr, DateOfVote,productid,ClientID) values (73, '2022-02-18',1,4);
insert into Vote (VoteNbr, DateOfVote,productid,ClientID) values (46, '2021-10-06',1,9);
insert into Vote (VoteNbr, DateOfVote,productid,ClientID) values (56, '2021-10-25',2,7);
insert into Vote (VoteNbr, DateOfVote,productid,ClientID) values (16, '2021-08-08',7,9);
insert into Vote (VoteNbr, DateOfVote,productid,ClientID) values (91, '2021-09-28',3,4);
insert into Vote (VoteNbr, DateOfVote,productid,ClientID) values (57, '2021-06-12',3,3);
insert into Vote (VoteNbr, DateOfVote,productid,ClientID) values (42, '2021-07-28',2,2);
insert into Vote (VoteNbr, DateOfVote,productid,ClientID) values (27, '2022-01-20',5,1);
insert into Vote (VoteNbr, DateOfVote,productid,ClientID) values (44, '2021-10-07'9,1);

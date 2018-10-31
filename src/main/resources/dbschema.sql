CREATE TABLE IF NOT EXISTS User
(
  userID varchar(50) not null,
  firstName varchar(50) not null,
  lastName varchar(50) not null,
  password varchar(50) not null,
  phoneNumber varchar(50) not null,
  email varchar(50) not null,
  PRIMARY KEY (userId)  
);

CREATE TABLE IF NOT EXISTS Category
(
  categoryId BIGINT not null,
  categoryName varchar(50) not null,
  categoryDescription varchar(255),
  PRIMARY KEY (categoryId)
);

CREATE TABLE IF NOT EXISTS Product
(
   productId bigint not null,
   productName varchar(50) not null,
   productCost decimal(5,2) not null,
   productDescription varchar(255) ,
   categoryId bigint not null,
   PRIMARY KEY (productId),
   FOREIGN KEY (categoryId) REFERENCES Category(categoryId)
   
);
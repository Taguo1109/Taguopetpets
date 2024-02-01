CREATE DATABASE Taguopetpets;

CREATE TABLE Admin (
 id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
 create_time DATETIME NOT NULL,
 email VARCHAR(255) NOT NULL,
 admin_name VARCHAR(255) NOT NULL,
 password VARCHAR(255) NOT NULL,
 phone VARCHAR(255)
);

CREATE TABLE Customers (
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
create_time DATETIME NOT NULL,
email VARCHAR(255) NOT NULL,
customer_name VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL,
phone VARCHAR(255),
birthday DATE NOT NULL,
adress VARCHAR(255),
city VARCHAR(255),
state VARCHAR(255),
zip_code VARCHAR(255)
);
ALTER TABLE Customers
CHANGE COLUMN id customer_id INT;

ALTER TABLE Customers
CHANGE COLUMN adress address VARCHAR(255);



CREATE TABLE Products (
 product_id INT PRIMARY KEY AUTO_INCREMENT,
 product_name VARCHAR(255),
 description TEXT,
 price DECIMAL(10, 2),
 stock_quantity INT,
 create_time DATETIME,
 category_id INT
);
ALTER TABLE Products
CHANGE COLUMN category_id usage_category_id INT;
ALTER TABLE Products
ADD COLUMN pet_category_id INT;
-- 添加關聯
ALTER TABLE Products
ADD CONSTRAINT fk_products_petcategories
FOREIGN KEY (pet_category_id) REFERENCES PetCategories(category_id);

ALTER TABLE Products
ADD CONSTRAINT fk_products_categories
FOREIGN KEY (usage_category_id) REFERENCES Categories(category_id);

CREATE TABLE Categories(
 category_id INT PRIMARY KEY AUTO_INCREMENT,
 category_name VARCHAR(255) NOT NULL,
 description TEXT
);
CREATE TABLE PetCategories (
  category_id INT PRIMARY KEY AUTO_INCREMENT,
  category_name VARCHAR(255) NOT NULL,
  description TEXT
);


CREATE TABLE ShippingMethods(
 shipping_method_id INT PRIMARY KEY AUTO_INCREMENT,
 ship_name VARCHAR(255),
 description TEXT,
 cost DECIMAL(10,2)
);

CREATE TABLE Orders(
 order_id INT PRIMARY KEY AUTO_INCREMENT,
 customer_id INT NOT NULL,
 product_id INT NOT NULL,
 quantity INT NOT NULL,
 total_amount DECIMAL(10,2),
 order_date DATETIME,
 shipping_method_id INT NOT NULL,
 order_status VARCHAR(50) NOT NULL,
 FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
 FOREIGN KEY (product_id) REFERENCES Products(product_id),
 FOREIGN KEY (shipping_method_id) REFERENCES ShippingMethods(shipping_method_id)
 
);

CREATE TABLE ShoppingCartItems(
	cart_item_id INT PRIMARY KEY AUTO_INCREMENT,
	customer_id INT NOT NULL,
	product_id INT NOT NULL,
	quantity INT NOT NULL,
	total_price DECIMAL(10,2) NOT NULL,
	FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
	FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

DROP TABLE IF EXISTS stock;
 
CREATE TABLE stock (
  stock_code VARCHAR(10)  PRIMARY KEY,
  stock_name VARCHAR(250) NOT NULL,
  sector VARCHAR(250) NOT NULL,
  price DECIMAL (20,2),
  create_time timestamp DEFAULT current_timestamp,
  update_time timestamp as current_timestamp
);
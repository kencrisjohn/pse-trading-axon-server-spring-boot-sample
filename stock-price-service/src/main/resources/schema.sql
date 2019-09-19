DROP TABLE IF EXISTS stock;
DROP TABLE IF EXISTS stock_price_ledger;
DROP TABLE IF EXISTS boardlot;
 
CREATE TABLE stock (
  stock_code VARCHAR(10)  PRIMARY KEY,
  stock_name VARCHAR(250) NOT NULL,
  sector VARCHAR(250) NOT NULL,
  price DECIMAL (20,2),
  create_time timestamp DEFAULT current_timestamp,
  update_time timestamp as current_timestamp
);


CREATE TABLE stock_price_ledger(
  stock_code VARCHAR(10) PRIMARY KEY,
  new_price DECIMAL(20,2),
  old_price DECIMAL(20,2),
  percentage_change DECIMAL (20,2),
  create_time timestamp DEFAULT current_timestamp,
);


CREATE TABLE boardlot(
  price_min DECIMAL(20,2),
  price_max DECIMAL(20,5),
  boardlot int(100),
  tick_size DECIMAL(20,3),
)

--
-- Table address
--
CREATE TABLE IF NOT EXISTS address (
  id serial NOT NULL,
  city VARCHAR(255) DEFAULT NULL,
  country VARCHAR(255) DEFAULT NULL,
  state VARCHAR(255) DEFAULT NULL,
  street VARCHAR(255) DEFAULT NULL,
  zip_code VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

--
-- Table customer
--
CREATE TABLE customer (
  id serial NOT NULL,
  first_name VARCHAR(255) DEFAULT NULL,
  last_name VARCHAR(255) DEFAULT NULL,
  email VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

--
-- Table orders
--
CREATE TABLE orders (
  id serial NOT NULL,
  order_tracking_number VARCHAR(255) DEFAULT NULL,
  total_price numeric(19,2) DEFAULT NULL,
  total_quantity INT DEFAULT NULL,
  billing_address_id INT DEFAULT NULL UNIQUE,
  customer_id INT DEFAULT NULL,
  shipping_address_id bigint DEFAULT NULL UNIQUE,
  status VARCHAR(128) DEFAULT NULL,
  date_created timestamp DEFAULT NULL,
  last_updated timestamp DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_customer_id FOREIGN KEY (customer_id) REFERENCES customer (id),
  CONSTRAINT FK_billing_address_id FOREIGN KEY (billing_address_id) REFERENCES address (id),
  CONSTRAINT FK_shipping_address_id FOREIGN KEY (shipping_address_id) REFERENCES address (id)
);

--
-- Table order_items
--
CREATE TABLE order_item (
  id serial NOT NULL,
  image_url` VARCHAR(255) DEFAULT NULL,
  quantity INT DEFAULT NULL,
  unit_price NUMERIC(19,2) DEFAULT NULL,
  order_id INT DEFAULT NULL,
  product_id INT DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_order_id FOREIGN KEY (order_id) REFERENCES orders (id),
  CONSTRAINT FK_product_id FOREIGN KEY (product_id) REFERENCES product (id)
);

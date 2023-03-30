INSERT INTO customer (username, password,type ) values ('hoa','123',0)
INSERT INTO customer (username, password,type ) values ('nguoimua','123',1)
INSERT INTO customer (username, password,type ) values ('khach','123',1)

-- Item
INSERT INTO item (name,price) values ('Bàn Gỗ', 1000000)
INSERT INTO item (name,price) values ('Tranh gỗ', 1200000)
INSERT INTO item (name,price) values ('Đốc lịch Gỗ', 1500000)
INSERT INTO item (name,price) values ('Tượng di lạc Gỗ', 2000000)

-- Cart
INSERT INTO cart(customerid) values (2)

-- Cart detail
INSERT INTO cartdetail(cartid,itemid,quantity,dateadded) values (1,1,2,'2023-03-20')

-- order
INSERT INTO orders(customerid,status,orderdate) values (2,0,'2023-03-20')
INSERT INTO orders(customerid,status,orderdate) values (2,0,'2023-03-21')

-- order detail
INSERT INTO orderdetail(orderid,itemid,quantity) values (1,1,2)
INSERT INTO orderdetail(orderid,itemid,quantity) values (2,3,2)


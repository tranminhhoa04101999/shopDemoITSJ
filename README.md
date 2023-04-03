# shopDemoITSJ

## Giới thiệu

Cung cấp các API cho ứng dụng demo shopDemoFE.

## Dabase Connection.
- H2 Database và được cấu hình trong file properties.

## Default Data

- file data.sql và được chạy sẵn trong cấu hình properties file
- Được khởi tạo ở `main` aplication.

## API
Link root: 
  ``` http://localhost:8080/api ```
### Customer
1. ```` POST /login ```` Đăng nhập.

- Request body với định dạng JSON với các thành phần: username password type.
- Return  JWT token.

2.```` POST /customers ```` Đăng ký.

- Request body với định dạng JSON với các thành phần: customerDto
- Return  customer vừa lưu hoặc throw Exception.

3.```` GET /customers ```` Tất cả customer.

- Return  tất cả customer với kiểu: customerDto.

4.```` GET /customers/{customerId} ```` Tìm kiếm customer theo Id.

- @PathVariable customerId định dạng Int.
- Return  customerDto khớp với id hoặc throw Exception.

5.```` POST /customers/username/{username} ```` Tìm kiếm customer theo Username.

- @PathVariable username định dạng String.
- Return  customerDto khớp với username.

### Cart

6.```` GET /carts/{customerId} ```` Tìm kiếm cart theo customerId.

- @PathVariable customerId định dạng int.
- Return cart và chi tiết giỏ được định dạng: CartDto.

7.```` POST /carts ```` Thêm item vào giỏ hàng.

- @RequestBody AddToCartDto.
- Return chi tiết giỏ vừa lưu định dạng: CartDetailDto.

8.```` PUT /carts ```` cập nhật item trong giỏ.

- @RequestBody CartDetailDto.
- Return chi tiết giỏ vừa cập nhật định dạng: CartDetailDto.

9.```` DELETE /carts/{cartDetailId} ```` xóa item trong giỏ.

- @PathVariable cartDetailId định dạng int
- Return void.

### Item

10.```` GET /items ```` lấy ra tất cả items.

- Return tất cả item đinh dạng: ItemDto.

11.```` GET /items/{itemId} ```` lấy ra item theo id.

- @PathVariable itemId định dạng int
- Return item khớp với id và định dạng: ItemDto.

12.```` POST /items ````lưu item.

- @RequestBody ItemDto.
- Return item vừa lưu với định dạng: ItemDto.

13.```` PUT /items ```` update item.

- @RequestBody ItemDto.
- Return item vừa lưu với định dạng: ItemDto.

14.```` DELETE /items/{itemId} ```` xóa item.

- @PathVariable itemId với định dạng int.
- Return true hoặc throw Exception.

### Orders

15.```` POST /orders ```` đặt hàng của cart.

- @RequestBody CartDto.
- Return: throw Exception .

16.```` GET /orders ```` lấy ra tất cả đơn đặt hàng.

- Return: List<OrdersDto> .

17.```` GET /orders/{customerId} ```` tìm đơn hàng theo customer id.

- @PathVariable customerId với đinh dạng int.
- Return: List<OrdersDto>.
 
18.```` GET /orders/lastestOrder/{customerId} ```` tìm đơn hàng mới nhất theo customer id.

- @PathVariable customerId với đinh dạng int.
- Return: OrdersDto .
  
19.```` PUT /orders ```` cập nhật order.

- @RequestBody OrdersDto.
- Return: OrdersDto .

20.```` GET /orderDetails/{orderId} ```` lấy chi tiết đơn hàng theo id đơn hàng.

- @PathVariable orderId với định dạng int.
- Return: OrderDetailDto>.


 

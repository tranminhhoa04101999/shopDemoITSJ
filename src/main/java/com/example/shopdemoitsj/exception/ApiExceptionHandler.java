package com.example.shopdemoitsj.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 *  exception handler lưu các exception của project.
 * */
@RestControllerAdvice
public class ApiExceptionHandler {
  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorMessage handleAllException(Exception ex, WebRequest request) {
    // quá trình kiểm soat lỗi diễn ra ở đây
    return new ErrorMessage(10000, ex.getLocalizedMessage());
  }

  @ExceptionHandler(ItemNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage itemNotFoundException(Exception ex, WebRequest request) {
    return new ErrorMessage(404, "Không tìm thấy item có id đó");
  }

  @ExceptionHandler(CustomerNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage customerNotFoundException(Exception ex, WebRequest request) {
    return new ErrorMessage(404, "Không tìm thấy customer có id đó");
  }

  @ExceptionHandler(OrdersNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage ordersNotFoundException(Exception ex, WebRequest request) {
    return new ErrorMessage(404, "Không tìm thấy order có id đó");
  }

  @ExceptionHandler(OrderDetailNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage orderDetailNotFoundException(Exception ex, WebRequest request) {
    return new ErrorMessage(404, "Không tìm thấy chi tiết đơn đặt hàng có id đó");
  }

  @ExceptionHandler(OrderFalse.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage orderFalseException(Exception ex, WebRequest request) {
    return new ErrorMessage(404, "đặt hàng không thành công !");
  }

  @ExceptionHandler(CartDetailNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage cartDetailNotFoundException(Exception ex, WebRequest request) {
    return new ErrorMessage(404, "Chi tiế giỏ hàng không tồn tại !");
  }

  @ExceptionHandler(EmptyCartException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorMessage emptyCart(Exception ex, WebRequest request) {
    return new ErrorMessage(400, "Giỏ hàng trống không thể đặt hàng !");
  }

  @ExceptionHandler(ItemCascadeDeleteError.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorMessage itemCascadeDeleteError(Exception ex, WebRequest request) {
    return new ErrorMessage(500, "Item đã được đặt hoặc có trong giỏ -- không thể xóa !");
  }

  @ExceptionHandler(QuantityLessThanOneException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorMessage quantityLessThanOneException(Exception ex, WebRequest request) {
    return new ErrorMessage(400, "Không được cập nhật số lượng bé hơn 1 !");
  }
}

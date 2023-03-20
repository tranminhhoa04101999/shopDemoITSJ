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
}

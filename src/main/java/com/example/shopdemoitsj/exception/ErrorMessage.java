package com.example.shopdemoitsj.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * error class .
 * */
@Data
@AllArgsConstructor
public class ErrorMessage {
  private int statusCode;
  private String message;
}

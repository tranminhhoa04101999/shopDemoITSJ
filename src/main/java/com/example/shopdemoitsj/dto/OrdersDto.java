package com.example.shopdemoitsj.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/** chuyển đổi dữ liệu giỏ hàng qua dto. */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDto implements Serializable {
  private int id;
  private int status;
  private CustomerDto customerDto;

  @Temporal(TemporalType.DATE)
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date orderDate;
}

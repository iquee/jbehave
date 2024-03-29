package com.luizhtaira.samples.bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account implements Serializable {
    String name;
    String email;
    BigDecimal total;
}

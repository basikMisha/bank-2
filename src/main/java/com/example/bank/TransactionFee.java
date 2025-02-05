package com.example.bank;

import java.math.BigDecimal;

public interface TransactionFee {
    BigDecimal applyFee(BigDecimal amount);
}
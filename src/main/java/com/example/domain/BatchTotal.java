package com.example.domain;

import java.math.BigDecimal;

public class BatchTotal {
    BigDecimal creditValue;
    BigDecimal creditCounterValueForDebit;

    public BatchTotal(BigDecimal creditValue, BigDecimal creditCounterValueForDebit) {
        this.creditValue = creditValue;
        this.creditCounterValueForDebit = creditCounterValueForDebit;
    }

    public BigDecimal getCreditValue() {
        return creditValue;
    }

    public BigDecimal getCreditCounterValueForDebit() {
        return creditCounterValueForDebit;
    }
}

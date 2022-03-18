package com.example.record.domain;

import com.example.domain.Currency;

public class TempRecord {
    String sign;
    Currency currency;
    String amount;

    public TempRecord(String sign, Currency currency, String amount) {
        this.sign = sign;
        this.currency = currency;
        this.amount = amount;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getCurrencyCode() {
        return currency.getCode();
    }

    public void setCurrencyCode(Integer currencyCode) {
        this.currency.setCode(currencyCode);
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}

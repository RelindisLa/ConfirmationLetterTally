package com.example.domain;

public class Currency {
    Integer code;
    String currencyType;

    public Currency(Integer code, String currencyType) {
        this.code = code;
        this.currencyType = currencyType;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }
}

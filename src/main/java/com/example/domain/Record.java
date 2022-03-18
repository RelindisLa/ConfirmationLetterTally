package com.example.domain;

import java.math.BigDecimal;

public class Record {
    Bank bank;
    String beneficiaryAccountNumber;
    String beneficiaryName;

    String sign;
    Currency currency;
    BigDecimal amount;

    Integer feeRecord;
    Integer isCounterTransferRecord;

    public Record(Integer feeRecord, String sign, Currency currency, BigDecimal amount,
                  Integer isCounterTransferRecord, String beneficiaryAccountNumber,
                  String beneficiaryName, Bank bank) {
        this.feeRecord = feeRecord;
        this.sign = sign;
        this.currency = currency;
        this.amount = amount;
        this.isCounterTransferRecord = isCounterTransferRecord;
        this.beneficiaryAccountNumber = beneficiaryAccountNumber;
        this.beneficiaryName = beneficiaryName;
        this.bank = bank;
    }

    public Integer getFeeRecord() {
        return feeRecord;
    }

    public String getSign() {
        return sign;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Integer getIsCounterTransferRecord() {
        return isCounterTransferRecord;
    }

    public String getBeneficiaryAccountNumber() {
        return beneficiaryAccountNumber;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public Bank getBank() {
        return bank;
    }
}

package com.example.domain;

import java.math.BigDecimal;
import java.util.Map;

public class Client {
    Map<String, String> profile;
    String creditDebit;
    String counterTransfer;
    String amountDivider;

    public Client(Map<String, String> profile, String creditDebit,
                  String counterTransfer, String amountDivider) {
        this.profile = profile;
        this.creditDebit = creditDebit;
        this.counterTransfer = counterTransfer;
        this.amountDivider = amountDivider;
    }

    public Map<String, String> getProfile() {
        return profile;
    }

    public String getCreditDebit() {
        return creditDebit;
    }

    public String getCounterTransfer() {
        return counterTransfer;
    }

    public String getAmountDividerString() {
        return amountDivider;
    }
    public BigDecimal getAmountDivider() {
        return new BigDecimal(amountDivider);
    }
}

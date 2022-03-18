package com.example.dao;

import com.example.domain.Currency;
import com.example.record.service.impl.Constants;

import java.util.Map;

public class CurrencyDao {
    public String retrieveCurrencyDefault(Map<String, String> profile) {
        return profile.get("defaultCurrency");
    }

    public Currency retrieveCurrencyOnId(Integer id) {
        if (id.equals(Constants.EUR_CURRENCY_CODE)) {
            return new Currency(Constants.EUR_CURRENCY_CODE, Constants.CURRENCY_EURO);
        }
        if (id.equals(Constants.FL_CURRENCY_CODE)) {
            return new Currency(Constants.FL_CURRENCY_CODE, Constants.CURRENCY_FL);
        }
        if (id.equals(Constants.USD_CURRENCY_CODE)) {
            return new Currency(Constants.USD_CURRENCY_CODE, Constants.CURRENCY_USD);
        }
        return new Currency(Constants.FL_CURRENCY_CODE_FOR_WEIRD_BANK, Constants.CURRENCY_FL);
    }
}

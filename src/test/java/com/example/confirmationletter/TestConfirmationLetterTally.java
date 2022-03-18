package com.example.confirmationletter;

import com.example.dao.CurrencyDao;
import com.example.domain.*;
import com.example.record.domain.TempRecord;
import com.example.record.service.impl.Constants;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestConfirmationLetterTally {

    @Test
    public void testTally() {
        ConfirmationLetterTally clt = new ConfirmationLetterTally();
        Map<String, String> profile = new HashMap<>();
        Client client = new Client(profile, "+", "false", "100");
        Currency eur = new Currency(Constants.EUR_CURRENCY_CODE, Constants.CURRENCY_EURO);
        Currency fl = new Currency(Constants.FL_CURRENCY_CODE, Constants.CURRENCY_FL);

        List<TempRecord> ltr = new ArrayList<>();
        ltr.add(new TempRecord("+", eur, "30"));
        ltr.add(new TempRecord("+", eur, "80"));
        ltr.add(new TempRecord("-", fl, "130"));
        ltr.add(new TempRecord("-", fl, "70"));
        ltr.add(new TempRecord("+", fl, "90"));

        List<TempRecord> ltr2 = new ArrayList<>();
        ltr.add(new TempRecord("+", eur, "130"));
        ltr.add(new TempRecord("+", eur, "180"));
        ltr.add(new TempRecord("-", fl, "2130"));
        ltr.add(new TempRecord("-", fl, "270"));
        ltr.add(new TempRecord("+", fl, "290"));
        Bank b1 = new Bank("Scrooge Inc.");

        List<Record> lr = new ArrayList<>();
        lr.add(new Record(1, "+", eur, BigDecimal.valueOf(100), 0, "123-45678", "Martin M. Murray", b1));
        lr.add(new Record(1, "+", eur, BigDecimal.valueOf(20), 0, "123-45681", "Mia M. Mitchell", b1));
        lr.add(new Record(0, "+", fl, BigDecimal.valueOf(40), 1, "223-45677", "Jane J. Jones", b1));
        lr.add(new Record(0, "+", fl, BigDecimal.valueOf(30), 0, "223-45677", "Jane J. Jones", b1));

        Map<Integer, BatchTotal> batchTotals = new HashMap<>();
        batchTotals.put(1, new BatchTotal(BigDecimal.valueOf(1000), BigDecimal.valueOf(2500)));
        batchTotals.put(2, new BatchTotal(BigDecimal.valueOf(2000), BigDecimal.valueOf(2100)));
        batchTotals.put(3, new BatchTotal(BigDecimal.valueOf(3000), BigDecimal.valueOf(1200)));

        Map<String, BigDecimal> res = clt.calculateAmounts(client, lr,
                new CurrencyDao(), null, ltr, ltr2, batchTotals);
        Assert.assertEquals(BigDecimal.valueOf(420), res.get("EUR"));
        Assert.assertEquals(BigDecimal.valueOf(2250), res.get("FLD"));
        Assert.assertEquals(BigDecimal.valueOf(60), res.get("CreditBatchTotal"));
        Assert.assertEquals(BigDecimal.valueOf(58), res.get("DebitBatchTotal"));
    }

    @Test
    public void creditBatchTotalWithoutFraction(){
        List<BatchTotal> batchTotals = new ArrayList<>();
        batchTotals.add(new BatchTotal(BigDecimal.valueOf(1000), BigDecimal.ZERO));
        batchTotals.add(new BatchTotal(BigDecimal.valueOf(2000), BigDecimal.ZERO));
        batchTotals.add(new BatchTotal(BigDecimal.valueOf(3000), BigDecimal.ZERO));

        ConfirmationLetterTally clt = new ConfirmationLetterTally();
        BigDecimal result = clt.creditBatchTotal(batchTotals, BigDecimal.valueOf(100));

        Assert.assertEquals(BigDecimal.valueOf(60), result);
    }

    @Test
    public void creditBatchTotalWithFraction(){
        List<BatchTotal> batchTotals = new ArrayList<>();
        batchTotals.add(new BatchTotal(BigDecimal.valueOf(1001), BigDecimal.ZERO));
        batchTotals.add(new BatchTotal(BigDecimal.valueOf(2022), BigDecimal.ZERO));
        batchTotals.add(new BatchTotal(BigDecimal.valueOf(3003), BigDecimal.ZERO));

        ConfirmationLetterTally clt = new ConfirmationLetterTally();
        BigDecimal result = clt.creditBatchTotal(batchTotals, BigDecimal.valueOf(100));

        Assert.assertEquals(BigDecimal.valueOf(60.26), result);
    }


}

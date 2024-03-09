package org.ratomidev;

import org.ratomidev.model.BankTransaction;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }
    public double calculateTotalAmount() {
        double total = 0d;
        for(final BankTransaction bankTransaction: bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }
    public  double calculateTotalAmount(final Month month) {
        double total =0d;
        for(final BankTransaction bankTransaction: bankTransactions) {
            if(bankTransaction.getDate().getMonth().equals(month)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }
    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
        return bankTransactions.stream()
                .filter(bankTransaction -> bankTransaction.getAmount() >= amount)
                .collect(Collectors.toList());
    }
    public List<BankTransaction> findTransactionsInMonth(final Month month) {
        return bankTransactions.stream()
                .filter(bankTransaction -> bankTransaction.getDate().getMonth().equals(month))
                .collect(Collectors.toList());
    }

    public List<BankTransaction> findTransactionsInMonthAndGraterAmount( final Month month, final double amount) {
        return
                bankTransactions.stream().filter(e->e.getDate().getMonth()==month)
                        .filter(e->e.getAmount()>=amount).collect(Collectors.toList());
    }
    public List<BankTransaction> findTransactions(final BankTransactionsFilter bankTransactionsFilter) {
        final List<BankTransaction> result = new ArrayList<>();
        for(final BankTransaction bankTransaction: bankTransactions) {
            if(bankTransactionsFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        return result;

    }


}

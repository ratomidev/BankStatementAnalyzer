package org.ratomidev;

import org.ratomidev.model.BankTransaction;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@FunctionalInterface
interface BankTransactionsFilter {
    public boolean test(BankTransaction bankTransaction);
}
public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;
    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }
    public Double calcultateAverageAmount() {
        OptionalDouble average = bankTransactions.stream().map(bankTransaction -> bankTransaction.getAmount())
                .mapToDouble(Double::doubleValue)
                .average();
        if(average.isPresent()) {
            return average.getAsDouble();
        }else {
            return null;
        }
    }
    public double calculateTotalAmount() {
        double total = 0d;
        for(final BankTransaction bankTransaction: bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }
    public double calculateMinAmount() {
        Optional<Double> optionalDouble = bankTransactions.stream()
                .map(transaction->transaction.getAmount())
                .min(Double::compare);
        if(optionalDouble.isPresent()) {
            return optionalDouble.get();
        }
        else{
            return 0;
        }
    }
    public double calculateMaxAmount() {

            Optional<Double> optionalDouble = bankTransactions.stream()
                    .map(transaction->transaction.getAmount())
                    .max(Double::compare);
            if(optionalDouble.isPresent()) {
                return optionalDouble.get();
            }
            else{
                return 0;
            }
    }
    public  double calculateTotalInMonth(final Month month) {
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

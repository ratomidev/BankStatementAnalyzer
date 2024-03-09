package org.ratomidev;

import org.ratomidev.model.BankTransaction;

@FunctionalInterface
public interface BankTransactionsFilter {
    public boolean test(BankTransaction bankTransaction);

}

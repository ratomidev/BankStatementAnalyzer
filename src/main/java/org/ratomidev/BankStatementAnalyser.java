package org.ratomidev;

import org.ratomidev.model.BankTransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyser {
    private static final String RESOURCES = "src/main/resources/";

    public void analyse(String filename,
                               BankStatementParser bankStatementCSVParser
                               ) throws IOException {
        final Path path = Paths.get(RESOURCES+filename);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions =
                bankStatementCSVParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);

    }
    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("total of all months " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("total of Junary " + bankStatementProcessor.calculateTotalAmount(Month.JANUARY));
        System.out.println("transaction that grater than 1000");
        bankStatementProcessor.findTransactionsGreaterThanEqual(6000)
                .stream().forEach(System.out::println);

        System.out.println("transaction that in Junnary");
        bankStatementProcessor.findTransactionsInMonth(Month.JANUARY)
                .stream().forEach(System.out::println);

        System.out.println("Transaction that in month with amount");
        bankStatementProcessor.findTransactionsInMonthAndGraterAmount(Month.JANUARY, -75)
                .forEach(System.out::println);
        System.out.println("the last feature");
        bankStatementProcessor.findTransactions(bankTransaction ->
                bankTransaction.getAmount()==6000 || bankTransaction.getDescription().equals("Cinema") ).forEach(System.out::println);
    }
}

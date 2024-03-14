package org.ratomidev;

import org.ratomidev.model.BankTransaction;
import org.ratomidev.model.SummaryStatistics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyser {
    private static final String RESOURCES = "src/main/resources/";

    public SummaryStatistics analyse(String fileName,
                               BankStatementParser bankStatementCSVParser
                               ) throws IOException {


        final List<BankTransaction> bankTransactions =
                bankStatementCSVParser.parseFile(fileName);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        final SummaryStatistics summaryStatistics = new SummaryStatistics(bankStatementProcessor.calculateTotalAmount(),
                bankStatementProcessor.calculateMaxAmount(),
                bankStatementProcessor.calculateMinAmount(),
                bankStatementProcessor.calcultateAverageAmount());
        return summaryStatistics;

    }
    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("total of all months " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("total of Junary " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("transaction that grater than 1000");
        bankStatementProcessor.findTransactionsGreaterThanEqual(6000)
                .stream().forEach(System.out::println);

        System.out.println("transaction that in Junnary");
        bankStatementProcessor.findTransactionsInMonth(Month.JANUARY)
                .stream().forEach(System.out::println);

        System.out.println("the last feature");
        bankStatementProcessor.findTransactions(bankTransaction ->
                bankTransaction.getAmount()==6000 || bankTransaction.getDescription().equals("Cinema") ).forEach(System.out::println);
        System.out.println("calculate the average amount");
        System.out.println(bankStatementProcessor.calcultateAverageAmount());
    }
}

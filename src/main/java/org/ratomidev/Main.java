package org.ratomidev;
import org.ratomidev.model.SummaryStatistics;

import java.io.IOException;

public class Main {
    public static void main(String[] args)  throws IOException{
        BankStatementParser bankStatementParser = new BankStatementCSVParser();
        BankStatementAnalyser bankStatementAnalyser = new BankStatementAnalyser();
        SummaryStatistics summaryStatistics = bankStatementAnalyser.analyse("transactions.csv",
                bankStatementParser);
        Exporter htmlExporter = new JsonExporter();
        String htmlPage = htmlExporter.export(summaryStatistics);
        System.out.println(htmlPage);

    }
}
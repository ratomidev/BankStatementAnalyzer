package org.ratomidev;
import org.ratomidev.model.SummaryStatistics;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BankStatementParser bankStatementParser = new BankStatementJSONParser();
        BankStatementAnalyser bankStatementAnalyser = new BankStatementAnalyser();
        SummaryStatistics summaryStatistics = bankStatementAnalyser.analyse("transactions.json",
                bankStatementParser);
        XmlExporter htmlExporter = new XmlExporter();
        try {
            String htmlPage = htmlExporter.export(summaryStatistics);
            System.out.println(htmlPage);

        } catch (Exception exception) {
            System.out.println(exception);
        }

    }
}
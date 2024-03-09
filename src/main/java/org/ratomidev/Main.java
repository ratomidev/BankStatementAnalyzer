package org.ratomidev;
import java.io.IOException;

public class Main {
    public static void main(String[] args)  throws IOException{
        BankStatementParser bankStatementParser = new BankStatementCSVParser();
        BankStatementAnalyser bankStatementAnalyser = new BankStatementAnalyser();
        bankStatementAnalyser.analyse("transactions.csv",
                bankStatementParser);
        System.out.println("work");

    }
}
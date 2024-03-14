package org.ratomidev;

import org.ratomidev.model.BankTransaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface BankStatementParser {
//    BankTransaction parseFrom(String line);
//    List<BankTransaction> parseLinesFrom(List<String> lines);

    BankTransaction parseObject(Object object);
    List<BankTransaction> parseFile(String fileName) throws IOException;
}

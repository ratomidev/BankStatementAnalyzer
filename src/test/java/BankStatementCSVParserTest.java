import org.junit.Assert;
import org.junit.Test;
import org.ratomidev.BankStatementCSVParser;
import org.ratomidev.model.BankTransaction;

import java.time.LocalDate;
import java.time.Month;

public class BankStatementCSVParserTest {

    private final BankStatementCSVParser bankStatementCSVParser
            = new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorectLine() throws Exception {
        final String line = "30-01-2017,-50,Tesco";
        final BankTransaction result = bankStatementCSVParser.parseFrom(line);
        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30),
                -50, "Tesco");
        final double tolerance = 0.0d;
        Assert.assertEquals(expected.getDate(), result.getDate());
        Assert.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
        Assert.assertEquals(expected.getDescription(), result.getDescription());
    }
}

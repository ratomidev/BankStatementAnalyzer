import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.ratomidev.BankStatementCSVParser;
import org.ratomidev.model.BankTransaction;

import java.time.LocalDate;
import java.time.Month;

public class BankStatementCSVParserTest {

    private final BankStatementCSVParser bankStatementCSVParser
            = new BankStatementCSVParser();

    @Ignore
    public void shouldParseOneCorrectLine() throws Exception {
        final String line = "30-01-2017,-50,Tesco";
        final BankTransaction result = bankStatementCSVParser.parseFrom(line);
        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30),
                -50, "Tesco");
        final double tolerance = 0.0d;
        Assert.assertEquals(expected.getDate(), result.getDate());
        Assert.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
        Assert.assertEquals(expected.getDescription(), result.getDescription());
    }

    @Ignore
    public void shouldHandleEmptyLine() throws Exception {
        final String line = "";
        final BankTransaction result = bankStatementCSVParser.parseFrom(line);

        Assert.assertNull(result);
   }
//    @Test
//    public void shouldHandleInvalidDate() throws Exception {
//        final String line = "30-01-200017,-50,Tesco";
//        final BankTransaction result = bankStatementCSVParser.parseFrom(line);
//
//        Assert.assertNull(result);
//    }
//    @Test
//    public void shouldHandleInvalidDate2() throws Exception {
//        final String line = "s-01-2007,-50,Tesco";
//        final BankTransaction result = bankStatementCSVParser.parseFrom(line);
//
//        Assert.assertNull(result);
//    }
//    @Test
//    public void shouldHandleInvalidDate3() throws Exception {
//        final String line = "80-01-2007,-50,Tesco";
//        final BankTransaction result = bankStatementCSVParser.parseFrom(line);
//
//        Assert.assertNull(result);
//    }
//    @Test
//    public void shouldHandleInvalidDate4() throws Exception {
//        final String line = "v,-50,Tesco";
//        final BankTransaction result = bankStatementCSVParser.parseFrom(line);
//
//        Assert.assertNull(result);
//    }
}

package ard;

import org.junit.Test;

import java.io.StringReader;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ArdNewTest {

    @Test
    public void testExpandSimple() throws SyntaxException, ParserException {
        String input = "ba2";
        String expected = "baa";

        String result = getParseResult(input);
        assertThat(result, is(expected));
    }


    @Test
    public void testExpandModerate() throws SyntaxException, ParserException {
        String input = "(ba)2";
        String expected = "baba";

        String result = getParseResult(input);
        assertThat(result, is(expected));
    }


    @Test
    public void testExpandDifficult() throws SyntaxException, ParserException {
        String input = "(a(bc)2)3(ba)2";
        String expected = "abcbcabcbcabcbcbaba";

        String result = getParseResult(input);
        assertThat(result, is(expected));
    }

    private String getParseResult(String input) throws SyntaxException, ParserException {
        ArdNew ardNew = new ArdNew(new StringReader(input));
        ardNew.parse();
        return ardNew.getExpandedExpression();
    }

}
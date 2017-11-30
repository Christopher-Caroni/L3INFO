package ard;

import java.io.Reader;

public class ArdNew extends Ard {


    private String expandedExpression;

    public ArdNew(Reader in) {
        super(in);
        expandedExpression = "";
    }


    @Override
    protected void axiom() throws SyntaxException, ParserException {
        expandedExpression = S();
    }


    private String S() throws SyntaxException, ParserException {
        switch (current) {
            case 'a':
            case 'b':
            case 'c':
            case '(':
                String ret = "";
                String content = E();
                int repetitions = R();
                for (int i = 0; i < repetitions; i++)
                    ret += content;
                ret += S();
                return ret;
            case ')':
            case END_MARKER:
                return "";
            default:
                throw new SyntaxException(ErrorType.NO_RULE, current);
        }
    }


    private String E() throws SyntaxException, ParserException {
        switch (current) {
            case 'a':
            case 'b':
            case 'c':
                return L();
            case '(':
                eat('(');
                String s = S();
                eat(')');
                return s;
            default:
                throw new SyntaxException(ErrorType.NO_RULE, current);
        }
    }


    private int R() throws SyntaxException, ParserException {
        switch (current) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return C();

            case 'a':
            case 'b':
            case 'c':
            case '(':
            case ')':
            case END_MARKER:
                return 1;
            default:
                throw new SyntaxException(ErrorType.NO_RULE, current);
        }
    }


    private String L() throws SyntaxException, ParserException {
        switch (current) {
            case 'a':
            case 'b':
            case 'c':
                String original = "" + current;
                eat(current);
                return original;
            default:
                throw new SyntaxException(ErrorType.NO_RULE, current);
        }
    }


    private int C() throws SyntaxException, ParserException {
        switch (current) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                String original = "" + current;
                eat(current);
                return Integer.parseInt(original);
            default:
                throw new SyntaxException(ErrorType.NO_RULE, current);
        }
    }


    public String getExpandedExpression() {
        return expandedExpression;
    }


}
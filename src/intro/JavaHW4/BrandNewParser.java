//package JavaHW4;
//
///**
// * Created by vrom911 on 11/11/16.
// * E -> E + E | E - E | E * E | E / E | n | (E) | -E | E ^ E
// *
// * E -> T + E | T - E
// * T -> F * E | F / E
// * F -> n | (E) | -E
// *
// * Exp -> T Exp'
// * Exp' -> +Exp | -Exp | eps
// * T -> F T'
// * T' -> *E | /E
// * F -> n | (E) | -E
// */
//public class BrandNewParser {
//    private Integer getTocken() {
//
//    }
//
//    private TripleOperation expression() {
//        TripleOperation result = signTerm();
//        return
//    }
//
//    private TripleOperation expressionN() {
//
//
//    }
//
//    private TripleOperation signTerm() {
//
//    }
//
//    private TripleOperation termN() {
//
//    }
//
//    private TripleOperation term() {
//
//    }
//
//    private TripleOperation signFactor() {
//
//    }
//
//    private TripleOperation factorN() {
//
//    }
//
//    private TripleOperation factor() {
//
//    }
//
//    private TripleOperation argument() {
//        TripleOperation result = null;
//        if (curToken == FUNC) {
//            result = new Const(curToken.value);
//        } else if (curToken == OPEN_BR) {
//            nextToken();
//            result = expression();
//            if (curToken != CLOSE_BR) {
//                throw new ParserException("Closing brackets expected");
//            }
//            nextToken();
//        } else {
//            result = value();
//        }
//        return result;
//    }
//
//    private TripleOperation value() {
//        TripleOperation result = null;
//        if (curToken == CONST) {
//            result = new Const(curToken.value);
//        } else if (curToken == VAR) {
//            result = new Variable(curToken.value);
//        } else if (curToken == EPS) {
//            throw new EndOfExpresion();
//        } else {
//            throw new SomeError();
//        }
//        nextToken();
//        return result;
//    }
//}

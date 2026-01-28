package uk.ac.rhul.cs2800.cw2.calculator;

import uk.ac.rhul.cs2800.cw2.data.Symbol;
import uk.ac.rhul.cs2800.cw2.exception.InvalidExpression;

/**
 * The Operator class is used for carrying out operations. This class is final and has only static
 * methods so does not require an instance to be used.
 * 
 * @author Joseph Beck
 */
public final class Operator {

  /**
   * Mathematical operation on two given arguments.
   * 
   * @param left argument of the operation.
   * @param right argument of the operation.
   * @param symbol or operation of the operation.
   * @return the result of the operation between the left and right arguments.
   * @throws InvalidExpression when an incorrect symbol is found.
   */
  public static float operate(float left, float right, Symbol symbol) throws InvalidExpression {
    switch (symbol) {
      case PLUS:
        return left + right;
      case MINUS:
        return left - right;
      case TIMES:
        return left * right;
      case DIVIDE:
        return left / right;
      default:
        throw new InvalidExpression();
    }
  }

  /**
   * Gives a boolean values of whether the given String is an operator symbol, like a +, -, / or *.
   * 
   * @param string input
   * @return is the input +, -, / or *
   */
  public static boolean isOperator(String string) {
    Symbol symbol = Symbol.fromString(string);
    return (symbol.equals(Symbol.PLUS) || symbol.equals(Symbol.MINUS) || symbol.equals(Symbol.TIMES)
        || symbol.equals(Symbol.DIVIDE));
  }

  /**
   * Compare the precedence of two symbols, this is used for calculation ordering in an Infix
   * calculator.
   * 
   * @param one or the first Symbol.
   * @param two or the second Symbol.
   * @return the comparison of the precedence of the two variables.
   */
  public static int comparePrecedence(Symbol one, Symbol two) {
    return one.getPrecedence() - two.getPrecedence();
  }

}

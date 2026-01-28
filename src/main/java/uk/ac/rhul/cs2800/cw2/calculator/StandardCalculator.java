package uk.ac.rhul.cs2800.cw2.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import uk.ac.rhul.cs2800.cw2.data.Symbol;
import uk.ac.rhul.cs2800.cw2.exception.InvalidExpression;
import uk.ac.rhul.cs2800.cw2.stack.SymbolStack;

/**
 * Standard Calculator for calculating a given expression with infix notation. This works by
 * converting the expression into a Reverse Polish Notation expression using the Shunting Yard
 * algorithm.
 * 
 * @author Joseph Beck
 */
public class StandardCalculator implements EvaluationInterface {

  /**
   * ReversePolishCalculator instance, used for calculating the result.
   */
  private ReversePolishCalculator reversePolishCalculator;

  /**
   * Create an instance of the StandardCalculator.
   */
  public StandardCalculator() {
    reversePolishCalculator = new ReversePolishCalculator();
  }

  /**
   * Converts an expression into an array of Tokens, a token is either a symbol or digit.
   * 
   * @param expression being parsed into Tokens.
   * @return array of Tokens from the given expression.
   */
  private String[] tokenise(String expression) {
    Pattern pattern = Pattern.compile("\\d+|[-+*/()]");
    Matcher matcher = pattern.matcher(expression);

    int tokenCount = 0;
    while (matcher.find()) {
      tokenCount++;
    }

    String[] tokens = new String[tokenCount];
    matcher.reset();

    int index = 0;
    while (matcher.find()) {
      tokens[index++] = matcher.group();
    }

    return tokens;
  }

  /**
   * Evaluate an expression using standard / infix notation. This uses a SymbolStack,
   * ReversePolishCalculator and a StringBuilder to convert infix to reverse polish notation. This
   * method uses the Shunting Yard algorithm.
   * 
   * @param expression being evaluated.
   * @return the calculated value.
   * @throws InvalidExpression when the expression is incorrect and cannot be evaluated.
   */
  @Override
  public float evaluate(String expression) throws InvalidExpression {
    if (expression == null || expression == "") {
      return 0f;
    }

    SymbolStack symbolStack = new SymbolStack();
    // StringBuilder is faster than string concatenation.
    StringBuilder reversePolishBuilder = new StringBuilder();
    // Expression must be tokenised instead of scanned because Scanner is more whitespace dependent.
    String[] tokens = tokenise(expression);

    for (String token : tokens) {
      if (Operator.isOperator(token)) {
        while (symbolStack.size() != 0) {
          Symbol symbol = Symbol.fromString(token);
          Symbol top = symbolStack.top();

          if (Operator.comparePrecedence(symbol, top) <= 0
              || Operator.comparePrecedence(symbol, top) < 0) {
            reversePolishBuilder.append(symbolStack.pop().getSymbol() + " ");
            continue;
          }

          break;
        }

        symbolStack.push(Symbol.fromString(token));
      } else if (Symbol.fromString(token).equals(Symbol.LEFT_BRACKET)) {
        symbolStack.push(Symbol.fromString(token));
      } else if (Symbol.fromString(token).equals(Symbol.RIGHT_BRACKET)) {
        while (symbolStack.size() != 0) {
          if (symbolStack.top().equals(Symbol.LEFT_BRACKET)) {
            break;
          }

          reversePolishBuilder.append(symbolStack.pop().getSymbol() + " ");
        }
        symbolStack.pop();
      } else {
        reversePolishBuilder.append(token + " ");
      }
    }

    while (symbolStack.size() != 0) {
      reversePolishBuilder.append(symbolStack.pop().getSymbol() + " ");
    }

    return reversePolishCalculator.evaluate(reversePolishBuilder.toString());
  }

}

package uk.ac.rhul.cs2800.cw2.calculator;

import java.util.Scanner;
import uk.ac.rhul.cs2800.cw2.data.Symbol;
import uk.ac.rhul.cs2800.cw2.exception.InvalidExpression;
import uk.ac.rhul.cs2800.cw2.stack.NumberStack;

/**
 * Reverse Polish Calculator, allows expressions in the Reverse Polish Notation to be evaluated and
 * return an answer, for example "2 1 +" will give 3f. This also implements the EvaluationInterface,
 * which requires the evaluate method to exist.
 * 
 * @author Joseph Beck
 */
public class ReversePolishCalculator implements EvaluationInterface {

  /**
   * Create an instance of the ReversePolishCalculator.
   */
  public ReversePolishCalculator() {}

  /**
   * Evaluate an expression using Reverse Polish Notation.
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

    NumberStack numberStack = new NumberStack();
    Scanner scanner = new Scanner(expression);

    while (scanner.hasNext()) {
      if (scanner.hasNextInt()) {
        numberStack.push((float) scanner.nextInt());
        continue;
      }

      String token = scanner.next();
      Symbol symbol = Symbol.fromString(token);

      if (symbol == Symbol.LEFT_BRACKET || symbol == Symbol.RIGHT_BRACKET) {
        scanner.close();
        throw new InvalidExpression();
      }

      float left = numberStack.pop();
      float right = numberStack.pop();

      float result = Operator.operate(right, left, symbol);
      numberStack.push(result);
    }

    scanner.close();
    return numberStack.pop();
  }

}

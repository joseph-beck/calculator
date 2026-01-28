package uk.ac.rhul.cs2800.cw2.calculator;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.cw2.exception.InvalidExpression;

/**
 * Test the ReversePolishCalculator, this is done by giving a variety of different expressions, some
 * designed to throw errors, others to stress the algorithm.
 * 
 * @author Joseph Beck
 */
class ReversePolishCalculatorTest {

  /**
   * ReversePolishStack instance being used for testing.
   */
  private ReversePolishCalculator calculator;

  @BeforeEach
  void setUp() throws Exception {
    calculator = new ReversePolishCalculator();
  }

  /**
   * Test that an instance of the ReversePolishCalculator can be created and that the class is of
   * the correct type.
   */
  @Test
  void testReversePolishCalculator() {
    ReversePolishCalculator calculator = new ReversePolishCalculator();
    assertNotNull(calculator);
    assertEquals(calculator.getClass(), ReversePolishCalculator.class);
  }

  /**
   * Test that evaluate currently returns 0f when the expression is null.
   */
  @Test
  void testEvaluateOne() {
    float result = assertDoesNotThrow(() -> calculator.evaluate(null));
    assertEquals(result, 0f);
  }

  /**
   * Test that a valid expression does not throw and returns a correct answer.
   */
  @Test
  void testEvaluateTwo() {
    String expression = "1 2 +";
    float result = assertDoesNotThrow(() -> calculator.evaluate(expression));
    assertEquals(3f, result);
  }

  /**
   * Test that a valid expression does not throw and returns a correct answer. This expression has
   * multiple operations involved.
   */
  @Test
  void testEvaluateThree() {
    String expression = "1 2 3 + +";
    float result = assertDoesNotThrow(() -> calculator.evaluate(expression));
    assertEquals(6f, result);
  }

  /**
   * Test that a valid expression does not throw and returns a correct answer. This expression has
   * multiple operations involved and operators involved.
   */
  @Test
  void testEvaluateFour() {
    String expression = "1 2 3 + *";
    float result = assertDoesNotThrow(() -> calculator.evaluate(expression));
    assertEquals(5f, result);
  }

  /**
   * Test that a valid expression does not throw and returns a correct answer. This expression has
   * multiple separated operations involved.
   */
  @Test
  void testEvaluateFive() {
    String expression = "1 2 + 3 *";
    float result = assertDoesNotThrow(() -> calculator.evaluate(expression));
    assertEquals(9f, result);
  }

  /**
   * Test that a valid expression does not throw and returns a correct answer. This expression has
   * is a bit more complex with 3 operators.
   */
  @Test
  void testEvaluateSix() {
    String expression = "1 2 3 + + 4 *";
    float result = assertDoesNotThrow(() -> calculator.evaluate(expression));
    assertEquals(24f, result);
  }

  /**
   * Test that a valid expression does not throw and returns a correct answer. This expression has
   * is a bit more complex with 3 different operators.
   */
  @Test
  void testEvaluateSeven() {
    String expression = "1 1 1 + + 3 /";
    float result = assertDoesNotThrow(() -> calculator.evaluate(expression));
    assertEquals(1f, result);
  }

  /**
   * Test that a valid expression does not throw and returns a correct answer. This expression has
   * is a bit more complex with 4 different operators.
   */
  @Test
  void testEvaluateEight() {
    String expression = "1 1 1 + + 3 / 1 -";
    float result = assertDoesNotThrow(() -> calculator.evaluate(expression));
    assertEquals(0f, result);
  }

  /**
   * Test that a valid expression does not throw and returns a correct answer. This expression is
   * quite complicated using a large amount of value and operators.
   */
  @Test
  void testEvaluateNine() {
    String expression = "2 3 * 4 5 * + 6 7 * - 8 /";
    float result = assertDoesNotThrow(() -> calculator.evaluate(expression));
    assertEquals(-2f, result);
  }

  /**
   * Test that an invalid expression that is using an incorrect symbol for reverse polish notation
   * throws an InvalidExpression.
   */
  @Test
  void testEvaluateTen() {
    String expression = "1 1 1 ) + + 3 / 1 -";
    Exception exception =
        assertThrows(InvalidExpression.class, () -> calculator.evaluate(expression));
    assertEquals(InvalidExpression.class, exception.getClass());
  }

  /**
   * Test that an invalid expression that is using too many operators for the given arguments throws
   * an EmptyStackException.
   */
  @Test
  void testEvaluateEleven() {
    String expression = "1 1 1 + + 3 / 1 - -";
    Exception exception =
        assertThrows(EmptyStackException.class, () -> calculator.evaluate(expression));
    assertEquals(EmptyStackException.class, exception.getClass());
  }

}

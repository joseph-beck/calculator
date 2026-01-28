package uk.ac.rhul.cs2800.cw2.calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.cw2.exception.InvalidExpression;

/**
 * Test the StandardCalculator, this is done by giving a variety of different expressions, some
 * designed to throw errors, others to stress the algorithm.
 *
 * @author Joseph Beck
 */
class StandardCalculatorTest {

  /**
   * Test that an instance of the StandardCalculator can be created and that the class is of the
   * correct type.
   */
  @Test
  void testStandardCalculator() {
    StandardCalculator calculator = new StandardCalculator();
    assertNotNull(calculator);
    assertEquals(calculator.getClass(), StandardCalculator.class);
  }

  /**
   * Test that evaluate currently returns 0f when ran for now.
   */
  @Test
  void testEvaluateOne() {
    StandardCalculator calculator = new StandardCalculator();
    float result = assertDoesNotThrow(() -> calculator.evaluate(null));
    assertEquals(0f, result);
  }

  /**
   * Test that evaluate can add a very simple expression.
   */
  @Test
  void testEvaluateTwo() {
    StandardCalculator calculator = new StandardCalculator();
    float result = assertDoesNotThrow(() -> calculator.evaluate("1 + 2"));
    assertEquals(3f, result);
  }

  /**
   * Test that evaluate can add an expression with multiple numbers.
   */
  @Test
  void testEvaluateThree() {
    StandardCalculator calculator = new StandardCalculator();
    float result = assertDoesNotThrow(() -> calculator.evaluate("1 + 2 + 3"));
    assertEquals(6f, result);
  }

  /**
   * Test that evaluate can add and subtract with multiple numbers.
   */
  @Test
  void testEvaluateFour() {
    StandardCalculator calculator = new StandardCalculator();
    float result = assertDoesNotThrow(() -> calculator.evaluate("1 + 2 - 3"));
    assertEquals(0f, result);
  }

  /**
   * Test that evaluate can add, subtract, multiply and divide with multiple numbers.
   */
  @Test
  void testEvaluateFive() {
    StandardCalculator calculator = new StandardCalculator();
    float result = assertDoesNotThrow(() -> calculator.evaluate("1 + 2 - 2 * 5 / 5"));
    assertEquals(1f, result);
  }

  /**
   * Test that evaluate can calculate an expression containing brackets.
   */
  @Test
  void testEvaluateSix() {
    StandardCalculator calculator = new StandardCalculator();
    float result = assertDoesNotThrow(() -> calculator.evaluate("1 + (2 - 2) * (5 / 5)"));
    assertEquals(1f, result);
  }

  /**
   * Test that evaluate can calculate a more complex expression containing brackets.
   */
  @Test
  void testEvaluateSeven() {
    StandardCalculator calculator = new StandardCalculator();
    float result =
        assertDoesNotThrow(() -> calculator.evaluate("1 + (2 - (7 + 12) - 5) * ((5 * 5) / 5)"));
    assertEquals(-109f, result);
  }

  /**
   * Test that evaluate throws an exception when given an incorrect expression.
   */
  @Test
  void testEvaluateEigth() {
    StandardCalculator calculator = new StandardCalculator();
    Exception exception =
        assertThrows(InvalidExpression.class, () -> calculator.evaluate("((() 123"));
    assertEquals(InvalidExpression.class, exception.getClass());
  }
  
}

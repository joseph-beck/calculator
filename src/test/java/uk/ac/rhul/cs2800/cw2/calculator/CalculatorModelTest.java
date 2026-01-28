package uk.ac.rhul.cs2800.cw2.calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

/**
 * Test the calculator model with a variety of expressions that should give an error, give a
 * different output or an answer.
 * 
 * @author Joseph Beck
 */
class CalculatorModelTest {

  /**
   * Store the instance of CalculatorModel being tested against.
   */
  private CalculatorModel model;

  /**
   * 
   * @throws Exception
   */
  @BeforeEach
  void setUp() throws Exception {
    model = new CalculatorModel();
  }

  @Test
  void testCalculatorModel() {
    model = new CalculatorModel();
    assertNotNull(model);
    assertEquals(model.getClass(), CalculatorModel.class);
  }

  /**
   * Test a simple expression using RPN. Ensure it does not throw an exception.
   */
  @Test
  void testEvaluateOne() {
    float result = assertDoesNotThrow(() -> model.evaluate("2 1 +", false));
    assertEquals(3f, result);
  }

  /**
   * Test a simple expression using Infix Notation. Ensure it does not throw an exception.
   */
  @Test
  void testEvaluateTwo() {
    float result = assertDoesNotThrow(() -> model.evaluate("2 + 1", true));
    assertEquals(3f, result);
  }

  /**
   * Test a simple expression using RPN. Ensure it does throw an exception.
   */
  @Test
  void testEvaluateThree() {
    Exception exception =
        assertThrows(EmptyStackException.class, () -> model.evaluate("2 1 + + +", false));
    assertEquals(EmptyStackException.class, exception.getClass());
  }

  /**
   * Test a simple expression using Infix Notation. Ensure it does throw an exception.
   */
  @Test
  void testEvaluateFour() {
    Exception exception =
        assertThrows(EmptyStackException.class, () -> model.evaluate("2 + 1 ())", true));
    assertEquals(EmptyStackException.class, exception.getClass());
  }
}

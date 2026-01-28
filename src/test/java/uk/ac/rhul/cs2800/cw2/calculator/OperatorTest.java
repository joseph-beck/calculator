package uk.ac.rhul.cs2800.cw2.calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.cw2.data.Symbol;
import uk.ac.rhul.cs2800.cw2.exception.InvalidExpression;

/**
 * Test the Operator class which is used for carrying out Operations within the Calculators.
 * 
 * @author Joseph Beck
 */
class OperatorTest {

  /*
   * Test that an instance of Operator can be created.
   */
  @Test
  void testOperator() {
    Operator operator = new Operator();
    assertNotNull(operator);
    assertEquals(operator.getClass(), Operator.class);
  }

  /**
   * Test that operate can do an addition operation.
   */
  @Test
  void testOperateOne() {
    float result = assertDoesNotThrow(() -> Operator.operate(1f, 2f, Symbol.PLUS));
    assertEquals(result, 3f);
  }

  /**
   * Test that operate can do a subtraction operation.
   */
  @Test
  void testOperateTwo() {
    float result = assertDoesNotThrow(() -> Operator.operate(1f, 2f, Symbol.MINUS));
    assertEquals(result, -1f);
  }

  /**
   * Test that operate can do a multiplication operation.
   */
  @Test
  void testOperateThree() {
    float result = assertDoesNotThrow(() -> Operator.operate(1f, 2f, Symbol.TIMES));
    assertEquals(result, 2f);
  }

  /**
   * Test that operate can do a division operation.
   */
  @Test
  void testOperateFour() {
    float result = assertDoesNotThrow(() -> Operator.operate(1f, 2f, Symbol.DIVIDE));
    assertEquals(result, 0.5f);
  }

  /**
   * Test that operate throws an InvalidExpression when given the wrong type of Symbol.
   */
  @Test
  void testOperateFive() {
    Exception exception =
        assertThrows(InvalidExpression.class, () -> Operator.operate(1f, 1f, Symbol.INVALID));
    assertEquals(InvalidExpression.class, exception.getClass());
  }

}

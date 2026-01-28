package uk.ac.rhul.cs2800.cw2.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Test the functionality of the enum OperationType.
 * 
 * @author Joseph Beck
 */
class OperationTypeTest {

  /**
   * Test that STANDARD correctly goes to a string.
   */
  @Test
  void testStandard() {
    OperationType type = OperationType.STANDARD;
    assertEquals(type.toString(), "Standard");
  }

  /**
   * Test that REVERSE_POLISH correctly goes to a string.
   */
  @Test
  void testReversePolish() {
    OperationType type = OperationType.REVERSE_POLISH;
    assertEquals(type.toString(), "Reverse Polish");
  }

}

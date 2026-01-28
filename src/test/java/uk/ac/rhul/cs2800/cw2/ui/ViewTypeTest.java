package uk.ac.rhul.cs2800.cw2.ui;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Test the the ViewType enum correctly converts to and from string values.
 *
 * @author Joseph Beck
 */
class ViewTypeTest {

  /**
   * Test that the CALCULATOR ViewType converts to the correct String.
   */
  @Test
  void testCalculatorOne() {
    ViewType viewType = ViewType.CALCULATOR;
    assertEquals(viewType.toString(), "Calculator");
  }

  /**
   * Test that the CALCULATOR ViewType converts from the correct String.
   */
  @Test
  void testCalculatorTwo() {
    ViewType viewType = ViewType.fromString("Calculator");
    assertEquals(ViewType.CALCULATOR, viewType);
  }

  /**
   * Test that the ASCII ViewType converts to the correct String.
   */
  @Test
  void testAsciiOne() {
    ViewType viewType = ViewType.ASCII;
    assertEquals(viewType.toString(), "Ascii");
  }

  /**
   * Test that the CALCULATOR ViewType converts from the correct String.
   */
  @Test
  void testAsciiTwo() {
    ViewType viewType = ViewType.fromString("Ascii");
    assertEquals(ViewType.ASCII, viewType);
  }

  /**
   * Test that the INVALID ViewType converts to the correct String.
   */
  @Test
  void testInvalidOne() {
    ViewType viewType = ViewType.INVALID;
    assertEquals(viewType.toString(), "Invalid");
  }

  /**
   * Test that the CALCULATOR ViewType converts from the correct String.
   */
  @Test
  void testInvalidTwo() {
    ViewType viewType = ViewType.fromString("Invalid");
    assertEquals(ViewType.INVALID, viewType);
  }

}

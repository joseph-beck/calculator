package uk.ac.rhul.cs2800.cw2.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Test the functionality of the enum Symbol.
 *
 * @author Joseph Beck
 */
class SymbolTest {

  /**
   * Test that LEFT_BRACKET correctly goes to a string.
   */
  @Test
  public void testLeftBracket() {
    Symbol symbol = Symbol.LEFT_BRACKET;
    assertEquals(symbol.toString(), "Left Bracket");
  }

  /**
   * Test that RIGHT_BRACKET correctly goes to a string.
   */
  @Test
  public void testRightBracket() {
    Symbol symbol = Symbol.RIGHT_BRACKET;
    assertEquals(symbol.toString(), "Right Bracket");
  }

  /**
   * Test that TIMES correctly goes to a string.
   */
  @Test
  public void testTimes() {
    Symbol symbol = Symbol.TIMES;
    assertEquals(symbol.toString(), "Times");
  }

  /**
   * Test that DIVIDE correctly goes to a string.
   */
  @Test
  public void testDivide() {
    Symbol symbol = Symbol.DIVIDE;
    assertEquals(symbol.toString(), "Divide");
  }

  /**
   * Test that SYMBOL correctly goes to a string.
   */
  @Test
  public void testPlus() {
    Symbol symbol = Symbol.PLUS;
    assertEquals(symbol.toString(), "Plus");
  }

  /**
   * Test that MINUS correctly goes to a string.
   */
  @Test
  public void testMinus() {
    Symbol symbol = Symbol.MINUS;
    assertEquals(symbol.toString(), "Minus");
  }

  /**
   * Test that INVALID correctly goes to a string.
   */
  @Test
  public void testInvalid() {
    Symbol symbol = Symbol.INVALID;
    assertEquals(symbol.toString(), "Invalid");
  }

}

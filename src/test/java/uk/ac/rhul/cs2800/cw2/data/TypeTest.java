package uk.ac.rhul.cs2800.cw2.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Test the functionality of the enum Type.
 *
 * @author Joseph Beck
 */
class TypeTest {

  /**
   * Test that SYMBOL correctly goes to a string.
   */
  @Test
  public void testSymbol() {
    Type type = Type.SYMBOL;
    assertEquals(type.toString(), "Symbol");
  }

  /**
   * Test that NUMBER correctly goes to a string.
   */
  @Test
  public void testNumber() {
    Type type = Type.NUMBER;
    assertEquals(type.toString(), "Number");
  }

  /**
   * Test that STRING correctly goes to a string.
   */
  @Test
  public void testString() {
    Type type = Type.STRING;
    assertEquals(type.toString(), "String");
  }

  /**
   * Test that INVALID correctly goes to a string.
   */
  @Test
  public void testInvalid() {
    Type type = Type.INVALID;
    assertEquals(type.toString(), "Invalid");
  }

}

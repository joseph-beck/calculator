package uk.ac.rhul.cs2800.cw2.data;

import uk.ac.rhul.cs2800.cw2.exception.BadTypeException;
import uk.ac.rhul.cs2800.cw2.stack.Stack;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Tests all of the methods of the Entry class.
 *
 * @author Joseph Beck
 */
class EntryTest {

  /**
   * First test for Entry, assert that an instance of Entry can be created.
   */
  @Test
  public void testEntry() {
    Entry entry = new Entry();
    assertTrue(entry instanceof Entry);
  }

  /**
   * First instance of equals can only compare Symbols, assert that two of the same Symbols return
   * true and two different return false.
   */
  @Test
  public void testEqualsOne() {
    // Comparing two Entries of the same Type.
    Entry one = new Entry(Symbol.DIVIDE);
    Entry two = new Entry(Symbol.DIVIDE);
    assertTrue(one.equals(two));

    one = new Entry(Symbol.DIVIDE);
    two = new Entry(Symbol.MINUS);
    assertFalse(one.equals(two));
  }

  /**
   * Equals is now able to compare various Types, it is asserted that two different Types are not
   * equal to each other. This is tested for all 3 valid Types.
   */
  @Test
  public void testEqualsTwo() {
    // Comparing two Entries of different type.
    Entry one = new Entry("Test Three");
    Entry two = new Entry(Symbol.MINUS);
    assertFalse(one.equals(two));

    one = new Entry(123);
    two = new Entry(Symbol.MINUS);
    assertFalse(one.equals(two));
  }

  /**
   * This test of equals is for testing all possible branches that might occur when it is called.
   */
  @Test
  public void testEqualsThree() {
    // Comparing different strings.
    Entry one = new Entry("Test Three");
    Entry two = new Entry("Test Twenty");
    assertFalse(one.equals(two));

    // Comparing different integers.
    one = new Entry(123);
    two = new Entry(456);
    assertFalse(one.equals(two));

    // Comparing the same integers.
    one = new Entry(123);
    two = new Entry(123);
    assertTrue(one.equals(two));

    // Comparing an empty Entry with an integer.
    one = new Entry();
    two = new Entry(123);
    assertFalse(one.equals(two));
  }

  /**
   * Testing the scenario in which equals is used to compare an Entry with something that is not an
   * Entry. Asserts that they are not equal.
   */
  @SuppressWarnings("unlikely-arg-type")
  @Test
  public void testEqualsFour() {
    // Comparing two different objects.
    Entry one = new Entry(Symbol.MINUS);
    Stack stack = new Stack();
    assertFalse(one.equals(stack));
  }

  /**
   * HashCode can only compute the hash code of a Symbol at the moment. This asserts that two
   * Entries with the same symbol have the same hash code while two different symbols have differing
   * hash codes.
   */
  @Test
  public void testHashCodeOne() {
    // Create different Entries for comparison.
    Entry divideEntry = new Entry(Symbol.DIVIDE);
    Entry divideEntryOther = new Entry(Symbol.DIVIDE);
    Entry minusEntry = new Entry(Symbol.MINUS);

    assertEquals(divideEntry.hashCode(), divideEntryOther.hashCode());
    assertNotEquals(divideEntry.hashCode(), minusEntry.hashCode());
  }

  /**
   * HashCode can now compute hash codes for differing types. This tests all possible branches that
   * the hashCode may have to compute.
   */
  @Test
  public void testHashCodeTwo() {
    Entry one = new Entry(Symbol.DIVIDE);
    Entry two = new Entry(Symbol.DIVIDE);
    assertEquals(one.hashCode(), two.hashCode());

    one = new Entry("Test");
    two = new Entry(Symbol.MINUS);
    assertNotEquals(one.hashCode(), two.hashCode());

    one = new Entry(123);
    two = new Entry("Test");
    assertNotEquals(one.hashCode(), two.hashCode());

    one = new Entry();
    two = new Entry(123);
    assertNotEquals(one.hashCode(), two.hashCode());
  }

  /**
   * ToString first can convert a Symbol to a String using the enum's toString method.
   */
  @Test
  public void testToStringOne() {
    Entry one = new Entry(Symbol.MINUS);
    assertEquals(one.toString(), "Minus");
  }

  /**
   * Extend toString to be able to convert a float to a string, this is only up to 2d.p.
   */
  @Test
  public void testToStringTwo() {
    Entry one = new Entry(123.45f);
    assertEquals(one.toString(), "123.45");
  }

  /**
   * Finally toString returns the string instance of its variable if it is of Type STRING.
   */
  @Test
  public void testToStringThree() {
    Entry one = new Entry("String");
    assertEquals(one.toString(), "String");
  }

  /**
   * Tests the branch in which the Entry is null.
   */
  @Test
  public void testToStringFour() {
    Entry one = new Entry();
    assertEquals(one.toString(), null);
  }

  /**
   * Testing the getSymbol and asserting that is does not throw an exception when it is of Type
   * SYMBOL.
   */
  @Test
  public void testGetSymbolOne() {
    Entry symbol = new Entry(Symbol.DIVIDE);
    assertDoesNotThrow(() -> symbol.getSymbol());
  }

  /**
   * Asserts that a BadTypeException is thrown when a Entry of Type STRING calls getSymbol.
   */
  @Test
  public void testGetSymbolTwo() {
    Entry symbol = new Entry("Symbol");
    Exception exception = assertThrows(BadTypeException.class, () -> symbol.getSymbol());
    assertEquals(BadTypeException.class, exception.getClass());
  }

  /**
   * Testing the getNumber and asserting that is does not throw an exception when it is of Type
   * NUMBER.
   */
  @Test
  public void testGetNumberOne() {
    Entry number = new Entry(123);
    assertDoesNotThrow(() -> number.getNumber());
  }

  /**
   * Asserts that a BadTypeException is thrown when a Entry of Type STRING calls getNumber.
   */
  @Test
  public void testGetNumberTwo() {
    Entry number = new Entry("Symbol");
    Exception exception = assertThrows(BadTypeException.class, () -> number.getNumber());
    assertEquals(BadTypeException.class, exception.getClass());
  }

  /**
   * Testing the getString and asserting that is does not throw an exception when it is of Type
   * STRING.
   */
  @Test
  public void testGetStringOne() {
    Entry string = new Entry("Entry");
    assertDoesNotThrow(() -> string.getString());
  }

  /**
   * Asserts that a BadTypeException is thrown when a Entry of Type NUMBER calls getString.
   */
  @Test
  public void testGetStringTwo() {
    Entry string = new Entry(123);
    Exception exception = assertThrows(BadTypeException.class, () -> string.getString());
    assertEquals(BadTypeException.class, exception.getClass());
  }

  /**
   * Testing the getType method and asserting that is returns the correct Type.
   */
  @Test
  public void testGetType() {
    Entry string = new Entry("Entry");
    assertEquals(string.getType(), Type.STRING);
    assertNotEquals(string.getType(), Type.NUMBER);
  }

}

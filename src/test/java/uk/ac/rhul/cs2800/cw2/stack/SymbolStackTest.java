package uk.ac.rhul.cs2800.cw2.stack;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.cw2.data.Symbol;

/**
 * Testing the functionality of the SymbolStack.
 * 
 * @author Joseph Beck
 */
class SymbolStackTest {

  /**
   * SymbolStack being tested against.
   */
  private SymbolStack stack;

  @BeforeEach
  void setUp() throws Exception {
    // Create instance of Stack.
    stack = new SymbolStack();
    stack.push(Symbol.DIVIDE);
    stack.push(Symbol.MINUS);
    stack.push(Symbol.PLUS);
  }

  /**
   * Test that an instance of the SymbolStack can be created by creating a new SymbolStack and
   * asserting that it is not null.
   */
  @Test
  void testSymbolStack() {
    stack = new SymbolStack();
    assertNotNull(stack);
    assertEquals(stack.getClass(), SymbolStack.class);
  }

  /**
   * Test the size function of SymbolStack when it is empty.
   */
  @Test
  void testSizeOne() {
    stack = new SymbolStack();
    assertEquals(stack.size(), 0);
  }

  /**
   * Test the size function of SymbolStack using the default Stack created before each test is ran,
   * this should have a size of 3.
   */
  @Test
  void testSizeTwo() {
    assertEquals(stack.size(), 3);
  }

  /**
   * Test the push method by pushing a new item onto the Stack. This should increase the size by 1.
   */
  @Test
  void testPushOne() {
    stack = new SymbolStack();
    assertEquals(stack.size(), 0);
    
    stack.push(Symbol.PLUS);
    assertEquals(stack.size(), 1);
  }

  /**
   * Test the push and size method of the SymbolStack, this is done by adding a random amount of
   * items to the Stack.
   */
  @Test
  void testPushAndSize() {
    stack = new SymbolStack();
    Random random = new Random();
    int pushAmount = random.nextInt(500);

    for (int i = 0; i < pushAmount; i++) {
      stack.push(Symbol.PLUS);
      assertEquals(stack.size(), i + 1);
    }
    assertEquals(stack.size(), pushAmount);
  }

  /**
   * Test that pop returns the most recently added item to the Stack and assert that the size has
   * decreased.
   */
  @Test
  void testPopOne() {
    Symbol symbol = stack.pop();
    assertEquals(symbol, Symbol.PLUS);
    assertEquals(stack.size(), 2);
  }

  /**
   * Test the pop method by pushing a random amount of items onto the Stack and then popping off a
   * random amount. Asserting that the size is correct and that items coming off the stack are
   * correct.
   */
  @Test
  void testPopTwo() {
    // Create new instance of SymbolStack so that it is empty.
    stack = new SymbolStack();
    Random random = new Random();

    int pushAmount = random.nextInt(500);
    for (int i = 0; i < pushAmount; i++) {
      stack.push(Symbol.PLUS);
    }
    assertEquals(stack.size(), pushAmount);

    int popAmount = random.nextInt(stack.size());
    for (int i = 0; i < popAmount; i++) {
      Symbol symbol = stack.pop();
      assertTrue(symbol.equals(Symbol.PLUS));
    }
    assertEquals(stack.size(), pushAmount - popAmount);
  }

  /**
   * Test that the order that items are popped is correct using the default Stack created in setUp.
   */
  @Test
  void testPopThree() {
    Symbol symbol = stack.pop();
    assertTrue(symbol.equals(Symbol.PLUS));

    symbol = stack.pop();
    assertTrue(symbol.equals(Symbol.MINUS));

    symbol = stack.pop();
    assertTrue(symbol.equals(Symbol.DIVIDE));

    assertEquals(stack.size(), 0);
  }

  /**
   * Test that an empty Stack correctly throws the EmptyStackException when the pop method is called.
   */
  @Test
  void testPopFour() {
    stack = new SymbolStack();
    assertEquals(stack.size(), 0);
    Exception exception = assertThrows(EmptyStackException.class, () -> stack.pop());
    assertEquals(EmptyStackException.class, exception.getClass());
  }

  /**
   * Test that top does not affect the size of the Stack but returns the top element.
   */
  @Test
  void testTopOne() {
    assertEquals(stack.size(), 3);
    Symbol symbol = stack.top();
    assertEquals(stack.size(), 3);
    assertTrue(symbol.equals(Symbol.PLUS));
  }

  /**
   * Test the top method by randomly pushing an amount of items and then using the top method a
   * random number of times, asserting that the size does not change.
   */
  @Test
  void testTopTwo() {
    // Create a new instance of SymbolStack so that it is empty.
    stack = new SymbolStack();
    Random random = new Random();

    int pushAmount = random.nextInt(500);
    for (int i = 0; i < pushAmount; i++) {
      stack.push(Symbol.PLUS);
    }
    assertEquals(stack.size(), pushAmount);

    int topAmount = random.nextInt(pushAmount);
    for (int i = 0; i < topAmount; i++) {
      Symbol symbol = stack.top();
      assertTrue(symbol.equals(Symbol.PLUS));
    }
    assertEquals(stack.size(), pushAmount);
  }

  /**
   * Test that an empty stack correctly throws the EmptyStackException when the top method is called.
   */
  @Test
  void testTopThree() {
    // Create a new instance of SymbolStack so that it is empty.
    stack = new SymbolStack();
    assertEquals(stack.size(), 0);
    Exception exception = assertThrows(EmptyStackException.class, () -> stack.top());
    assertEquals(EmptyStackException.class, exception.getClass());
  }

}

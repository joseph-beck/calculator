package uk.ac.rhul.cs2800.cw2.stack;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing the functionality of the StringStack.
 * 
 * @author Joseph Beck
 */
class StringStackTest {

  /**
   * StringStack being tested against.
   */
  private StringStack stack;

  @BeforeEach
  void setUp() throws Exception {
    // Create instance of Stack.
    stack = new StringStack();
    stack.push("Hello");
    stack.push("World");
    stack.push("!");
  }

  /**
   * Test that an instance of the StringStack can be created by creating a new StringStack and
   * asserting that it is not null.
   */
  @Test
  void testStringStack() {
    stack = new StringStack();
    assertNotNull(stack);
    assertEquals(stack.getClass(), StringStack.class);
  }

  /**
   * Test the size function of StringStack when it is empty.
   */
  @Test
  void testSizeOne() {
    stack = new StringStack();
    assertEquals(stack.size(), 0);
  }

  /**
   * Test the size function of StringStack using the default Stack created before each test is ran,
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
    stack = new StringStack();
    assertEquals(stack.size(), 0);
    
    stack.push("push");
    assertEquals(stack.size(), 1);
  }

  /**
   * Test the push and size method of the StringStack, this is done by adding a random amount of
   * items to the Stack.
   */
  @Test
  void testPushAndSize() {
    stack = new StringStack();
    Random random = new Random();
    int pushAmount = random.nextInt(500);

    for (int i = 0; i < pushAmount; i++) {
      stack.push("item");
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
    String string = stack.pop();
    assertEquals(string, "!");
    assertEquals(stack.size(), 2);
  }

  /**
   * Test the pop method by pushing a random amount of items onto the Stack and then popping off a
   * random amount. Asserting that the size is correct and that items coming off the stack are
   * correct.
   */
  @Test
  void testPopTwo() {
    // Create new instance of StringStack so that it is empty.
    stack = new StringStack();
    Random random = new Random();

    int pushAmount = random.nextInt(500);
    for (int i = 0; i < pushAmount; i++) {
      stack.push("item");
    }
    assertEquals(stack.size(), pushAmount);

    int popAmount = random.nextInt(stack.size());
    for (int i = 0; i < popAmount; i++) {
      String item = stack.pop();
      assertTrue(item.equals("item"));
    }
    assertEquals(stack.size(), pushAmount - popAmount);
  }

  /**
   * Test that the order that items are popped is correct using the default Stack created in setUp.
   */
  @Test
  void testPopThree() {
    String item = stack.pop();
    assertTrue(item.equals("!"));

    item = stack.pop();
    assertTrue(item.equals("World"));

    item = stack.pop();
    assertTrue(item.equals("Hello"));

    assertEquals(stack.size(), 0);
  }

  /**
   * Test that an empty Stack correctly throws the EmptyStackException when the pop method is called.
   */
  @Test
  void testPopFour() {
    stack = new StringStack();
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
    String top = stack.top();
    assertEquals(stack.size(), 3);
    assertTrue(top.equals("!"));
  }

  /**
   * Test the top method by randomly pushing an amount of items and then using the top method a
   * random number of times, asserting that the size does not change.
   */
  @Test
  void testTopTwo() {
    // Create a new instance of StringStack so that it is empty.
    stack = new StringStack();
    Random random = new Random();

    int pushAmount = random.nextInt(500);
    for (int i = 0; i < pushAmount; i++) {
      stack.push("item");
    }
    assertEquals(stack.size(), pushAmount);

    int topAmount = random.nextInt(pushAmount);
    for (int i = 0; i < topAmount; i++) {
      String top = stack.top();
      assertTrue(top.equals("item"));
    }
    assertEquals(stack.size(), pushAmount);
  }

  /**
   * Test that an empty stack correctly throws the EmptyStackException when the top method is called.
   */
  @Test
  void testTopThree() {
    // Create a new instance of StringStack so that it is empty.
    stack = new StringStack();
    assertEquals(stack.size(), 0);
    Exception exception = assertThrows(EmptyStackException.class, () -> stack.top());
    assertEquals(EmptyStackException.class, exception.getClass());
  }

}

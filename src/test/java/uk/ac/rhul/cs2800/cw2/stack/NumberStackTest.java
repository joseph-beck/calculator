package uk.ac.rhul.cs2800.cw2.stack;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing the methods and their functionality of the NumberStack.
 * 
 * @author Joseph Beck
 */
class NumberStackTest {

  /**
   * NumberStack being tested against.
   */
  private NumberStack stack;

  @BeforeEach
  void setUp() throws Exception {
    // Create instance of Stack.
    stack = new NumberStack();
    stack.push(1f);
    stack.push(2f);
    stack.push(3f);
  }

  /**
   * Test that an instance of the NumberStack can be created by creating a new NumberStack and
   * asserting that it is not null.
   */
  @Test
  void testNumberStack() {
    stack = new NumberStack();
    assertNotNull(stack);
    assertEquals(stack.getClass(), NumberStack.class);
  }

  /**
   * Test the size function of NumberStack when it is empty.
   */
  @Test
  void testSizeOne() {
    stack = new NumberStack();
    assertEquals(stack.size(), 0);
  }

  /**
   * Test the size function of NumberStack using the default Stack created before each test is ran,
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
    stack = new NumberStack();
    assertEquals(stack.size(), 0);
    
    stack.push(1f);
    assertEquals(stack.size(), 1);
  }

  /**
   * Test the push and size method of the NumberStack, this is done by adding a random amount of
   * items to the Stack.
   */
  @Test
  void testPushAndSize() {
    stack = new NumberStack();
    Random random = new Random();
    int pushAmount = random.nextInt(500);

    for (int i = 0; i < pushAmount; i++) {
      stack.push(1f);
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
    Float number = stack.pop();
    assertEquals(number, 3f);
    assertEquals(stack.size(), 2);
  }

  /**
   * Test the pop method by pushing a random amount of items onto the Stack and then popping off a
   * random amount. Asserting that the size is correct and that items coming off the stack are
   * correct.
   */
  @Test
  void testPopTwo() {
    // Create new instance of NumberStack so that it is empty.
    stack = new NumberStack();
    Random random = new Random();

    int pushAmount = random.nextInt(500);
    for (int i = 0; i < pushAmount; i++) {
      stack.push(1f);
    }
    assertEquals(stack.size(), pushAmount);

    int popAmount = random.nextInt(stack.size());
    for (int i = 0; i < popAmount; i++) {
      Float number = stack.pop();
      assertEquals(number, 1f);
    }
    assertEquals(stack.size(), pushAmount - popAmount);
  }

  /**
   * Test that the order that items are popped is correct using the default Stack created in setUp.
   */
  @Test
  void testPopThree() {
    Float number = stack.pop();
    assertEquals(number, 3f);

    number = stack.pop();
    assertEquals(number, 2f);

    number = stack.pop();
    assertEquals(number, 1f);

    assertEquals(stack.size(), 0);
  }

  /**
   * Test that an empty Stack correctly throws the EmptyStackException when the pop method is called.
   */
  @Test
  void testPopFour() {
    stack = new NumberStack();
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
    Float number = stack.top();
    assertEquals(number, 3f);
    assertEquals(stack.size(), 3);
  }

  /**
   * Test the top method by randomly pushing an amount of items and then using the top method a
   * random number of times, asserting that the size does not change.
   */
  @Test
  void testTopTwo() {
    // Create a new instance of NumberStack so that it is empty.
    stack = new NumberStack();
    Random random = new Random();

    int pushAmount = random.nextInt(500);
    for (int i = 0; i < pushAmount; i++) {
      stack.push(1f);
    }
    assertEquals(stack.size(), pushAmount);

    int topAmount = random.nextInt(pushAmount);
    for (int i = 0; i < topAmount; i++) {
      Float top = stack.top();
      assertEquals(top, 1f);
    }
    assertEquals(stack.size(), pushAmount);
  }

  /**
   * Test that an empty Stack correctly throws the EmptyStackException when the top method is called.
   */
  @Test
  void testTopThree() {
    // Create a new instance of NumberStack so that it is empty.
    stack = new NumberStack();
    assertEquals(stack.size(), 0);
    Exception exception = assertThrows(EmptyStackException.class, () -> stack.top());
    assertEquals(EmptyStackException.class, exception.getClass());
  }

}

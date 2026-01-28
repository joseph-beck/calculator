package uk.ac.rhul.cs2800.cw2.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.cw2.data.Entry;
import uk.ac.rhul.cs2800.cw2.data.Symbol;

/**
 * Tests all of the methods within the Stack class.
 *
 * @author Joseph Beck
 */
class StackTest {

  /**
   * Stack being tested against.
   */
  private Stack stack;

  /**
   * Create a Stack with 3 Entries on the Stack. All 3 Entries are of the SYMBOL Type.
   */
  @BeforeEach
  void setUp() throws Exception {
    // Create instance of Stack.
    stack = new Stack();

    // Push 3 new Entries onto the Stack.
    stack.push(new Entry(Symbol.DIVIDE));
    stack.push(new Entry(Symbol.PLUS));
    stack.push(new Entry(Symbol.MINUS));
  }

  /**
   * First test for Stack, assert that an instance of Entry can be created.
   */
  @Test
  public void testStack() {
    Stack stack = new Stack();
    assertTrue(stack instanceof Stack);
  }

  /**
   * First test for the size method of Stack. This is just testing whether an empty Stack correctly
   * returns a size of 0.
   */
  @Test
  public void testSizeOne() {
    // Set stack to a new instance of a Stack.
    stack = new Stack();
    // Assert size of the new Stack is 0 (empty).
    assertEquals(stack.size(), 0);
  }

  /**
   * Second test for the size method of Stack. This uses the default stack created in setUp, it
   * first ensures the stack size is 3, then another Entry is pushed on and asserted that it is size
   * 4.
   */
  @Test
  public void testSizeTwo() {
    // Assert size of setUp stack is 3 (default Entry amount).
    assertEquals(stack.size(), 3);

    stack.push(new Entry(Symbol.DIVIDE));
    assertEquals(stack.size(), 4);
  }

  /**
   * Test the push method of Stack. This pushes a new Entry onto the Stack and asserts the size has
   * increased to 1.
   */
  @Test
  public void testPush() {
    // Create new instance of Stack so that stack is empty, and assert that it is empty.
    stack = new Stack();
    assertEquals(stack.size(), 0);

    // Push new Entry onto the Stack and assert that the size is correct.
    Entry entry = new Entry(Symbol.TIMES);
    stack.push(entry);
    assertEquals(stack.size(), 1);
    assertTrue(entry.equals(new Entry(Symbol.TIMES)));
  }

  /**
   * Test the size and the push method. This generates a random amount of Entries for the stack and
   * asserts that the size is correct.
   */
  @Test
  public void testPushAndSize() {
    // Create new instance of Stack so that the stack is empty.
    stack = new Stack();
    Random random = new Random();

    // Generate random amount of entries and push onto stack.
    int pushAmount = random.nextInt(500);
    for (int i = 0; i < pushAmount; i++) {
      stack.push(new Entry(Symbol.MINUS));
    }
    assertEquals(stack.size(), pushAmount);
  }

  /**
   * Testing the pop method on a Stack that has the default 3 Entries within it. It first asserts
   * that the correct Entry was popped off the Stack and then asserts that the size has decreased
   * accordingly.
   */
  @Test
  public void testPopOne() {
    // Assert correct size.
    assertEquals(stack.size(), 3);

    // Pop Entry off of stack, assert it is the correct Entry.
    Entry pop = stack.pop();
    assertTrue(pop.equals(new Entry(Symbol.MINUS)));
    // Assert Stack size was affected by pop.
    assertEquals(stack.size(), 2);
  }

  /**
   * This tests the pop method of the Stack by randomly adding and popping an amount of Entries. It
   * asserts that the correct amount has been popped.
   */
  @Test
  public void testPopTwo() {
    // Create new instance of Stack so that the stack is empty.
    stack = new Stack();
    Random random = new Random();

    // Generate random amount of entries and push onto stack.
    int pushAmount = random.nextInt(500);
    for (int i = 0; i < pushAmount; i++) {
      stack.push(new Entry(Symbol.MINUS));
    }
    assertEquals(stack.size(), pushAmount);

    // Pop off a random amount of Entries, that is less than the size of Stack.
    int popAmount = random.nextInt(stack.size());
    for (int i = 0; i < popAmount; i++) {
      Entry entry = stack.pop();
      assertTrue(entry.equals(new Entry(Symbol.MINUS)));
    }
    assertEquals(stack.size(), pushAmount - popAmount);
  }

  /**
   * This test is used to ensure that the order that Entries are popped off the stack is correct. It
   * asserts that each pop is correct for the Stack created in setUp.
   */
  @Test
  public void testPopThree() {
    // Pop off all Entries in reverse of how they are put on.
    Entry entry = stack.pop();
    assertTrue(entry.equals(new Entry(Symbol.MINUS)));

    entry = stack.pop();
    assertTrue(entry.equals(new Entry(Symbol.PLUS)));

    entry = stack.pop();
    assertTrue(entry.equals(new Entry(Symbol.DIVIDE)));

    assertEquals(stack.size(), 0);
  }

  /**
   * The third pop test is used to test that an Empty stack will correctly throw an
   * EmptyStackException. It asserts that both the exception is thrown and that it is the correct
   * Exception.
   */
  @Test
  public void testPopFour() {
    // Set stack to a new instance of a Stack.
    stack = new Stack();
    // Assert there are no Entries in stack.
    assertEquals(stack.size(), 0);

    // Assert that EmptyStackException is thrown by using pop on empty Stack.
    Exception exception = assertThrows(EmptyStackException.class, () -> stack.pop());
    assertEquals(EmptyStackException.class, exception.getClass());
  }

  /**
   * First test for the top method of Stack, it first asserts that the default stack has a size of
   * free and that once the top method is used it is the correct Entry and that the size has not
   * changed.
   */
  @Test
  public void testTopOne() {
    // Assert correct size.
    assertEquals(stack.size(), 3);

    // Get the top of the Stack and assert that it is correct Entry.
    Entry top = stack.top();
    assertTrue(top.equals(new Entry(Symbol.MINUS)));
    assertEquals(stack.size(), 3);
  }

  /**
   * Randomly test that the top method never removes any Entries from the stack, this is done by
   * pushing and using top on a random amount of Entries from this stack.
   */
  @Test
  public void testTopTwo() {
    // Create new instance of Stack for stack so that it is empty.
    stack = new Stack();
    Random random = new Random();

    // Push a random amount of Entries on.
    int pushAmount = random.nextInt(500);
    for (int i = 0; i < pushAmount; i++) {
      stack.push(new Entry("entry"));
    }

    // Use top on a random amount of Entries.
    int topAmount = random.nextInt(pushAmount);
    for (int i = 0; i < topAmount; i++) {
      Entry entry = stack.top();
      assertTrue(entry.equals(new Entry("entry")));
    }

    assertEquals(stack.size(), pushAmount);
  }

  /**
   * This test is used to ensure that EmptyStackException is thrown when the top method is used on
   * an empty Stack. It is first asserted that the Stack is empty and then that the correct
   * Exception is thrown.
   */
  @Test
  public void testTopThree() {
    // Set stack to a new instance of a Stack.
    stack = new Stack();
    // Assert there are no Entries in stack.
    assertEquals(stack.size(), 0);

    // Assert that EmptyStackException is thrown by using top on empty Stack.
    Exception exception = assertThrows(EmptyStackException.class, () -> stack.top());
    assertEquals(EmptyStackException.class, exception.getClass());
  }

}

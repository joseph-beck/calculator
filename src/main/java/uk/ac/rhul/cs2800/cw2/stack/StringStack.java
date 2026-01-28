package uk.ac.rhul.cs2800.cw2.stack;

import java.util.EmptyStackException;
import uk.ac.rhul.cs2800.cw2.data.Entry;
import uk.ac.rhul.cs2800.cw2.exception.BadTypeException;

/**
 * StringStack, a facade of the Stack class that holds only the String type.
 *
 * @author Joseph Beck
 */
public class StringStack implements StackInterface<String> {

  /**
   * Stack storing the StringStack.
   */
  private Stack stack;

  /**
   * Constructor for the StringStack.
   */
  public StringStack() {
    this.stack = new Stack();
  }

  /**
   * StringStack size.
   *
   * @author Joseph Beck
   */
  @Override
  public int size() {
    return this.stack.size();
  }

  /**
   * StringStack push.
   *
   * @param item being pushed onto the StringStack.
   */
  @Override
  public void push(String item) {
    this.stack.push(new Entry(item));
  }

  /**
   * Gets the String that is at the top of the Stack, the top item is then removed from the Stack.
   *
   * @return top String of the Stack.
   * @throws EmptyStackException when the Stack size is 0.
   */
  @Override
  public String pop() throws EmptyStackException {
    Entry pop = this.stack.pop();

    try {
      return pop.getString();
    } catch (BadTypeException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Gets the String that is at the top of the Stack, this method does not alter the Stack.
   *
   * @return top String of the Stack.
   * @throws EmptyStackException when the Stack size is 0.
   */
  @Override
  public String top() throws EmptyStackException {
    Entry top = this.stack.top();

    try {
      return top.getString();
    } catch (BadTypeException e) {
      e.printStackTrace();
    }
    return null;
  }

}

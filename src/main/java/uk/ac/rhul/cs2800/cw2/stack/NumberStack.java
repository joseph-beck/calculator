package uk.ac.rhul.cs2800.cw2.stack;

import java.util.EmptyStackException;
import uk.ac.rhul.cs2800.cw2.data.Entry;
import uk.ac.rhul.cs2800.cw2.exception.BadTypeException;

/**
 * NumberStack, a facade of the Stack class that holds only the Float type.
 * 
 * @author Joseph Beck
 */
public class NumberStack implements StackInterface<Float> {

  /**
   * Stack storing the NumberStack.
   */
  private Stack stack;

  /**
   * Constructor for the NumberStack.
   */
  public NumberStack() {
    this.stack = new Stack();
  }

  /**
   * Size of the NumberStack.
   * 
   * @return size of the Stack, number of items on the Stack.
   */
  @Override
  public int size() {
    return this.stack.size();
  }

  /**
   * NumberStack push.
   * 
   * @param item being pushed onto the NumberStack.
   */
  @Override
  public void push(Float item) {
    this.stack.push(new Entry(item));
  }

  /**
   * NumberStack pop.
   * 
   * @return the item at the top of the Stack and then removes it.
   * @throws EmptyStackException when Stack size is 0.
   */
  @Override
  public Float pop() throws EmptyStackException {
    Entry pop = this.stack.pop();

    try {
      return pop.getNumber();
    } catch (BadTypeException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * NumberStack top.
   * 
   * @return the item at the top of the Stack.
   * @throws EmptyStackException when Stack size is 0.
   */
  @Override
  public Float top() throws EmptyStackException {
    Entry top = this.stack.top();

    try {
      return top.getNumber();
    } catch (BadTypeException e) {
      e.printStackTrace();
    }
    return null;
  }

}

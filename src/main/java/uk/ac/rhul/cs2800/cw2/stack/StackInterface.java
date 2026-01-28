package uk.ac.rhul.cs2800.cw2.stack;

import java.util.EmptyStackException;

/**
 * Interface for the Stack class, ensures that all objects implement the same methods for
 * consistency.
 * 
 * @author Joseph Beck
 */
public interface StackInterface<T> {

  /**
   * Returns the size of the Stack, if 0 is returned then the Stack is empty.
   * 
   * @return size of the stack, the amount of data that is on the stack.
   */
  public abstract int size();

  /**
   * Push a new value onto the Stack, this should increase the size by 1.
   * 
   * @param item to push onto the stack.
   */
  public abstract void push(T item);

  /**
   * Returns the top values of the stack while deleting the value that was just retrieved from the
   * Stack.
   * 
   * @return top item of the stack and delete the item.
   * @throws EmptyStackException when the stack size is 0.
   */
  public abstract T pop() throws EmptyStackException;

  /**
   * Returns the top value of the stack without altering any of the data of the Stack.
   * 
   * @return top item of the stack.
   * @throws EmptyStackException when the stack size is 0.
   */
  public abstract T top() throws EmptyStackException;

}

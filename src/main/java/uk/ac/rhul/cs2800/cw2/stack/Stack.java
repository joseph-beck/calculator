package uk.ac.rhul.cs2800.cw2.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import uk.ac.rhul.cs2800.cw2.data.Entry;

/**
 * The Stack class uses an ArrayList in order to store Entries in a dynamic data structure.
 *
 * @author Joseph Beck
 */
public class Stack implements StackInterface<Entry> {

  /**
   * Instance of ArrayList that is used to store objects of type Entry.
   */
  private ArrayList<Entry> entries;

  /**
   * Constructor for Stack, initialises instance of entries.
   */
  public Stack() {
    this.entries = new ArrayList<Entry>();
  }

  /**
   * Gets the amount of entries stored within this Stack.
   *
   * @return size of the Stack.
   */
  @Override
  public int size() {
    return this.entries.size();
  }

  /**
   * Push an Entry onto the Stack.
   *
   * @param entry to go onto the Stack.
   */
  @Override
  public void push(Entry entry) {
    this.entries.add(entry);
  }

  /**
   * Pops an Entry off of the Stack, removes the top Entry from the Stack and then returns it.
   *
   * @return top Entry of the Stack.
   * @throws EmptyStackException when the Stack size is 0.
   */
  @Override
  public Entry pop() throws EmptyStackException {
    int size = this.size();
    if (size <= 0) {
      throw new EmptyStackException();
    }

    Entry top = this.entries.get(size - 1);
    this.entries.remove(size - 1);
    return top;
  }

  /**
   * Gets the Entry that is at the top of the Stack, this method does not alter the Stack.
   *
   * @return top Entry of the Stack.
   * @throws EmptyStackException when the Stack size is 0.
   */
  @Override
  public Entry top() throws EmptyStackException {
    int size = this.size();
    if (size <= 0) {
      throw new EmptyStackException();
    }

    return this.entries.get(size - 1);
  }

}

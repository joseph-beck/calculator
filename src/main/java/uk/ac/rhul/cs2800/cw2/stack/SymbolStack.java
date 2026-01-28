package uk.ac.rhul.cs2800.cw2.stack;

import java.util.EmptyStackException;
import uk.ac.rhul.cs2800.cw2.data.Entry;
import uk.ac.rhul.cs2800.cw2.data.Symbol;
import uk.ac.rhul.cs2800.cw2.exception.BadTypeException;

/**
 * SymbolStack, a facade of the Stack class that holds only the Symbol type.
 * 
 * @author Joseph Beck
 */
public class SymbolStack implements StackInterface<Symbol> {

  /**
   * Stack storing the SymbolStack.
   */
  private Stack stack;

  public SymbolStack() {
    this.stack = new Stack();
  }

  /**
   * SymbolStack size.
   * 
   * @return size of the SymbolStack.
   */
  @Override
  public int size() {
    return this.stack.size();
  }

  /**
   * SymbolStack push.
   * 
   * @param item being pushed onto the SymbolStack.
   */
  @Override
  public void push(Symbol item) {
    this.stack.push(new Entry(item));
  }

  /**
   * SymbolStack pop.
   * 
   * @return item that the top of the Stack.
   * @throws EmptyStackException when the size of the Stack is 0.
   */
  @Override
  public Symbol pop() throws EmptyStackException {
    Entry pop = this.stack.pop();

    try {
      return pop.getSymbol();
    } catch (BadTypeException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * SymbolStack top.
   * 
   * @return item that the top of the Stack.
   * @throws EmptyStackException when the size of the Stack is 0.
   */
  @Override
  public Symbol top() throws EmptyStackException {
    Entry top = stack.top();

    try {
      return top.getSymbol();
    } catch (BadTypeException e) {
      e.printStackTrace();
    }
    return null;
  }

}

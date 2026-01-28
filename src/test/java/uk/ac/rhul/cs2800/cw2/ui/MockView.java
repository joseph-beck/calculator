package uk.ac.rhul.cs2800.cw2.ui;

import java.util.function.Consumer;
import uk.ac.rhul.cs2800.cw2.data.OperationType;

public class MockView implements ViewInterface {

  /**
   * Method that is ran when addCalculateObserver method is used.
   */
  public Runnable calculateObserver = null;
  /**
   * Method that is ran when addTypeObserver method is used.
   */
  public Consumer<OperationType> typeObserver = null;
  /**
   * Stores the answer value instead of it being displayed.
   */
  public String answer = null;
  /**
   * Stores the expression that would be inputed by the user.
   */
  public String expression;

  /**
   * Adds a calculate observer function to a global variable calculateObserver.
   * 
   * @param f, runnable function being assigned.
   */
  @Override
  public void addCalculateObserver(Runnable f) {
    this.calculateObserver = f;
  }

  /**
   * Adds a type observer consumer function to global variable typeObserver.
   * 
   * @param c, consumer function being assigned.
   */
  @Override
  public void addTypeObserver(Consumer<OperationType> c) {
    this.typeObserver = c;
  }

  /**
   * Get the expression normally given by the user, this is stored as a global variable.
   * 
   * @returns value of expression.
   */
  @Override
  public String getExpression() {
    return this.expression;
  }

  /**
   * Set the global answer variable of MockView.
   * 
   * @param a, value of the answer given.
   */
  @Override
  public void setAnswer(String a) {
    this.answer = a;
  }

  /**
   * Mock method for startView, this should not do anything in this case.
   */
  @Override
  public void startView() {}

}

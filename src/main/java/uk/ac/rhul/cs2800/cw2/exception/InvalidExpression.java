package uk.ac.rhul.cs2800.cw2.exception;

/**
 * An expression was passed to a method that could not be evaluated.
 * 
 * @author Joseph Beck
 */
public class InvalidExpression extends Exception {

  /**
   * Stores the serial version unique ID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Construct a new Invalid Expression.
   */
  public InvalidExpression() {
    super();
  }

}

package uk.ac.rhul.cs2800.cw2.exception;

/**
 * BadTypeException, thrown when a Type usage is incorrect.
 *
 * @author Joseph Beck
 */
public class BadTypeException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Message BadTypeException constructor. Calls the constructor of the SuperClass that takes one
   * parameter of String message.
   *
   * @param message of the error when it occurs.
   */
  public BadTypeException(String message) {
    super(message);
  }

}

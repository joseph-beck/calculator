package uk.ac.rhul.cs2800.cw2.data;

/**
 * Codifies the types of expression that we can calculate.
 * 
 * @author Dave Cohen, Joseph Beck
 */
public enum OperationType {
  STANDARD("Standard"), REVERSE_POLISH("Reverse Polish");

  /**
   * String representation of the OperationType enum.
   */
  private final String string;

  /**
   * Constructor for the OperationType.
   *
   * @param string representation of the OperationType enum.
   */
  private OperationType(String string) {
    this.string = string;
  }
  
  /**
   * Get the String representation of this OperationType enum.
   */
  @Override
  public String toString() {
    return this.string;
  }
}

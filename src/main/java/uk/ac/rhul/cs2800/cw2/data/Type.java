package uk.ac.rhul.cs2800.cw2.data;

/**
 * Stores the different possible Types and a corresponding String representation.
 *
 * @author Joseph Beck
 */
public enum Type {
  SYMBOL("Symbol"), NUMBER("Number"), STRING("String"), INVALID("Invalid");

  /**
   * String representation of the Type enum.
   */
  private final String string;

  /**
   * Constructor for the Type.
   *
   * @param string representation of the Type enum.
   */
  private Type(String string) {
    this.string = string;
  }

  /**
   * Get the String representation of this Type enum.
   */
  @Override
  public String toString() {
    return this.string;
  }

}

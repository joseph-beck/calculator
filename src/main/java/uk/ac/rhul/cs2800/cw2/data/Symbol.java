package uk.ac.rhul.cs2800.cw2.data;

/**
 * Stores the different possible Symbols and a corresponding String representation.
 *
 * @author Joseph Beck
 */
public enum Symbol {
  LEFT_BRACKET("Left Bracket", "("), RIGHT_BRACKET("Right Bracket", ")"), TIMES("Times", "*",
      5), DIVIDE("Divide", "/",
          5), PLUS("Plus", "+", 0), MINUS("Minus", "-", 0), INVALID("Invalid", "NaS");

  /**
   * String name of the Symbol enum.
   */
  private final String name;
  /**
   * String representation of the Symbol enum.
   */
  private final String symbol;
  /**
   * Precedence / importance of the Symbol, if this is -1 is does not need precedence.
   */
  private final int precedence;

  /**
   * Constructor for the Symbol.
   *
   * @param string representation of the Symbol enum.
   */
  private Symbol(String name, String symbol) {
    this.name = name;
    this.symbol = symbol;
    this.precedence = -1;
  }

  /**
   * Constructor for the Symbol with precedence.
   *
   * @param string representation of the Symbol enum.
   * @param precedence or importance of the Symbol.
   */
  private Symbol(String name, String symbol, int precedence) {
    this.name = name;
    this.symbol = symbol;
    this.precedence = precedence;
  }

  /**
   * Get the String representation of this Symbol enum.
   */
  @Override
  public String toString() {
    return this.name;
  }

  /**
   * From a String get a Symbol.
   * 
   * @param string being converted to Symbol.
   * @return Symbol of the given String.
   */
  public static Symbol fromString(String string) {
    switch (string) {
      case "(":
        return Symbol.LEFT_BRACKET;
      case ")":
        return Symbol.RIGHT_BRACKET;
      case "*":
        return Symbol.TIMES;
      case "/":
        return Symbol.DIVIDE;
      case "+":
        return Symbol.PLUS;
      case "-":
        return Symbol.MINUS;
      default:
        return Symbol.INVALID;
    }
  }

  /**
   * Symbols have corresponding characters, like times has *, add has +, etc.
   * 
   * @return representation of the Symbol.
   */
  public String getSymbol() {
    return this.symbol;
  }

  /**
   * Some symbols require an order of importance, this is declared in the constructor and can be
   * gotten here.
   * 
   * @return importance of the Symbol.
   */
  public int getPrecedence() {
    return this.precedence;
  }

}

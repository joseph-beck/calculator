package uk.ac.rhul.cs2800.cw2.data;

import uk.ac.rhul.cs2800.cw2.exception.BadTypeException;

/**
 * Entry class stores one of either a Symbol, float or String with a corresponding Type based on
 * what is being stored.
 *
 * @author Joseph Beck
 */
public class Entry {

  /**
   * Stores the symbol of Entry, will be null if it is not of Type SYMBOL.
   */
  private Symbol symbol;
  /**
   * Stores the number of Entry, will be null if it is not of Type NUMBER.
   */
  private float number;
  /**
   * Stores the string of Entry, will be null if it is not of Type STRING.
   */
  private String string;
  /**
   * Stores the Type of this Entry, used for verifying in get methods.
   */
  private Type type;

  /**
   * Empty constructor for Entry. This initialises Type to the INVALID Type.
   */
  public Entry() {
    this.type = Type.INVALID;
  }

  /**
   * Constructor for Entry. This initialises Type to the SYMBOL Type.
   *
   * @param value of the symbol.
   */
  public Entry(Symbol value) {
    this.symbol = value;
    this.type = Type.SYMBOL;
  }

  /**
   * Constructor for Entry. This initialises Type to the FLOAT Type.
   *
   * @param value of the float.
   */
  public Entry(float value) {
    this.number = value;
    this.type = Type.NUMBER;
  }

  /**
   * Constructor for Entry. This initialises Type to the STRING Type.
   *
   * @param value of the string.
   */
  public Entry(String value) {
    this.string = value;
    this.type = Type.STRING;
  }

  /**
   * Compares another Object to this Object.
   *
   * @return is other Object equal to this?
   */
  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Entry)) {
      return false;
    }
    Entry other = (Entry) obj;

    try {
      if (type == Type.SYMBOL) {
        return (symbol == other.getSymbol());
      } else if (type == Type.NUMBER) {
        return (number == other.getNumber());
      } else if (type == Type.STRING) {
        return (string.equals(other.getString()));
      }
    } catch (BadTypeException e) {
      return false;
    }

    return false;
  }

  /**
   * Returns the hash code of this Entry.
   *
   * @return hash code of this Entry.
   */
  @Override
  public int hashCode() {
    if (type == Type.SYMBOL) {
      return symbol.hashCode() * type.hashCode();
    } else if (type == Type.NUMBER) {
      return Float.floatToIntBits(number) * type.hashCode();
    } else if (type == Type.STRING) {
      return string.hashCode() * type.hashCode();
    }

    return type.hashCode();
  }

  /**
   * Get String representation of this Entry.
   *
   * @return String representation of this Entry.
   */
  @Override
  public String toString() {
    if (type == Type.SYMBOL) {
      return symbol.toString();
    } else if (type == Type.NUMBER) {
      return String.format("%.2f", number);
    } else if (type == Type.STRING) {
      return string;
    }

    return null;
  }

  /**
   * Gets the Symbol stored within the Entry.
   *
   * @return symbol
   * @throws BadTypeException if Entry is not of Type SYMBOL.
   */
  public Symbol getSymbol() throws BadTypeException {
    if (type != Type.SYMBOL) {
      throw new BadTypeException(
          String.format("Tried to get Type SYMBOL when Entry is type %s", type.toString()));
    }

    return symbol;
  }

  /**
   * Gets the float stored within the Entry.
   *
   * @return float
   * @throws BadTypeException if Entry is not of Type NUMBER.
   */
  public float getNumber() throws BadTypeException {
    if (type != Type.NUMBER) {
      throw new BadTypeException(
          String.format("Tried to get Type NUMBER when Entry is type %s", type.toString()));
    }

    return number;
  }

  /**
   * Gets the String value of the Entry.
   *
   * @return String value of the Entry.
   * @throws BadTypeException if Entry is not of Type STRING.
   */
  public String getString() throws BadTypeException {
    if (type != Type.STRING) {
      throw new BadTypeException(
          String.format("Tried to get Type STRING when Entry is type %s", type.toString()));
    }

    return string;
  }

  /**
   * Gets the Type of the Entry.
   *
   * @return Type of the Entry.
   */
  public Type getType() {
    return type;
  }

}

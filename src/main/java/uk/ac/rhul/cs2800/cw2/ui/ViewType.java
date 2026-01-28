package uk.ac.rhul.cs2800.cw2.ui;

/**
 * ViewType enum, stores the type of View that should be created, if INVALID is used something has
 * gone wrong.
 * 
 * @author Joseph Beck
 */
public enum ViewType {
  CALCULATOR("Calculator"), ASCII("Ascii"), INVALID("Invalid");

  /**
   * Store its String value.
   */
  private String string;

  /**
   * Create instance of the ViewType.
   * 
   * @param string value of the enum.
   */
  private ViewType(String string) {
    this.string = string;
  }

  /**
   * Get a String representation of the ViewType.
   * 
   * @return a string representation.
   */
  @Override
  public String toString() {
    return this.string;
  }

  /**
   * Get a view type from a string.
   * 
   * @param string type of view.
   * @return the view type.
   */
  public static ViewType fromString(String string) {
    switch (string) {
      case "Calculator":
        return ViewType.CALCULATOR;
      case "Ascii":
        return ViewType.ASCII;
      default:
        return ViewType.INVALID;
    }
  }

}

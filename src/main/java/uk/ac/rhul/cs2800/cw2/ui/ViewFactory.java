package uk.ac.rhul.cs2800.cw2.ui;

/**
 * ViewFactory allows a given ViewType to be created.
 * 
 * @author Joseph Beck
 */
public class ViewFactory {

  /**
   * Empty constructor for ViewFactory.
   */
  public ViewFactory() {}

  /**
   * Create a new view interface, if the type is ASCII a new instance of AsciiView will be returned,
   * if a CALCULATOR type is given an instance of CalculatorView will be returned. Otherwise null
   * will be given.
   * 
   * @param type of view interface.
   * @return the view instance of view interface.
   */
  public ViewInterface create(ViewType type) {
    switch (type) {
      case CALCULATOR:
        return CalculatorView.getInstance();
      case ASCII:
        return new AsciiView();
      default:
        return null;
    }
  }

}

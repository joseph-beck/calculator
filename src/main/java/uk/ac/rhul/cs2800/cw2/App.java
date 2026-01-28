package uk.ac.rhul.cs2800.cw2;

import uk.ac.rhul.cs2800.cw2.calculator.CalculatorController;
import uk.ac.rhul.cs2800.cw2.calculator.CalculatorModel;
import uk.ac.rhul.cs2800.cw2.ui.AsciiView;
import uk.ac.rhul.cs2800.cw2.ui.CalculatorView;
import uk.ac.rhul.cs2800.cw2.ui.ViewFactory;
import uk.ac.rhul.cs2800.cw2.ui.ViewInterface;
import uk.ac.rhul.cs2800.cw2.ui.ViewType;

/**
 * Contains the entry point of the program and runs the application.
 * 
 * @author Joseph Beck
 */
public class App {

  /**
   * Entry point of the program, creates a ViewFactory for the type of view of the program.
   * 
   * @param args of the program.
   */
  public static void main(String[] args) {
    ViewFactory viewFactory = new ViewFactory();
    ViewType viewType = (System.console() == null) ? ViewType.CALCULATOR : ViewType.ASCII;
    ViewInterface view = viewFactory.create(viewType);
    CalculatorController calculatorController = new CalculatorController(view);
    calculatorController.getView().startView();
  }

}

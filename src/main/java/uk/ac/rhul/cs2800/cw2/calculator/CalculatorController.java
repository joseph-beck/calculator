package uk.ac.rhul.cs2800.cw2.calculator;

import java.util.EmptyStackException;
import uk.ac.rhul.cs2800.cw2.data.OperationType;
import uk.ac.rhul.cs2800.cw2.exception.InvalidExpression;
import uk.ac.rhul.cs2800.cw2.ui.ViewInterface;

/**
 * The controller that sits between the calculator model that does actual evaluation and the view
 * that is the part the user interfaces with.
 */
public class CalculatorController {

  /**
   * Calculator Model instance, used for handling calculations.
   */
  private CalculatorModel model;
  /**
   * View of the Calculator, that the user will interact with.
   */
  private ViewInterface view;
  /**
   * Current OperationType state of the calculator, defaults REVERSE_POLISH on start up.
   */
  private OperationType type;

  /**
   * Create an instance of the CalculatorController. Also adds all handlers used by the view and
   * creates an instance of the calculator model used by the controller.
   * 
   * @param view being used by the model.
   */
  public CalculatorController(ViewInterface view) {
    this.view = view;
    this.init();
  }

  /**
   * Initialises the CalculatorController by creating an instance of CalculatorModel and assigns it
   * to model. Also adds handlers to the view if it is not null.
   */
  private void init() {
    this.model = new CalculatorModel();

    if (view == null) {
      return;
    }

    this.view.addCalculateObserver(this::handleCalculation);
    this.view.addTypeObserver(this::handleTypeChange);
  }

  /**
   * Handler for when the Calculate button is pressed, sets the answer to the calculated value with
   * the given expression. If the expression is invalid the answer will be filled Error.
   */
  private void handleCalculation() {
    String expression = this.view.getExpression();
    if (expression.contains("/ 0")) {
      this.view.setAnswer("Undefined");
      return;
    }

    try {
      boolean isInfix = this.type == OperationType.STANDARD;
      float result = model.evaluate(expression, isInfix);
      this.view.setAnswer(String.format("%f", result));
    } catch (InvalidExpression e) {
      this.view.setAnswer("Error");
    } catch (EmptyStackException e) {
      this.view.setAnswer("Error");
    } catch (Exception e) {
      this.view.setAnswer("Error");
    }
  }

  /**
   * Handler for when the OperationType of the Calculator is changed. This is a consumer function
   * that is given to a view.
   * 
   * @param type that this Controller is being changed to.
   */
  private void handleTypeChange(OperationType type) {
    this.type = type;
  }

  /**
   * Get the current view being used by the controller.
   * 
   * @return current instance of view.
   */
  public ViewInterface getView() {
    return this.view;
  }

  /**
   * Get the current model being used by the controller.
   * 
   * @return current instance of model.
   */
  public CalculatorModel getModel() {
    return this.model;
  }

}

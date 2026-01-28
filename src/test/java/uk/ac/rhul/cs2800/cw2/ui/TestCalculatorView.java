package uk.ac.rhul.cs2800.cw2.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.cw2.data.OperationType;
import java.util.function.Consumer;

/**
 * Brief test of the CalculatorView class. Some methods cannot be tested because they involve GUI
 * interactions.
 *
 * @author Joseph Beck.
 */
class TestCalculatorView {

  /**
   * Instance of CalculatorView being tested with.
   */
  private CalculatorView calculatorView;

  /**
   * Create an instance of the CalculatorView before each test.
   *
   * @throws Exception.
   */
  @BeforeEach
  void setUp() throws Exception {
    calculatorView = CalculatorView.getInstance();
  }

  /**
   * Try to add a Runnable, a calculate observer, to the CalculatorView.
   */
  @Test
  void testAddCalculateObserver() {
    Runnable f = () -> {
    };
    calculatorView.addCalculateObserver(f);
  }

  /**
   * Try to add a Consumer<OperationType>, the type observer, to the CalculatorView.
   */
  @Test
  void testAddTypeObserver() {
    Consumer<OperationType> c = (OperationType type) -> {
    };
    calculatorView.addTypeObserver(c);
  }

}

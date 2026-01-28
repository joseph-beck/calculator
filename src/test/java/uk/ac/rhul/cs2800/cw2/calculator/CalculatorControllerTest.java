package uk.ac.rhul.cs2800.cw2.calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.cw2.ui.AsciiView;
import uk.ac.rhul.cs2800.cw2.ui.ViewInterface;

/**
 * Test the CalculatorController and some of its basic functions that do not require a GUI event.
 * 
 * @author Joseph Beck
 */
class CalculatorControllerTest {

  /**
   * Instance of controller being tested against.
   */
  private CalculatorController controller;

  /**
   * Initialise controller for the tests that follow.
   * 
   * @throws Exception
   */
  @BeforeEach
  void setUp() throws Exception {
    ViewInterface view = new AsciiView();
    controller = new CalculatorController(view);
  }

  /**
   * Test that an instance of the CalculatorController is not null and of the correct class.
   */
  @Test
  void testCalculatorController() {
    assertNotNull(controller);
    assertEquals(controller.getClass(), CalculatorController.class);
  }

  /**
   * Test that an instance of CalculateController can still be created and not null even if the
   * given ViewInterface is null.
   */
  @Test
  void testNullView() {
    ViewInterface view = null;
    controller = new CalculatorController(view);

    assertNotNull(controller);
    assertEquals(controller.getClass(), CalculatorController.class);

    assertEquals(null, controller.getView());
  }

  /**
   * Test that the view of CalculatorController can be gotten and is not null and of the correct
   * class.
   */
  @Test
  void testGetView() {
    ViewInterface view = controller.getView();
    assertNotNull(view);
    assertEquals(view.getClass(), AsciiView.class);
  }

  /**
   * Test that the model of CalculatorController can be gotten and is not null and of the correct
   * class.
   */
  @Test
  void testGetModel() {
    CalculatorModel model = controller.getModel();
    assertNotNull(model);
    assertEquals(model.getClass(), CalculatorModel.class);
  }

}

package uk.ac.rhul.cs2800.cw2.ui;

import static org.junit.jupiter.api.Assertions.*;
import java.util.function.Consumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.cw2.calculator.CalculatorController;
import uk.ac.rhul.cs2800.cw2.data.OperationType;

/**
 * Test the views, this mostly uses the MockView in order to test view functionality.
 * 
 * @author Joseph Beck
 */
class ViewTest {

  /**
   * Stores the instance of ViewInterface being tested against, which should normally be a MockView.
   */
  private ViewInterface viewInterface;

  /**
   * Set up viewInterface variable before every test.
   * 
   * @throws Exception
   */
  @BeforeEach
  void setUp() throws Exception {
    viewInterface = new MockView();
  }

  /**
   * Tests that an instance of MockView can be created and is of the correct class.
   */
  @Test
  void testMockView() {
    assertNotNull(viewInterface);
    assertEquals(viewInterface.getClass(), MockView.class);
  }

  /**
   * Tests that an instance of AsciiView can be created and is of the correct class.
   */
  @Test
  void testAsciiView() {
    viewInterface = new AsciiView();
    assertNotNull(viewInterface);
    assertEquals(viewInterface.getClass(), AsciiView.class);
  }

  /**
   * Tests that an instance of CalculatorView can be created and is of the correct class.
   */
  @Test
  void testCalculatorView() {
    viewInterface = new CalculatorView();
    assertNotNull(viewInterface);
    assertEquals(viewInterface.getClass(), CalculatorView.class);
  }

  /**
   * Tests that a runnable, the calculateObserver, can be assigned to the MockView.
   */
  @Test
  void testAddCalculateObserver() {
    MockView viewInterface = new MockView();
    assertEquals(viewInterface.calculateObserver, null);
    Runnable function = () -> {
    };
    viewInterface.addCalculateObserver(function);
    assertNotEquals(viewInterface.calculateObserver, null);
  }

  /**
   * Tests that a consumer, the typeObserver, can be assigned to the MockView.
   */
  @Test
  void testAddTypeObserver() {
    MockView viewInterface = new MockView();
    assertEquals(viewInterface.typeObserver, null);
    Consumer<OperationType> consumer = (OperationType type) -> {
    };
    viewInterface.addTypeObserver(consumer);
    assertNotEquals(viewInterface.typeObserver, null);
  }

  /**
   * Tests that with a proper controller that the MockView calculateObserver correctly runs and
   * gives the correct expression and answer, when given a RPN expression.
   */
  @Test
  void testCalculateObserverOne() {
    MockView viewInterface = new MockView();
    new CalculatorController(viewInterface);
    viewInterface.expression = "2 1 +";
    viewInterface.calculateObserver.run();
    assertEquals(3f, Float.parseFloat(viewInterface.answer));
  }

  /**
   * Tests that with a proper controller that the MockView calculateObserver correctly runs when
   * given an expression that will throw and exception.
   */
  @Test
  void testCalculateObserverTwo() {
    MockView viewInterface = new MockView();
    new CalculatorController(viewInterface);
    viewInterface.typeObserver.accept(OperationType.STANDARD);
    viewInterface.expression = "(2 + 1))";
    viewInterface.calculateObserver.run();
    assertEquals("Error", viewInterface.answer);
  }

  /**
   * Tests that with a proper controller that the MockView typeObserver correctly runs and gives the
   * correct expression and answer, when type is changed to a STANDARD calculator.
   */
  @Test
  void testTypeObserver() {
    MockView viewInterface = new MockView();
    new CalculatorController(viewInterface);
    viewInterface.typeObserver.accept(OperationType.STANDARD);
    viewInterface.expression = "2 + 1";
    viewInterface.calculateObserver.run();
    assertEquals(3f, Float.parseFloat(viewInterface.answer));
  }

}

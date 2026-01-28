package uk.ac.rhul.cs2800.cw2.ui;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ViewFactoryTest {

  /**
   * Stores an instance of ViewFactory that is being tested against.
   *
   * @author Joseph Beck
   */
  private ViewFactory viewFactory;

  /**
   * Set up viewFactory variable before every test.
   *
   * @throws Exception
   */
  @BeforeEach
  void setUp() throws Exception {
    viewFactory = new ViewFactory();
  }

  /**
   * Test that an instance of ViewFactory can be created and it is not null and of the correct type.
   */
  @Test
  void testViewFactory() {
    viewFactory = new ViewFactory();
    assertNotNull(viewFactory);
    assertEquals(viewFactory.getClass(), ViewFactory.class);
  }

  /**
   * Test that an AsciiView is returned when the ViewFactory is given an ASCII view type.
   */
  @Test
  void testCreateOne() {
    ViewInterface viewInterface = viewFactory.create(ViewType.ASCII);
    assertEquals(AsciiView.class, viewInterface.getClass());
  }

  /**
   * Test that a CalculatorView is returned when the ViewFactory is given a CALCULATOR view type.
   */
  @Test
  void testCreateTwo() {
    ViewInterface viewInterface = viewFactory.create(ViewType.CALCULATOR);
    assertEquals(CalculatorView.class, viewInterface.getClass());
  }

  /**
   * Test that a null instance is returned when the ViewFactory is given an INVAID view type.
   */
  @Test
  void testCreateThree() {
    ViewInterface viewInterface = viewFactory.create(ViewType.INVALID);
    assertEquals(null, viewInterface);
  }
}

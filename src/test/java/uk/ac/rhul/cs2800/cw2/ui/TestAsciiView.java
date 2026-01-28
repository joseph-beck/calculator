package uk.ac.rhul.cs2800.cw2.ui;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Brief test of some AsciiView methods.
 * 
 * @author Joseph Beck
 */
class TestAsciiView {

  /*
   * Instance of AsciiView being tested against.
   */
  private AsciiView asciiView;

  /**
   * Creates instance of AsciiView before each test is ran.
   * 
   * @throws Exception
   */
  @BeforeEach
  void setUp() throws Exception {
    asciiView = new AsciiView();
  }

  /**
   * Tests the getExpression method, this should return a String "0".
   */
  @Test
  void testGetExpression() {
    String expression = asciiView.getExpression();
    assertTrue(expression.equals("0"));
  }

  /**
   * Test the setAnswer method, this shouldn't do anything except print out something to console.
   */
  @Test
  void testSetAnswer() {
    String answer = "0";
    asciiView.setAnswer(answer);
  }

}

package uk.ac.rhul.cs2800.cw2.calculator;

import uk.ac.rhul.cs2800.cw2.exception.InvalidExpression;

/**
 * An interface for defining an Evaluation Object.
 * 
 * @author Joseph Beck
 */
public interface EvaluationInterface {

  /**
   * Evaluates the given expression and returns the answer.
   * 
   * @param expression being evaluated.
   * @return the calculated value.
   * @throws InvalidExpression when the expression is incorrect and cannot be evaluated.
   */
  public abstract float evaluate(String expression) throws InvalidExpression;

}

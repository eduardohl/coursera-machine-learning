package normalequation

import breeze.linalg.DenseMatrix
import common.fileHelper
import org.scalatest.{FlatSpec, Matchers}

class NormalEquationCalculatorTest extends FlatSpec with Matchers {

  "A NormalEquationCalculator for x_input.csv dataset" should "converge to t0 ~ 27 and t1 ~ 100 " in {
    val x_input = fileHelper.csvread(this.getClass().getResourceAsStream("/x_input.csv"))
    val X = DenseMatrix.horzcat(DenseMatrix.ones[Double](x_input.size,1), x_input); //Concatenates a 1 vector to matrix
    
    val y = fileHelper.csvread(this.getClass().getResourceAsStream("/y_output.csv")).toDenseVector
    
    val theta = NormalEquationCalculator().forLinearRegression(X, y)
    math round theta(0) should be (27)
    math round theta(1) should be (100)
  }
}
package gradientdescent

import breeze.linalg.{DenseMatrix, DenseVector}
import common.fileHelper
import org.scalatest.{FlatSpec, Matchers}

class GradientDescentCalculatorTest extends FlatSpec with Matchers {

  "A GradientDescentCalculator for x_input.csv dataset" should "converge to t0 ~ 27 and t1 ~ 100 " in {
    val x_input = fileHelper.csvread(this.getClass().getResourceAsStream("/x_input.csv"))
    val normalized_x_input = FeatureNormalizeCalculator().compute(x_input)
    val X = DenseMatrix.horzcat(DenseMatrix.ones[Double](normalized_x_input.size,1), x_input); //Concatenates a 1 vector to matrix
    
    val y = fileHelper.csvread(this.getClass().getResourceAsStream("/y_output.csv")).toDenseVector
    val theta = GradientDescentCalculator().forLinearRegression(X, y, DenseVector.zeros(X.cols))
    math round theta(0) should be (27)
    math round theta(1) should be (100)
  }
}
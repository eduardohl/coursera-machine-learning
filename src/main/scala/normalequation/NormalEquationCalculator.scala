package normalequation

import breeze.linalg._


class NormalEquationCalculator {
  def forLinearRegression(X: DenseMatrix[Double], y: Vector[Double]): Vector[Double] = inv(X.t * X) * (X.t * y)
}

object NormalEquationCalculator {
  def apply() = new NormalEquationCalculator()
}

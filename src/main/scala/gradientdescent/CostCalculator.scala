package gradientdescent

import breeze.linalg.operators.OpPow
import breeze.linalg.{DenseMatrix, DenseVector, sum}

class CostCalculator {
  def compute(X: DenseMatrix[Double], y: DenseVector[Double], theta: DenseVector[Double]): Double =  {
    val m = y.length
    val hX = (X * theta) - y
    (1d/(2*m)) * sum(hX :^ 2d)
  }
}

object CostCalculator {
  def apply() = new CostCalculator()
}


package gradientdescent

import breeze.linalg.{DenseVector, DenseMatrix, Vector}

class GradientDescentCalculator {
  def forLinearRegression(X: DenseMatrix[Double], y: DenseVector[Double], theta: DenseVector[Double], alpha: Double = 0.001d, errorTolerance: Double = 1E-20d): DenseVector[Double] = {
    var mut_thetha = theta
    while (CostCalculator().compute(X, y, mut_thetha) > errorTolerance) {
      var sommation: DenseMatrix[Double] = DenseMatrix.zeros(1, X.cols)
      val hX = (X * mut_thetha) - y
      for(j <- 0 until y.size) {
        sommation = sommation + (X(j, ::) :* hX(j))
      }
      mut_thetha = mut_thetha - ((sommation.t :* (1d/y.length)) :* alpha).toDenseVector
    }
    mut_thetha
  }

}

object GradientDescentCalculator {
  def apply() = new GradientDescentCalculator()
}

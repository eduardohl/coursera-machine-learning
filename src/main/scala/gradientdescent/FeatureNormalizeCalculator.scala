package gradientdescent

import breeze.linalg.DenseMatrix
import breeze.stats.mean
import breeze.stats.stddev

class FeatureNormalizeCalculator {
  def compute(X: DenseMatrix[Double]): DenseMatrix[Double] =  {
    val mu = mean(X)
    val X_norm = X - mu
    val sigma = stddev(X_norm)
    X_norm.asInstanceOf[DenseMatrix[Double]] :/ sigma
  }
}

object FeatureNormalizeCalculator {
  def apply() = new FeatureNormalizeCalculator()
}

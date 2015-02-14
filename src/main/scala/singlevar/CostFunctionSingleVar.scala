package singlevar

class CostFunctionSingleVar (val t0: Double, val t1: Double) extends Function[Double, Double]{
  override def apply(v1: Double): Double = t0 + t1 * v1
}

object CostFunctionSingleVar {
  def apply(t0: Double, t1: Double) = new CostFunctionSingleVar(t0, t1)
}

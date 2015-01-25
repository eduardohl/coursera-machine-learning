class CostFunction (val t0: Double, val t1: Double) extends Function[Double, Double]{
  override def apply(v1: Double): Double = t0 + t1 * v1
}

object CostFunction {
  def apply(t0: Double, t1: Double) = new CostFunction(t0, t1)
}

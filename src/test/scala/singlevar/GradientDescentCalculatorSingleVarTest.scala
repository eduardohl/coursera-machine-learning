package singlevar

import org.scalatest.{FlatSpec, Matchers}

import scala.io.Source

class GradientDescentCalculatorSingleVarTest extends FlatSpec with Matchers {

  "A GradientDescentCalculatorSingleVar for single_var_data.csv dataset" should "converge to t0 ~ 27 and t1 ~ 100 " in {
    val samples = Source.fromURL(getClass.getResource("/single_var_data.csv")).getLines().toList.map(x => Sample.fromCsvString(x))
    val costFunction = GradientDescentCalculatorSingleVar().forLinearRegression(1486d, 8765d, samples)
    math round(costFunction t0) should be (27)
    math round(costFunction t1) should be (100)
  }
}

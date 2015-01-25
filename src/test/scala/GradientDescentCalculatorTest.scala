import org.scalatest.{Matchers, FlatSpec, FunSuite}
import scala.io.Source

/**
 * Created by eduardohl on 1/25/2015.
 */
class GradientDescentCalculatorTest extends FlatSpec with Matchers {

  "A GradientDescentCalculator for data.csv dataset" should "converge to t0 ~ 27 and t1 ~ 100 " in {
    val samples = Source.fromURL(getClass.getResource("/data.csv")).getLines().toList.map(x => Sample.fromCsvString(x))
    val costFunction = GradientDescentCalculator().forLinearRegression(1486d, 8765d, samples)
    math round(costFunction t0) should be (27)
    math round(costFunction t1) should be (100)
  }
}

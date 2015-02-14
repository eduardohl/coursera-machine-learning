package singlevar

class GradientDescentCalculatorSingleVar {

  //Alpha factor is the learning rate, using lower values makes the algorithm faster, but might not converge
  val AlphaFactor = 1e-3

  //This constant might be used to allow for a softer convergence criteria
  val StopConditionFactor = 1e-15

  def forLinearRegression(t0suggestion: Double, t1suggestion: Double, samples: List[Sample]): CostFunctionSingleVar = {
    var t0 = 0d
    var t1 = 0d
    var nextt0 = t0suggestion
    var nextt1 = t1suggestion

    var iterationCounter = 1
    while(stopCondition(t0, t1, nextt0, nextt1)) {
      //println(s"Iteration: $iterationCounter t0: $t0 and t1: $t1")
      iterationCounter += 1
      t0 = nextt0
      t1 = nextt1
      nextt0 = calculateT0(t0, t1, samples)
      nextt1 = calculateT1(t0, t1, samples)
    }

    CostFunctionSingleVar(t0, t1)
  }

  /**
   * The stop condition uses the constant StopConditionFactor to verify if t0 and t1 have converged
   * @param t0
   * @param t1
   * @param nextt0
   * @param nextt1
   * @return
   */
  def stopCondition(t0: Double, t1: Double, nextt0: Double, nextt1: Double): Boolean = {
    (math.abs(nextt0 - t0) > StopConditionFactor) && (math.abs(nextt1 - t1) > StopConditionFactor)
  }

  /**
   * Calculation of next value for T0 based on current guesses and sampleList
   * @param t0
   * @param t1
   * @param samples
   * @return
   */
  private def calculateT0(t0: Double, t1: Double, samples: List[Sample]) = {
    t0 - ((AlphaFactor / samples.length)* samples.foldRight(0d)((x, y) => y + ((t0 + t1 * x.input) - x.output)))
  }

  /**
   * Calculation of next value for T1 based on current guesses and sampleList
   * @param t0
   * @param t1
   * @param samples
   * @return
   */
  private def calculateT1(t0: Double, t1: Double, samples: List[Sample]) = {
    t1 - ((AlphaFactor / samples.length)* samples.foldRight(0d)((x, y) => y + (((t0 + t1 * x.input) - x.output) * x.input)))
  }
}

object GradientDescentCalculatorSingleVar {
  def apply() = new GradientDescentCalculatorSingleVar()
}

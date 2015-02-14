package singlevar

class Sample(val input: Int, val output: Int) {
  override def toString: String = s"Input: $input    Output:  $output"
}

object Sample {
  def apply(input: Int, output: Int) = new Sample(input, output)
  def fromCsvString(string : String): Sample = {
    val splitString = string.split(",")
    Sample(splitString(0).toInt, splitString(1).toInt)
  }
}

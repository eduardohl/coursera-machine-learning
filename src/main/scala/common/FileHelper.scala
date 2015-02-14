package common

import java.io.{InputStreamReader, InputStream, FileReader, File}

import breeze.io.CSVReader
import breeze.linalg.DenseMatrix

object fileHelper {
  def csvread(is: InputStream,
              separator: Char=',',
              quote: Char='"',
              escape: Char='\\',
              skipLines: Int = 0): DenseMatrix[Double] = {
    val inputStreamReader = new InputStreamReader(is)
    var mat = CSVReader.read(inputStreamReader, separator, quote, escape, skipLines)
    mat = mat.takeWhile(line => line.length != 0 && line.head.nonEmpty) // empty lines at the end
    is.close()
    inputStreamReader.close()
    if(mat.length == 0) {
      DenseMatrix.zeros[Double](0,0)
    } else {
      DenseMatrix.tabulate(mat.length,mat.head.length)((i,j)=>mat(i)(j).toDouble)
    }
  }
}

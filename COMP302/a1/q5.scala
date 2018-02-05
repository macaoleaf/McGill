def shoelace(fileName: String): Double = {
  val tokens = scala.io.Source.fromFile(fileName, "UTF-8").mkString.split("\\s+") // get rid of whitespaces
  val numbers = for (n <- tokens) yield n.toDouble
  val xny1 = numbers(1)*numbers(numbers.length-2) // second value in the formula
  val x1yn = numbers(0)*numbers(numbers.length-1) // fourth value in the formula
  def largerY(data: Array[Double], sum: Double, pos: Int, limit: Int): Double = pos match{
    case `limit` => sum
    case _ => largerY(numbers, sum + numbers(pos-3)*numbers(pos), pos+2, limit)
  }
  val xY = largerY(numbers, 0, 3, numbers.length+1) // first value in the formula
  def largerX(data: Array[Double], sum: Double, pos: Int, limit: Int): Double = pos match{
    case `limit` => sum
    case _ => largerX(numbers, sum + numbers(pos-1)*numbers(pos), pos+2, limit)
  }
  val Xy = largerX(numbers, 0, 2, numbers.length) // third value in the formula
  val area = 0.5*Math.abs(xY + xny1 - Xy - x1yn) // the whole formula
  area
}

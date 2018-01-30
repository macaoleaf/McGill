def euler(k: Int): Double = {
  def evalPi(k: Int, sum: Double): Double = k match {
    case 0 => Math.sqrt(6 * sum) // get the value of pi from the sum
    case _ => evalPi(k - 1, sum + (1.toDouble)/((k * k).toDouble)) // sum by the formula
  }
  evalPi(k, 0)
}
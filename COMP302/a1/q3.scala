def fib2(n: Int): Int = {
  def rest(n: Int, front: Int, back: Int): Int = n match {
    case 0 => back // after calculating n times, return the sum
    case _ => rest(n-1, back, front + back) // adding process in parameters for efficiency 
  }
  rest(n, 0, 1)
}

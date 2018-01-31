 def show(n: List[Any]): String = {
  if(n.length == 0) return "Nil" // no element case
  else if(n.length == 1) return (n(0).toString + "::Nil") // no brackets case
  def nest(n: List[Any], index: Int, bound: Int, output: String): String = index match {
    case 0 => nest(n, 1, bound, output + n(index).toString + "::") // first element without bracket
    case `bound` => output + "Nil" + (")" * (n.length - 1)) // add the tail and output
    case _ => nest(n, index + 1, bound, output + "(" + n(index).toString + "::") // add :: and ( with the element in the middle
  }
  nest(n, 0, n.length, "")
}

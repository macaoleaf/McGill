def cakes(n: Int): Boolean = {
  def judge(n: Int, tf: Boolean): Boolean = {
    if(n == 40) return true // if the number remaining is what we want, return true
    if(n%2 == 0 && n >= 80 && judge(n/2, false)) return true // condition 1
    if((n%3 == 0 || n%4 == 0) && (n%10 != 0) && ((n/10)%10 != 0) && judge(n-(n%10)*((n/10)%10), false)) return true // condition 2
    if(n%5 == 0 && n >= 80 && judge(n-40, false)) return true // condition 3
    false // after all practices and still can't get 40, return false
  }
  judge(n, false)
}